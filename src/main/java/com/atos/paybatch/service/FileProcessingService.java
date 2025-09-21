package com.atos.paybatch.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.atos.paybatch.dto.FileProcessingResult;
import com.atos.paybatch.dto.ParsedFileDTO;
import com.atos.paybatch.dto.PaymentRecordDTO;
import com.atos.paybatch.entity.InboundFile;
import com.atos.paybatch.entity.PaymentChannel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileProcessingService {

    private final FileStorageService fileStorageService;
    private final FileParserService parserService;
    private final RecordProcessingService recordProcessingService;
    private final InboundFileService inboundFileService;

    @Value("${payment.input-dir}")
    private String inputDir;


    @Scheduled(fixedDelayString = "${paybatch.schedule.interval:5m}")
    public void scheduledFileProcessing() {
        log.info("Starting scheduled file processing");

        try {
            processFiles();
        } catch (Exception e) {
            log.error("Error during file processing", e);
        }

        log.info("Finished scheduled file processing");
    }

    
    
    
    public void processFiles() {
        File folder = new File(inputDir);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".in"));

        if (files == null || files.length == 0) {
            log.info("No new files to process.");
            return;
        }

        for (File file : files) {
            try {
                FileProcessingResult result = processSingleFile(file);
                log.info("File {} processed: {} success, {} errors", 
                         result.getFileName(), result.getSuccessCount(), result.getErrorCount());
            } catch (Exception e) {
                log.error("Error processing file {}: {}", file.getName(), e.getMessage(), e);
                fileStorageService.moveFileSafely(file, fileStorageService.getErrorDir());
            }
        }
    }

    // Process a single file with improved structure
    public FileProcessingResult processSingleFile(File file) throws Exception {
        log.info("Processing file: {}", file.getName());
        FileProcessingResult result = new FileProcessingResult(file.getName());

        // Step 1: Rename file to .tmp (File operation, not inside DB transaction)
        File tmpFile = fileStorageService.renameFileToTmp(file);

        // Step 2: Create entity record for this file 
        InboundFile inboundFile = inboundFileService.initInboundFile(file.getName());

        // Step 3: Check duplicates using checksum (transactional)
        String checksum = fileStorageService.calculateChecksum(tmpFile);
        if (inboundFileService.isDuplicate(checksum)) {
            inboundFileService.handleDuplicateFile(tmpFile, inboundFile, checksum);
            return result;
        }
        inboundFile.setFileChecksum(checksum);

        // Step 4: Parse file header, details, trailer
        ParsedFileDTO parsed = parserService.parseAndValidateFile(tmpFile);
        if (!parsed.isValid()) {
            inboundFileService.handleInvalidFile(tmpFile, inboundFile, parsed.getErrors());
            return result;
        }

        // Step 5: Resolve payment channel
        PaymentChannel channel = inboundFileService.resolveChannel(parsed.getHeader().getBankCode());
        inboundFile.setChannel(channel);

        // Save metadata before processing records
        inboundFileService.saveInboundFile(inboundFile);
        inboundFileService.saveHeader(parsed.getHeader(), inboundFile);
        inboundFileService.saveTrailer(parsed.getTrailer(), inboundFile);

        // Step 6: Process payment records (batch transaction)
        processPaymentRecords(parsed.getRecords(), inboundFile, result);

        // Step 7: Update final counts and status
        inboundFileService.updateCountsAndStatus(inboundFile, 
                result.getTotalRecords(), result.getSuccessCount(), result.getErrorCount(), "P");

        // Step 8: Move file to processed directory only after successful commit
        fileStorageService.moveFileToProcessed(tmpFile);

        return result;
    }

    private void processPaymentRecords(List<PaymentRecordDTO> records, InboundFile inboundFile, FileProcessingResult result) {
        int successCount = 0;
        int errorCount = 0;

        for (PaymentRecordDTO recordDto : records) {
            boolean success = recordProcessingService.processSingleRecord(recordDto, inboundFile);
            if (success) {
                successCount++;
            } else {
                errorCount++;
            }
        }

        result.setTotalRecords(records.size());
        result.setSuccessCount(successCount);
        result.setErrorCount(errorCount);
    }
}
