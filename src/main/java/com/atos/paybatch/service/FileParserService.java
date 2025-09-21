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

@Service
@Slf4j
@RequiredArgsConstructor
public class FileParserService {

    private static final int HEADER_LENGTH = 74;
    private static final int DETAIL_LENGTH = 99;
    private static final int TRAILER_LENGTH = 24;

    /**
     * Parses the given file into DTOs for header, records, and trailer.
     * Performs validation of total records and total amount against trailer.
     */
    public ParsedFileDTO parseAndValidateFile(File file) throws Exception {
        ParsedFileDTO parsedFile = new ParsedFileDTO();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNo = 0;
            List<PaymentRecordDTO> records = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                lineNo++;
                if (line.isBlank()) continue;

                char recType = line.charAt(0);

                switch (recType) {
                    case '1':
                        parsedFile.setHeader(parseHeader(line, parsedFile));
                        break;
                    case '2':
                        records.add(parseDetail(line, lineNo, parsedFile));
                        break;
                    case '3':
                        parsedFile.setTrailer(parseTrailer(line, parsedFile));
                        break;
                    default:
                        parsedFile.addError("Unknown record type at line " + lineNo);
                }
            }

            parsedFile.setRecords(records);

         // validate record count and total amounts against trailer
            validateTotals(parsedFile); 

        }

        return parsedFile;
    }

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
        header.setBankCode(line.substring(1, 21).trim());
        header.setFileDate(line.substring(21, 29));
        header.setBankAccount(line.substring(29, 54).trim());
        header.setBankCompCode(line.substring(54, 74).trim());

        return header;
    }

    private PaymentRecordDTO parseDetail(String line, int lineNo, ParsedFileDTO parsedFile) {
        PaymentRecordDTO record = new PaymentRecordDTO();
        record.setRawLine(line);
        record.setLineNo((long) lineNo);

        // Check if the detail line has the correct length
        if (line.length() != DETAIL_LENGTH) {
        	record.setValid(false);
            record.setError("Invalid payment record length at line " + lineNo);
            parsedFile.addError(record.getError()); // mark the file as invalid
            return record; // skip parsing fields for this record
        }

        // Parse valid record fields
        record.setRecType(line.substring(0, 1));
        record.setPaymentType(Integer.parseInt(line.substring(1, 2)));
        record.setBankAccount(line.substring(2, 27).trim());
        record.setCustomerCode(line.substring(27, 47).trim());
        record.setInvoiceNo(line.substring(47, 77).trim());

        // Parse payment amount: first 9 digits integer part, last 3 digits decimal
        String amountStr = line.substring(77, 89);
        long intPart = Long.parseLong(amountStr.substring(0, 9));
        int decimalPart = Integer.parseInt(amountStr.substring(9, 12));
        record.setPaymentAmount(intPart + decimalPart / 1000.0);

        record.setPaymentDate(line.substring(89, 97));
        record.setRejectionReason(line.substring(97, 99));

        return record;
    }

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
        trailer.setTotalRecords(Long.parseLong(line.substring(1, 9)));

        String amountStr = line.substring(9, 24);
        long intPart = Long.parseLong(amountStr.substring(0, 9));
        int decimalPart = Integer.parseInt(amountStr.substring(9, 12));
        trailer.setTotalAmount(intPart + decimalPart / 1000.0);

        trailer.setValid(true);
        return trailer;
    }


    // Validates that total number of records and sum of amounts match trailer
    private void validateTotals(ParsedFileDTO parsedFile) {
        List<PaymentRecordDTO> records = parsedFile.getRecords();
        FileTrailerDTO trailer = parsedFile.getTrailer();

        if (trailer == null) {
            parsedFile.addError("Trailer missing for validation.");
            return;
        }

        long validRecordCount = records.stream().filter(PaymentRecordDTO::isValid).count();
        double sumAmounts = records.stream()
                .filter(PaymentRecordDTO::isValid)
                .mapToDouble(PaymentRecordDTO::getPaymentAmount)
                .sum();

        if (validRecordCount != trailer.getTotalRecords()) {
            parsedFile.addError("Record count mismatch. Trailer: " + trailer.getTotalRecords() + ", Parsed: " + validRecordCount);
        }

        // tolerance to handle floating point rounding issues
        if (Math.abs(sumAmounts - trailer.getTotalAmount()) > 0.001) {
            parsedFile.addError("Total amount mismatch. Trailer: " + trailer.getTotalAmount() + ", Calculated: " + sumAmounts);
        }
    }
}
