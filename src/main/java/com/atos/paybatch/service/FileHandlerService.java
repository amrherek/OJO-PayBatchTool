package com.atos.paybatch.service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.paybatch.dto.FileHeaderDTO;
import com.atos.paybatch.dto.FileProcessingResult;
import com.atos.paybatch.dto.FileTrailerDTO;
import com.atos.paybatch.dto.ParsedFileDTO;
import com.atos.paybatch.dto.PaymentRecordDTO;
import com.atos.paybatch.entity.PayBatchChannel;
import com.atos.paybatch.entity.PayBatchFile;
import com.atos.paybatch.entity.PayBatchHeader;
import com.atos.paybatch.entity.PayBatchRecord;
import com.atos.paybatch.entity.PayBatchTrailer;
import com.atos.paybatch.repository.PayBatchChannelRepository;
import com.atos.paybatch.repository.PayBatchFileHeaderRepository;
import com.atos.paybatch.repository.PayBatchFileRepository;
import com.atos.paybatch.repository.PayBatchFileTrailerRepository;
import com.atos.paybatch.repository.PayBatchRecordRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Service for handling inbound file processing: - Metadata persistence -
 * Duplicate detection - Error handling - Status updates
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Data
public class FileHandlerService {

	private final PayBatchFileRepository payBatchFileRepository;
	private final PayBatchFileHeaderRepository fileHeaderRepository;
	private final PayBatchFileTrailerRepository fileTrailerRepository;
	private final FileStorageService fileStorageService;
	private final PayBatchChannelRepository channelRepository;
	private final PayBatchRecordRepository paymentRecordRepository;

	private static final String STATUS_INITIAL = "I";
	private static final String STATUS_PROCESSED = "P";
	private static final String STATUS_FAILED = "F";
	private static final String STATUS_DUPLICATE = "D";

	// -------------------------------------------------------
	// File Initialization & Validation
	// -------------------------------------------------------

	/**
	 * Creates a new PayBatchFile object for tracking before processing begins.
	 */
	public PayBatchFile initFile(String filename) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		PayBatchFile payBatchFile = new PayBatchFile();
		payBatchFile.setFilename(filename);
		payBatchFile.setStatus(STATUS_INITIAL);
		payBatchFile.setCreatedAt(currentDateTime);
		payBatchFile.setUpdatedAt(currentDateTime);
		return payBatchFile;
	}

	/**
	 * Checks if a file with the given checksum already exists in DB as processed.
	 */
	public boolean isDuplicate(String checksum) {
		return payBatchFileRepository.existsByFileChecksumAndStatus(checksum, STATUS_PROCESSED);
	}

	/**
	 * Resolves the payment channel by bank code. Returns null if no matching
	 * channel found.
	 */
	public PayBatchChannel resolveChannel(String bankCodeFromHeader) {
		return channelRepository.findByChannelCode(bankCodeFromHeader).orElse(null);
	}

	// -------------------------------------------------------
	// Metadata Persistence
	// -------------------------------------------------------

	@Transactional
	public List<PayBatchRecord> saveAllFileData(PayBatchFile payBatchFile, ParsedFileDTO parsed) {
		saveFile(payBatchFile);
		saveHeader(parsed.getHeader(), payBatchFile);
		saveTrailer(parsed.getTrailer(), payBatchFile);
		return savePaymentRecords(parsed.getRecords(), payBatchFile);
	}

	public void saveFile(PayBatchFile payBatchFile) {
		payBatchFileRepository.save(payBatchFile);
	}

	public void saveHeader(FileHeaderDTO headerDTO, PayBatchFile payBatchFile) {
		if (headerDTO == null)
			return;
		PayBatchHeader header = new PayBatchHeader();
		header.setPayBatchFile(payBatchFile);
		header.setRecType(headerDTO.getRecType());
		header.setBankCode(headerDTO.getBankCode());
		header.setFileDate(headerDTO.getFileDate());
		header.setBankAccount(headerDTO.getBankAccount());
		header.setBankCompCode(headerDTO.getBankCompCode());
		header.setRawLine(headerDTO.getRawLine());
		fileHeaderRepository.save(header);
	}

	public void saveTrailer(FileTrailerDTO trailerDTO, PayBatchFile payBatchFile) {
		if (trailerDTO == null)
			return;
		PayBatchTrailer trailer = new PayBatchTrailer();
		trailer.setPayBatchFile(payBatchFile);
		trailer.setRecType(trailerDTO.getRecType());
		trailer.setTotalRecords(trailerDTO.getTotalRecords());
		trailer.setTotalAmount(trailerDTO.getTotalAmount());
		trailer.setRawLine(trailerDTO.getRawLine());
		fileTrailerRepository.save(trailer);
	}

	private List<PayBatchRecord> savePaymentRecords(List<PaymentRecordDTO> paymentRecordsDTO,
			PayBatchFile payBatchFile) {
		List<PayBatchRecord> entities = paymentRecordsDTO.stream().map(dto -> mapDtoToEntity(dto, payBatchFile))
				.toList();
		List<PayBatchRecord> savedEntities = paymentRecordRepository.saveAll(entities);
		return savedEntities;
	}

	private PayBatchRecord mapDtoToEntity(PaymentRecordDTO recordDTO, PayBatchFile payBatchFile) {
		PayBatchRecord record = new PayBatchRecord();
		record.setPayBatchFile(payBatchFile);
		record.setLineNo(recordDTO.getLineNo());
		record.setRecType(recordDTO.getRecType());
		record.setPaymentType(recordDTO.getPaymentType());
		record.setBankAccount(recordDTO.getBankAccount());
		record.setCustomerCode(recordDTO.getCustomerCode());
		record.setInvoiceNo(recordDTO.getInvoiceNo());
		record.setPaymentAmount(recordDTO.getPaymentAmount());
		record.setPaymentDate(recordDTO.getPaymentDate());
		record.setRejectionReason(recordDTO.getRejectionReason());
		record.setRawLine(recordDTO.getRawLine());
		LocalDateTime currentDateTime = LocalDateTime.now();
		record.setCreatedAt(currentDateTime);
		String referenceKey = String.format("PBT_%s_%s", record.getPayBatchFile().getId(), record.getLineNo());

		record.setUniqueSeq(referenceKey);

		return record;
	}
	// -------------------------------------------------------
	// Error & Duplicate Handling
	// -------------------------------------------------------

	/**
	 * Marks the file as invalid, saves errors if PayBatchFile exists, moves file to
	 * error folder.
	 */
	@Transactional
	public void handleInvalidFile(File file, PayBatchFile payBatchFile, List<String> errors) {
		if (payBatchFile != null) {
			LocalDateTime currentDateTime = LocalDateTime.now();
			payBatchFile.setStatus(STATUS_FAILED);
			payBatchFile.setUpdatedAt(currentDateTime);
			payBatchFile.setRemark(String.join("; ", errors));
			payBatchFileRepository.save(payBatchFile);
		} else {
			log.warn("No PayBatchFile record for file {} → skipping DB update", file.getName());
		}

		fileStorageService.moveFileToError(file);
		log.debug("File {} rejected → {}", file.getName(), String.join("; ", errors));
	}

	/**
	 * Marks the file as duplicate, persists metadata, moves file to duplicate
	 * folder.
	 */
	@Transactional
	public void handleDuplicateFile(File file, PayBatchFile duplicateFile, String checksum) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		duplicateFile.setStatus(STATUS_DUPLICATE);
		duplicateFile.setUpdatedAt(currentDateTime);
		duplicateFile.setFileChecksum(checksum);
		duplicateFile.setRemark("Duplicate file detected");
		payBatchFileRepository.save(duplicateFile);

		fileStorageService.moveFileToDuplicate(file);
		log.debug("Duplicate file {} detected → moved to duplicate folder", file.getName());
	}

	// -------------------------------------------------------
	// Success Handling
	// -------------------------------------------------------

	@Transactional
	public void handleFilePostProcessing(File file, PayBatchFile payBatchFile, FileProcessingResult result) {

		// Determine final status
		if (result.getSuccessCount() == 0) {
			List<String> errors = List.of("All payment records failed during processing.");
			handleInvalidFile(file, payBatchFile, errors);
		} else {
			LocalDateTime currentDateTime = LocalDateTime.now();
			payBatchFile.setRecordCount(result.getTotalRecords());
			payBatchFile.setSuccessCount(result.getSuccessCount());
			payBatchFile.setErrorCount(result.getErrorCount());
			payBatchFile.setStatus(STATUS_PROCESSED);
			payBatchFile.setUpdatedAt(currentDateTime);
			payBatchFileRepository.save(payBatchFile);
			fileStorageService.moveFileToProcessed(file);
		}
	}

}
