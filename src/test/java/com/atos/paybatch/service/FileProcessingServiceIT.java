package com.atos.paybatch.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.nio.file.Files;

import com.atos.paybatch.service.FileProcessingService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class FileProcessingServiceIT {

    @Autowired
    private FileProcessingService fileProcessingService;

    @Test
    void testProcessFilesIntegration() throws Exception {
        File inputDir = new File("target/test-input");
        inputDir.mkdirs();
        File testFile = new File(inputDir, "sample.in");
        Files.writeString(testFile.toPath(), "test content");

        fileProcessingService.processFiles();

        File processedFile = new File("target/processed/sample.in");
        assertThat(processedFile.exists()).isTrue();
    }
}
