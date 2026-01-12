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

/**
 * Handles all file movement and integrity operations such as renaming,
 * checksum generation, and directory relocation (processed, error, duplicate).
 */
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
     * Renames a file to a temporary ".tmp" version before processing
     * to prevent accidental re-processing.
     */
    public File renameFileToTmp(File file) throws Exception {
        log.info("→ Step 1: Renaming file '{}' to temporary '.tmp' version", file.getName());
        File tmpFile = new File(file.getParent(), file.getName() + ".tmp");
        Files.move(file.toPath(), tmpFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        log.debug("[FILE_RENAMED  ] {} → {}", file.getName(), tmpFile.getName());
        return tmpFile;
    }

    /**
     * Computes a SHA-256 checksum for a file and returns it as a Base64-encoded string.
     */
    public String calculateChecksum(File file) throws Exception {
        log.info("→ Step 2: Calculating checksum for '{}'", file.getName().replaceFirst("\\.tmp$", ""));

        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        try (InputStream fis = new FileInputStream(file)) {
            byte[] byteArray = new byte[1024];
            int bytesCount;
            while ((bytesCount = fis.read(byteArray)) != -1) {
                digest.update(byteArray, 0, bytesCount);
            }
        }

        byte[] hashBytes = digest.digest();
        String checksum = Base64.getEncoder().encodeToString(hashBytes);
        log.debug("[CHECKSUM_GENERATED] file={} | checksum={}", file.getName().replaceFirst("\\.tmp$", ""), checksum);
        return checksum;
    }

    /**
     * Moves the file to a target directory safely.
     * Automatically removes the ".tmp" extension during the move.
     */
    public void moveFileSafely(File file, String targetDir) {
        String cleanName = file.getName().replaceFirst("\\.tmp$", "");
        try {
            Path targetPath = Path.of(targetDir, cleanName);
            Files.createDirectories(targetPath.getParent());
            Files.move(file.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            log.info("[FILE_MOVED    ] {} → {}", cleanName, targetDir);
        } catch (Exception e) {
            log.error("[FILE_MOVE_ERROR] file={} | targetDir={} | reason={}", cleanName, targetDir, e.getMessage(), e);
        }
    }

    /**
     * Moves the file to the 'processed' directory.
     */
    public void moveFileToProcessed(File file) {
        log.info("→ Step: Moving file '{}' to PROCESSED directory", file.getName().replaceFirst("\\.tmp$", ""));
        moveFileSafely(file, processedDir);
    }

    /**
     * Moves the file to the 'error' directory.
     */
    public void moveFileToError(File file) {
        log.info("→ Step: Moving file '{}' to ERROR directory", file.getName().replaceFirst("\\.tmp$", ""));
        moveFileSafely(file, errorDir);
    }

    /**
     * Moves the file to the 'duplicate' directory.
     */
    public void moveFileToDuplicate(File file) {
        log.info("→ Step: Moving file '{}' to DUPLICATE directory", file.getName().replaceFirst("\\.tmp$", ""));
        moveFileSafely(file, duplicateDir);
    }
}
