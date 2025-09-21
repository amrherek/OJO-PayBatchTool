package com.atos.paybatch.dto;

import lombok.Data;

@Data
public class FileHeaderDTO {
    private String recType;
    private String bankCode;
    private String fileDate;
    private String bankAccount;
    private String bankCompCode;
    private String rawLine;
    private boolean valid = true;
    private String error;
}
