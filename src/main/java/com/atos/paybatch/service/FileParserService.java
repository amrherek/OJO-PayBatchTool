package com.atos.paybatch.service;

import com.atos.paybatch.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Service to parse structured payment files containing header, detail records, and trailer.
 * Validates file format and ensures record count and total amounts match the trailer section.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class FileParserService {

    // Fixed record lengths for each section
    private static final int HEADER_LENGTH = 74;
    private static final int DETAIL_LENGTH = 99;
    private static final int TRAILER_LENGTH = 24;

    /**
     * Parses a file into Header, Records, and Trailer objects.
     * Performs validation for total records and total amount.
     *
     * @param file input payment file
     * @return parsed file DTO containing header, records, trailer, and errors
     * @throws Exception if file read or parsing fails
     */
    public ParsedFileDTO parseAndValidateFile(File file) throws Exception {
        ParsedFileDTO parsedFile = new ParsedFileDTO();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNo = 0;
            List<PaymentRecordDTO> records = new ArrayList<>();

            log.debug("Parsing file: {}", file.getName().replaceFirst("\\.tmp$", ""));

            while ((line = br.readLine()) != null) {
                lineNo++;
                if (line.isBlank()) continue;

                char recType = line.charAt(0);
                switch (recType) {
                    case '1' -> {
                        FileHeaderDTO header = parseHeader(line, parsedFile);
                        parsedFile.setHeader(header);
                        if (!header.isValid()) {
                            parsedFile.setValid(false);
                            return parsedFile; // stop immediately on error
                        }
                    }
                    case '2' -> {
                        PaymentRecordDTO record = parseDetail(line, lineNo, parsedFile);
                        records.add(record);
                        if (!record.isValid()) {
                            parsedFile.setValid(false);
                            return parsedFile; // stop immediately on error
                        }
                    }
                    case '3' -> {
                        FileTrailerDTO trailer = parseTrailer(line, parsedFile);
                        parsedFile.setTrailer(trailer);
                        if (!trailer.isValid()) {
                            parsedFile.setValid(false);
                            return parsedFile; // stop immediately on error
                        }
                    }
                    default -> {
                        parsedFile.addError("Unknown record type at line " + lineNo);
                        parsedFile.setValid(false);
                        return parsedFile; // stop immediately on error
                    }
                }
            }

            parsedFile.setRecords(records);

            // Only validate totals if parsing succeeded
            if (parsedFile.isValid()) {
                validateTotals(parsedFile);
            }

            log.debug("File parsed successfully: {}", file.getName().replaceFirst("\\.tmp$", ""));
        }

        return parsedFile;
    }

    /**
     * Parses header line into FileHeaderDTO.
     */
    private FileHeaderDTO parseHeader(String line, ParsedFileDTO parsedFile) {
        FileHeaderDTO header = new FileHeaderDTO();
        header.setRawLine(line);

        if (line.length() != HEADER_LENGTH) {
            header.setValid(false);
            header.setError("Invalid header length: " + line.length());
            parsedFile.addError(header.getError());
            return header;
        }

        header.setRecType(line.substring(0, 1));

        String bankCode = line.substring(1, 21).trim().replaceFirst("^0+", "");
        header.setBankCode(bankCode.isEmpty() ? "0" : bankCode);

        header.setFileDate(line.substring(21, 29));
        header.setBankAccount(line.substring(29, 54).trim());
        header.setBankCompCode(line.substring(54, 74).trim());

        header.setValid(true);
        return header;
    }


    /**
     * Parses detail record line into PaymentRecordDTO.
     */
    private PaymentRecordDTO parseDetail(String line, int lineNo, ParsedFileDTO parsedFile) {
        PaymentRecordDTO record = new PaymentRecordDTO();
        record.setRawLine(line);
        record.setLineNo((long) lineNo);

        if (line.length() != DETAIL_LENGTH) {
            record.setValid(false);
            record.setError("Invalid payment record length at line " + lineNo);
            parsedFile.addError(record.getError());
            return record;
        }

        record.setRecType(line.substring(0, 1));
        record.setPaymentType(Integer.parseInt(line.substring(1, 2)));
        record.setBankAccount(line.substring(2, 27).trim());
        record.setCustomerCode(line.substring(27, 47).trim().replaceFirst("^0+", ""));
        record.setInvoiceNo(line.substring(47, 77).trim());

        // Parse payment amount
        String amountStr = line.substring(77, 89);
        try {
            long intPart = Long.parseLong(amountStr.substring(0, 9));
            int decimalPart = Integer.parseInt(amountStr.substring(9, 12));
            record.setPaymentAmount(intPart + decimalPart / 1000.0);
        } catch (NumberFormatException e) {
            record.setValid(false);
            record.setError("Invalid payment amount at line " + lineNo);
            parsedFile.addError(record.getError());
            return record;
        }

        record.setPaymentDate(line.substring(89, 97));
        record.setRejectionReason(line.substring(97, 99));

        record.setValid(true);
        return record;
    }

    /**
     * Parses trailer line into FileTrailerDTO.
     */
    private FileTrailerDTO parseTrailer(String line, ParsedFileDTO parsedFile) {
        FileTrailerDTO trailer = new FileTrailerDTO();
        trailer.setRawLine(line);

        if (line.length() != TRAILER_LENGTH) {
            trailer.setValid(false);
            trailer.setError("Invalid trailer length: " + line.length());
            parsedFile.addError(trailer.getError());
            return trailer;
        }

        trailer.setRecType(line.substring(0, 1));
        try {
            trailer.setTotalRecords(Long.parseLong(line.substring(1, 9)));

            String amountStr = line.substring(9, 24);
            long intPart = Long.parseLong(amountStr.substring(0, 12));
            int decimalPart = Integer.parseInt(amountStr.substring(12, 15));
            trailer.setTotalAmount(intPart + decimalPart / 1000.0);
        } catch (NumberFormatException e) {
            trailer.setValid(false);
            trailer.setError("Invalid trailer numbers");
            parsedFile.addError(trailer.getError());
            return trailer;
        }

        trailer.setValid(true);
        return trailer;
    }



    /**
     * Validates that record count & total amounts match trailer values.
     */
    private void validateTotals(ParsedFileDTO parsedFile) {
        List<PaymentRecordDTO> records = parsedFile.getRecords();
        FileTrailerDTO trailer = parsedFile.getTrailer();

        if (trailer == null || records == null) {
            parsedFile.setValid(false);
            parsedFile.addError("Cannot validate totals: missing trailer or records.");
            return;
        }

        long validCount = records.stream()
                .filter(PaymentRecordDTO::isValid)
                .count();

        double totalAmount = records.stream()
                .filter(PaymentRecordDTO::isValid)
                .mapToDouble(PaymentRecordDTO::getPaymentAmount)
                .sum();

        if (validCount != trailer.getTotalRecords()) {
            String error = String.format(
                    "Record count mismatch: trailer=%d, parsed=%d",
                    trailer.getTotalRecords(), validCount
            );
            parsedFile.setValid(false);
            parsedFile.addError(error);
            return;  // stop immediately
        }

        if (Math.abs(totalAmount - trailer.getTotalAmount()) > 0.001) {
            String error = String.format(
                    "Total amount mismatch: trailer=%.3f, calculated=%.3f",
                    trailer.getTotalAmount(), totalAmount
            );
            parsedFile.setValid(false);
            parsedFile.addError(error);
        }
    }



    /**
     * Formats customer code based on business rules for digit grouping and dot insertion.
     */
    public static String formatCustomerCode(String input) {
        final int MAX_GROUPS = 2;

        if (input == null) return "";
        String s = input.trim().replaceFirst("^0+", "");
        if (s.isEmpty()) return "";

        char first = s.charAt(0);
        if (!Character.isDigit(first) || first < '1' || first > '8') return s;
        if (first == '1') return (s.length() > 1) ? first + "." + s.substring(1) : String.valueOf(first);

        int groupSize = Character.getNumericValue(first);
        StringBuilder sb = new StringBuilder().append(first).append('.');
        int pos = 1, len = s.length();

        if (len - pos <= groupSize) return sb.append(s.substring(pos)).toString();

        sb.append(s, pos, pos + groupSize).append('.');
        pos += groupSize;

        int groups = 0;
        while (groups < MAX_GROUPS && pos < len) {
            int take = Math.min(2, len - pos);
            sb.append(s, pos, pos + take);
            pos += take;
            groups++;
            if (pos < len && groups < MAX_GROUPS) sb.append('.');
        }

        if (pos < len) sb.append('.').append(s.substring(pos));
        return sb.toString();
    }
}
