package com.atos.paybatch.dto;

import lombok.Data;

@Data
public class FileTrailerDTO {
    private String recType;
    private long totalRecords;
    private double totalAmount;
    private String rawLine;
    private boolean valid = true;
    private String error;
}
