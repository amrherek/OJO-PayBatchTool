package com.atos.paybatch.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Data
public class FileStorageService {

	@Value("${payment.processed-dir}")
	private String processedDir;

	@Value("${payment.error-dir}")
	private String errorDir;

	@Value("${payment.duplicate-dir}")
	private String duplicateDir;

	/**
	 * Renames the file by appending ".tmp" to avoid reprocessing.
	 */
	public File renameFileToTmp(File file) throws Exception {
		File tmpFile = new File(file.getParent(), file.getName() + ".tmp");
		Files.move(file.toPath(), tmpFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		return tmpFile;
	}



	public String calculateChecksum(File file) throws Exception {
		// Create SHA-256 digest instance
		MessageDigest digest = MessageDigest.getInstance("SHA-256");

		// Read file in chunks and update the digest
		try (InputStream fis = new FileInputStream(file)) {
			byte[] byteArray = new byte[1024];
			int bytesCount;
			while ((bytesCount = fis.read(byteArray)) != -1) {
				digest.update(byteArray, 0, bytesCount);
			}
		}

		// Finalize hash calculation
		byte[] hashBytes = digest.digest();

		// Convert raw bytes to Base64 string
		return Base64.getEncoder().encodeToString(hashBytes);
	}

	/**
	 * Moves file safely to the specified target directory.
	 */
	public void moveFileSafely(File file, String targetDir) {
		try {
			Path targetPath = Path.of(targetDir, file.getName().replace(".tmp", ""));
			Files.createDirectories(targetPath.getParent());
			Files.move(file.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
			log.info("Moved file {} to {}", file.getName(), targetDir);
		} catch (Exception e) {
			log.error("Failed to move file {} to {}: {}", file.getName(), targetDir, e.getMessage());
		}
	}

	/**
	 * Moves file to the processed directory.
	 */
	public void moveFileToProcessed(File file) {
		moveFileSafely(file, processedDir);
	}

	/**
	 * Moves file to the error directory.
	 */
	public void moveFileToError(File file) {
		moveFileSafely(file, errorDir);
	}

	/**
	 * Moves file to the duplicate directory.
	 */
	public void moveFileToDuplicate(File file) {
		moveFileSafely(file, duplicateDir);
	}
}
