package com.atos.paybatch.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.paybatch.dto.FileHeaderDTO;
import com.atos.paybatch.dto.FileTrailerDTO;
import com.atos.paybatch.entity.FileHeader;
import com.atos.paybatch.entity.FileTrailer;
import com.atos.paybatch.entity.InboundFile;
import com.atos.paybatch.entity.PaymentChannel;
import com.atos.paybatch.repository.FileHeaderRepository;
import com.atos.paybatch.repository.FileTrailerRepository;
import com.atos.paybatch.repository.InboundFileRepository;
import com.atos.paybatch.repository.PaymentChannelRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Service for handling inbound file processing, including metadata persistence,
 * duplicate detection, error handling, and status updates.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class InboundFileService {

    private final InboundFileRepository inboundFileRepository;
    private final FileHeaderRepository fileHeaderRepository;
    private final FileTrailerRepository fileTrailerRepository;
    private final FileStorageService fileStorageService;
    
    private final PaymentChannelRepository channelRepository;
    private final String genericChannelCode = "GENERIC";


    
    

    // -------------------------------------------------------
    // File Initialization & Validation
    // -------------------------------------------------------

    /**
     * Creates and persists a new InboundFile record with initial metadata.
     */

    public InboundFile initInboundFile(String filename) {
        InboundFile inboundFile = new InboundFile();
        inboundFile.setFilename(filename);
        inboundFile.setStatus("I");
        return inboundFile;
    }
    
    @Transactional
    public void saveInboundFile(InboundFile inboundFile) {
        inboundFileRepository.save(inboundFile);
	}
    
    
    /**
     * Resolves a payment channel based on filename.
     * Falls back to generic channel if none matched.
     */
    public PaymentChannel resolveChannel(String bankCodeFromHeader) {
        Optional<PaymentChannel> channel = channelRepository.findAll().stream()
                .filter(c -> String.format("%20s", c.getChannelCode()).replace(' ', '0')
                        .equals(bankCodeFromHeader))
                .findFirst();

        if (channel.isPresent()) return channel.get();

        log.warn("No channel match for bank code {}. Using generic channel.", bankCodeFromHeader);
        return channelRepository.findByChannelCode(genericChannelCode)
                .orElse(null);
    }


    /**
     * Checks if a file with the given checksum already exists in the database.
     */
    public boolean isDuplicate(String checksum) {
    	return inboundFileRepository.existsByFileChecksumAndStatus(checksum, "P");
    }

    // -------------------------------------------------------
    // File Error & Duplicate Handling
    // -------------------------------------------------------

    /**
     * Marks the file as invalid, saves error details, and moves the file
     * to the error directory.
     * @param inboundFile 
     */
    @Transactional
    public void handleInvalidFile(File file, InboundFile inboundFile, List<String> errors ) {
    	
        inboundFile.setStatus("F"); // Failed
        inboundFile.setRemark(String.join("; ", errors));
        inboundFileRepository.save(inboundFile);
        fileStorageService.moveFileToError(file);
        log.warn("File {} rejected: {}", file.getName(), String.join("; ", errors));
    }

    /**
     * Marks the file as duplicate, saves metadata, and moves it to the
     * duplicate folder.
     * @param inboundFile 
     */
    @Transactional
    public void handleDuplicateFile(File file, InboundFile duplicateFile, String checksum) {
        duplicateFile.setStatus("D"); // Duplicate
        duplicateFile.setFileChecksum(checksum);
        duplicateFile.setRemark("Duplicate file detected");
        inboundFileRepository.save(duplicateFile);

        fileStorageService.moveFileToDuplicate(file);
        log.warn("Duplicate file {} recorded in DB and moved", file.getName());
    }

    // -------------------------------------------------------
    // File Header & Trailer Persistence
    // -------------------------------------------------------

    /**
     * Saves the file header metadata in the database.
     */
    @Transactional
    public void saveHeader(FileHeaderDTO headerDTO, InboundFile inboundFile) {
        if (headerDTO != null) {
            FileHeader header = new FileHeader();
            header.setInboundFile(inboundFile);
            header.setRecType(headerDTO.getRecType());
            header.setBankCode(headerDTO.getBankCode());
            header.setFileDate(headerDTO.getFileDate());
            header.setBankAccount(headerDTO.getBankAccount());
            header.setBankCompCode(headerDTO.getBankCompCode());
            header.setRawLine(headerDTO.getRawLine());
            fileHeaderRepository.save(header);
        }
    }

    /**
     * Saves the file trailer metadata in the database.
     */
    @Transactional
    public void saveTrailer(FileTrailerDTO trailerDTO, InboundFile inboundFile) {
        if (trailerDTO != null) {
            FileTrailer trailer = new FileTrailer();
            trailer.setInboundFile(inboundFile);
            trailer.setRecType(trailerDTO.getRecType());
            trailer.setTotalRecords(trailerDTO.getTotalRecords());
            trailer.setTotalAmount(trailerDTO.getTotalAmount());
            trailer.setRawLine(trailerDTO.getRawLine());
            fileTrailerRepository.save(trailer);
        }
    }

    // -------------------------------------------------------
    // Status Updates
    // -------------------------------------------------------

    /**
     * Updates record counts and file status after processing completion.
     */
    @Transactional
    public void updateCountsAndStatus(InboundFile inboundFile, int recordCount, int successCount, int errorCount,
                                      String status) {
        inboundFile.setRecordCount(recordCount);
        inboundFile.setSuccessCount(successCount);
        inboundFile.setErrorCount(errorCount);
        inboundFile.setStatus(status);
        inboundFileRepository.save(inboundFile);
    }


	
}
