package com.atos.paybatch.dto;

import lombok.Data;

@Data
public class PaymentRecordDTO {
    private Long lineNo;
    private String recType;
    private int paymentType;
    private String bankAccount;
    private String customerCode;
    private String invoiceNo;
    private double paymentAmount;
    private String paymentDate;
    private String rejectionReason;
    private String rawLine;
    private String error;
    private boolean valid = true;
}
