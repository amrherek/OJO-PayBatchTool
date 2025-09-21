package com.atos.paybatch.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ParsedFileDTO {
    private FileHeaderDTO header;
    private FileTrailerDTO trailer;
    private List<PaymentRecordDTO> records = new ArrayList<>();
    private boolean valid = true;
    private List<String> errors = new ArrayList<>();

    public void addError(String error) {
        valid = false;
        errors.add(error);
    }
}
