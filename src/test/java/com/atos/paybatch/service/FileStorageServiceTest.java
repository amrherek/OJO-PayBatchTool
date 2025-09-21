package com.atos.paybatch.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.File;
import java.nio.file.Files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class FileStorageServiceTest {

    private FileStorageService fileStorageService;

    @BeforeEach
    void setUp() {
        fileStorageService = new FileStorageService();
        ReflectionTestUtils.setField(fileStorageService, "processedDir", "target/processed");
        ReflectionTestUtils.setField(fileStorageService, "errorDir", "target/error");
        ReflectionTestUtils.setField(fileStorageService, "duplicateDir", "target/duplicate");
    }

    @Test
    void testCalculateChecksum() throws Exception {
        File tempFile = Files.createTempFile("testfile", ".txt").toFile();
        Files.writeString(tempFile.toPath(), "hello world");
        String checksum = fileStorageService.calculateChecksum(tempFile);
        assertNotNull(checksum);
        assertEquals(64, checksum.length());
        tempFile.delete();
    }

    @Test
    void testRenameFileToTmp() throws Exception {
        File tempFile = Files.createTempFile("file", ".in").toFile();
        File tmpFile = fileStorageService.renameFileToTmp(tempFile);
        assertTrue(tmpFile.exists());
        assertTrue(tmpFile.getName().endsWith(".tmp"));
        tmpFile.delete();
    }

    @Test
    void testMoveFileSafely() throws Exception {
        File tempFile = Files.createTempFile("file", ".tmp").toFile();
        fileStorageService.moveFileSafely(tempFile, "target/processed");
        assertFalse(tempFile.exists());
        File moved = new File("target/processed/" + tempFile.getName().replace(".tmp", ""));
        assertTrue(moved.exists());
        moved.delete();
    }
}
