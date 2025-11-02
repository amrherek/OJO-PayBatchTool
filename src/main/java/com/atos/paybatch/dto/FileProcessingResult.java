package com.atos.paybatch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileProcessingResult {
    private String fileName;
    private int totalRecords;
    private int successCount;
    private int errorCount;
    private boolean processedSuccessfully; 


    public FileProcessingResult(String fileName) {
        this.fileName = fileName;
        this.processedSuccessfully = false; // default to false
    }

    public void markAsSuccessful() {
        this.processedSuccessfully = true;
    }

    public boolean isProcessedSuccessfully() {
        return processedSuccessfully;
    }

}
