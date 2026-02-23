package com.atos.paybatch.service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.atos.paybatch.dto.FileProcessingResult;
import com.atos.paybatch.dto.ParsedFileDTO;
import com.atos.paybatch.entity.PayBatchChannel;
import com.atos.paybatch.entity.PayBatchFile;
import com.atos.paybatch.entity.PayBatchRecord;
import com.atos.paybatch.repository.PayBatchFileRepository;
import com.atos.paybatch.repository.PayBatchRecordRepository;

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
	private final PayBatchRecordRepository payBatchRecordRepository;
	private final PayBatchFileRepository payBatchFileRepository;

	@Value("${paybatch.file.enabled:true}")
	private boolean fileProcessingEnabled;

	@Value("${paybatch.recycle.enabled:true}")
	private boolean recycleEnabled;

	@Value("${payment.input-dir}")
	private String inputDir;

	@Scheduled(fixedDelayString = "${paybatch.schedule.interval:5m}")
	public void scheduledJob() {

		log.info("────────────────────────────────────────────");
		log.info("[JOB_START ] Scheduled job triggered.");

		try {

			if (fileProcessingEnabled) {
				log.info("[JOB_PHASE ] Starting file processing phase...");
				processFiles();
			}

			if (recycleEnabled) {
				log.info("[JOB_PHASE ] Starting record recycling phase...");
				recycleRecords();
			}

		} catch (Exception e) {
			log.error("[JOB_ERROR ] Unexpected exception | error={}", e.getMessage(), e);
		}

		log.info("[JOB_END   ] Scheduled job finished.");
		log.info("────────────────────────────────────────────");
	}

	public void processFiles() {
		File folder = new File(inputDir);
		File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".in"));

		if (files == null || files.length == 0) {
			log.info("[NO_FILES  ] No input files in '{}'", inputDir);
			return;
		}

		log.info("[FILES_FOUND   ] {} file(s) found in '{}'", files.length, inputDir);

		for (File file : files) {
			log.info("────────────────────────────────────────────");
			log.info("[FILE_START    ] Processing file '{}'", file.getName());

			File tmpFile = null;
			try {
				// Step 1: Rename to .tmp for processing
				log.info("→ Step 1: Preparing file for processing...");
				tmpFile = fileStorageService.renameFileToTmp(file);

				// Step 2: Process file
				FileProcessingResult result = processSingleFile(tmpFile);

				if (result.isProcessedSuccessfully()) {
					log.info(
							"[FILE_SUCCESS  ] File '{}' processed successfully | totalRecords={} | success={} | errors={}",
							result.getFileName(), result.getTotalRecords(), result.getSuccessCount(),
							result.getErrorCount());
				} else {
					log.error("[FILE_FAILED   ] File '{}' encountered processing issues | errors={}",
							result.getFileName(), result.getErrorCount());
				}

			} catch (Exception e) {
				log.error("[FILE_ERROR    ] Unexpected error while processing '{}' | {}", file.getName(),
						e.getMessage(), e);
				fileHandlerService.handleInvalidFile(tmpFile != null ? tmpFile : file, null,
						List.of("Unexpected error: " + e.getMessage()), null);
			}

			log.info("[FILE_END      ] Finished processing '{}'", file.getName());
			log.info("────────────────────────────────────────────");
		}
	}

	public FileProcessingResult processSingleFile(File tmpFile) throws Exception {
		String inFileName = tmpFile.getName().replaceFirst("\\.tmp$", "");

		log.info("→ Step 2: Initializing file record for '{}'", inFileName);
		FileProcessingResult result = new FileProcessingResult(inFileName);
		PayBatchFile batchFile = fileHandlerService.initFile(inFileName);

		// Step 3: Check for duplicates
		log.info("→ Step 3: Checking for duplicate file...");
		String checksum = fileStorageService.calculateChecksum(tmpFile);
		if (fileHandlerService.isDuplicate(checksum)) {
			log.warn("[DUPLICATE_FILE] File '{}' already processed | checksum={}", inFileName, checksum);
			fileHandlerService.handleDuplicateFile(tmpFile, batchFile, checksum);
			return result;
		}
		batchFile.setFileChecksum(checksum);

		// Step 4: Parse and validate content
		log.info("→ Step 4: Parsing and validating file '{}'", inFileName);
		ParsedFileDTO parsed = fileParserService.parseAndValidateFile(tmpFile);
		if (!parsed.isValid()) {
			log.error("[VALIDATION_FAILED] File '{}' validation errors: {}", inFileName, parsed.getErrors());
			fileHandlerService.handleInvalidFile(tmpFile, batchFile, parsed.getErrors(), null);
			return result;
		}

		// Step 5: Resolve payment channel
		log.info("→ Step 5: Resolving payment channel for bankCode='{}'", parsed.getHeader().getBankCode());
		PayBatchChannel channel = fileHandlerService.resolveChannel(parsed.getHeader().getBankCode());
		if (channel == null) {
			String errorMsg = "No matching channel found for bank code: " + parsed.getHeader().getBankCode();
			log.error("[CHANNEL_MISSING] {}", errorMsg);
			fileHandlerService.handleInvalidFile(tmpFile, batchFile, List.of(errorMsg), null);
			return result;
		}

		if (channel.getGlCode() == null || channel.getGlCode().isBlank()) {
			String errorMsg = "Channel found for bank code " + parsed.getHeader().getBankCode()
					+ " but GL Code is missing";
			log.error("[GL_CODE_MISSING] {}", errorMsg);
			fileHandlerService.handleInvalidFile(tmpFile, batchFile, List.of(errorMsg), null);
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
		log.info("→ Step 8: Finalizing file '{}' post-processing", inFileName);
		fileHandlerService.handleFilePostProcessing(tmpFile, batchFile, result);

		log.info("[FILE_COMPLETED] File '{}' fully processed | totalRecords={} | success={} | errors={}", inFileName,
				result.getTotalRecords(), result.getSuccessCount(), result.getErrorCount());
		return result;
	}

	private void processPaymentRecords(List<PayBatchRecord> records, PayBatchFile payBatchFile,
			FileProcessingResult result) {
		int successCount = 0;
		int errorCount = 0;

		for (PayBatchRecord record : records) {
			boolean success = recordProcessorService.processRecord(record, payBatchFile.getChannel().getGlCode());
			if (success)
				successCount++;
			else
				errorCount++;
		}

		result.setTotalRecords(records.size());
		result.setSuccessCount(successCount);
		result.setErrorCount(errorCount);
		result.markAsSuccessful();

		log.info("[RECORDS_SUMMARY] total={} | success={} | failed={}", records.size(), successCount, errorCount);
	}

	private void recycleRecords() {

		List<PayBatchRecord> records = payBatchRecordRepository.findByStatus("R");

		if (records == null || records.isEmpty()) {
			log.info("[NO RECORDS] No records found with status 'R'.");
			return;
		}

		log.info("[RECYCLE_FOUND] {} record(s) marked for recycle.", records.size());

		// stats per fileId: [0]=success, [1]=failure
		Map<Long, int[]> stats = new HashMap<>();

		for (PayBatchRecord record : records) {

			PayBatchFile file = record.getPayBatchFile();
			Long fileId = file.getId();

			log.info("→ Recycle record ID={} (fileId={})", record.getId(), fileId);

			boolean success = recordProcessorService.processRecord(record, file.getChannel().getGlCode());

			stats.putIfAbsent(fileId, new int[] { 0, 0 });

			if (success) {
				stats.get(fileId)[0]++; // success
				log.info("[RECYCLE_SUCCESS] record ID={} recycled successfully.", record.getId());
			} else {
				stats.get(fileId)[1]++; // failure (no stat update)
				log.error("[RECYCLE_FAILED] record ID={} failed to recycle.", record.getId());
			}
		}

		int totalSuccess = 0;
		int totalFailed = 0;
		log.info("────────────────────────────────────────────");
		log.info("[RECYCLE_STATS     ] Updating file statistics for successful recycles.");

		int filesUpdated = 0;
		for (Map.Entry<Long, int[]> entry : stats.entrySet()) {
			Long fileId = entry.getKey();
			int successCount = entry.getValue()[0];
			int failureCount = entry.getValue()[1];

			if (successCount > 0) {
				filesUpdated++;
				PayBatchFile file = payBatchFileRepository.findById(fileId).orElse(null);

				if (file == null) {
					log.warn("[RECYCLE_WARN] fileId={} not found — skipping stats update.", fileId);
					continue;
				}

				Integer success = file.getSuccessCount();
				Integer error = file.getErrorCount();

				int existingSuccess = (success == null ? 0 : success);
				int existingError = (error == null ? 0 : error);

				file.setSuccessCount(existingSuccess + successCount);

				int newError = existingError - successCount;
				file.setErrorCount(newError < 0 ? 0 : newError);

				file.setUpdatedAt(LocalDateTime.now());

				payBatchFileRepository.save(file);

				totalSuccess += successCount;

				log.info("[FILE_STATS_UPDATED] fileId={} | successAdded={} | errorReduced={}", fileId, successCount,
						successCount);
			} else {
				log.debug("[FILE_STATS_SKIPPED] fileId={} (no successful recycles)", fileId);
			}

			totalFailed += failureCount;
		}

		log.info("[RECYCLE_SUMMARY   ] filesUpdated={} | success(records)={} | failed(records)={}", filesUpdated,
				totalSuccess, totalFailed);

		log.info("────────────────────────────────────────────");
	}

}
