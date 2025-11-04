package com.atos.paybatch.service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.atos.paybatch.dto.FileProcessingResult;
import com.atos.paybatch.dto.ParsedFileDTO;
import com.atos.paybatch.entity.PayBatchChannel;
import com.atos.paybatch.entity.PayBatchFile;
import com.atos.paybatch.entity.PayBatchRecord;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileProcessorService {

    private final FileStorageService fileStorageService;
    private final FileParserService fileParserService;
    private final FileHandlerService fileHandlerService;
    private final RecordProcessorService recordProcessorService;

    @Value("${payment.input-dir}")
    private String inputDir;

    @Scheduled(fixedDelayString = "${paybatch.schedule.interval:5m}")
    public void scheduledFileProcessing() {
        log.info("───────────────────────────────────────────────────────────────────────────────");
        log.info("[JOB_START] Scanning input directory: '{}'.", inputDir);

        try {
            processFiles();
        } catch (Exception e) {
            log.error("[JOB_ERROR] Unexpected exception during file processing | error={}", e.getMessage(), e);
        }

        log.info("[JOB_END  ] Job Finished.");
        log.info("───────────────────────────────────────────────────────────────────────────────");
    }

    public void processFiles() {
        File folder = new File(inputDir);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".in"));

        if (files == null || files.length == 0) {
            log.info("[NO_FILES ] No input files found in directory '{}'", inputDir);
            return;
        }

        log.info("[FILES_FOUND   ] {} file(s) found in '{}'", files.length, inputDir);

        for (File file : files) {
            log.info("───────────────────────────────────────────────────────────────────────────────");
            log.info("[FILE_START    ] Processing file '{}'", file.getName());

            File tmpFile = null;
            try {
                // Step 1: Rename to .tmp for processing
                log.info("→ Step 1: Preparing file for processing...");
                tmpFile = fileStorageService.renameFileToTmp(file);

                // Step 2: Process file
                FileProcessingResult result = processSingleFile(tmpFile);

                if (result.isProcessedSuccessfully()) {
                    log.info("[FILE_SUCCESS  ] File '{}' processed successfully | totalRecords={} | success={} | errors={}",
                            result.getFileName(), result.getTotalRecords(), result.getSuccessCount(), result.getErrorCount());
                } else {
                    log.warn("[FILE_FAILED   ] File '{}' encountered processing issues | errors={}",
                            result.getFileName(), result.getErrorCount());
                }

            } catch (Exception e) {
                log.error("[FILE_ERROR    ] Unexpected error while processing '{}' | {}", file.getName(), e.getMessage(), e);
                fileHandlerService.handleInvalidFile(
                        tmpFile != null ? tmpFile : file,
                        null,
                        List.of("Unexpected error: " + e.getMessage())
                );
            }

            log.info("[FILE_END      ] Finished processing '{}'", file.getName());
            log.info("───────────────────────────────────────────────────────────────────────────────");
        }
    }

    public FileProcessingResult processSingleFile(File tmpFile) throws Exception {
        log.info("→ Step 2: Initializing file record for '{}'", tmpFile.getName());
        FileProcessingResult result = new FileProcessingResult(tmpFile.getName());
        PayBatchFile batchFile = fileHandlerService.initFile(tmpFile.getName());

        // Step 3: Check for duplicates
        log.info("→ Step 3: Checking for duplicate file...");
        String checksum = fileStorageService.calculateChecksum(tmpFile);
        if (fileHandlerService.isDuplicate(checksum)) {
            log.warn("[DUPLICATE_FILE] File '{}' already processed | checksum={}", tmpFile.getName(), checksum);
            fileHandlerService.handleDuplicateFile(tmpFile, batchFile, checksum);
            return result;
        }
        batchFile.setFileChecksum(checksum);

        // Step 4: Parse and validate content
        log.info("→ Step 4: Parsing and validating file '{}'", tmpFile.getName());
        ParsedFileDTO parsed = fileParserService.parseAndValidateFile(tmpFile);
        if (!parsed.isValid()) {
            log.error("[VALIDATION_FAILED] File '{}' validation errors: {}", tmpFile.getName(), parsed.getErrors());
            fileHandlerService.handleInvalidFile(tmpFile, batchFile, parsed.getErrors());
            return result;
        }

        // Step 5: Resolve payment channel
        log.info("→ Step 5: Resolving payment channel for bankCode='{}'", parsed.getHeader().getBankCode());
        PayBatchChannel channel = fileHandlerService.resolveChannel(parsed.getHeader().getBankCode());
        if (channel == null) {
            String errorMsg = "No matching channel found for bank code: " + parsed.getHeader().getBankCode();
            log.error("[CHANNEL_MISSING] {}", errorMsg);
            fileHandlerService.handleInvalidFile(tmpFile, batchFile, List.of(errorMsg));
            return result;
        }

        if (channel.getGlCode() == null || channel.getGlCode().isBlank()) {
            String errorMsg = "Channel found for bank code " + parsed.getHeader().getBankCode() + " but GL Code is missing";
            log.error("[GL_CODE_MISSING] {}", errorMsg);
            fileHandlerService.handleInvalidFile(tmpFile, batchFile, List.of(errorMsg));
            return result;
        }

        batchFile.setChannel(channel);

        // Step 6: Persist records
        log.info("→ Step 6: Saving parsed data to database...");
        List<PayBatchRecord> paymentRecords = fileHandlerService.saveAllFileData(batchFile, parsed);

        // Step 7: Process records
        log.info("→ Step 7: Processing {} record(s)...", paymentRecords.size());
        processPaymentRecords(paymentRecords, batchFile, result);

        // Step 8: Finalize file and move to processed directory
        log.info("→ Step 8: Finalizing file '{}' post-processing", tmpFile.getName());
        fileHandlerService.handleFilePostProcessing(tmpFile, batchFile, result);

        log.info("[FILE_COMPLETED] File '{}' fully processed | totalRecords={} | success={} | errors={}",
                tmpFile.getName(), result.getTotalRecords(), result.getSuccessCount(), result.getErrorCount());
        return result;
    }

    private void processPaymentRecords(List<PayBatchRecord> records, PayBatchFile payBatchFile, FileProcessingResult result) {
        int successCount = 0;
        int errorCount = 0;

        for (PayBatchRecord record : records) {
            boolean success = recordProcessorService.processRecord(record, payBatchFile.getChannel().getGlCode());
            if (success) successCount++;
            else errorCount++;
        }

        result.setTotalRecords(records.size());
        result.setSuccessCount(successCount);
        result.setErrorCount(errorCount);
        result.markAsSuccessful();

        log.info("[RECORDS_SUMMARY] total={} | success={} | failed={}", records.size(), successCount, errorCount);
    }
}
