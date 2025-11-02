package com.atos.paybatch.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PAYBATCH_RECORD")
@NoArgsConstructor
@Data

public class PayBatchRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    @SequenceGenerator(name = "payment_seq", sequenceName = "SEQ_PAYMENT_ID", allocationSize = 1)
    @Column(name = "PAYMENT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FILE_ID", nullable = false)
    private PayBatchFile payBatchFile;

    @Column(name = "LINE_NO")
    private Long lineNo;

    @Column(name = "REC_TYPE", length = 1)
    private String recType;

    @Column(name = "PAYMENT_TYPE")
    private Integer paymentType;

    @Column(name = "BANK_ACCOUNT", length = 25)
    private String bankAccount;

    @Column(name = "CUSTOMER_CODE", length = 20)
    private String customerCode;

    @Column(name = "INVOICE_NO", length = 30)
    private String invoiceNo;

    @Column(name = "PAYMENT_AMOUNT")
    private Double paymentAmount;

    @Column(name = "PAYMENT_DATE", length = 8)
    private String paymentDate;

    @Column(name = "REJECTION_REASON", length = 50)
    private String rejectionReason;

    @Column(name = "RAW_LINE", length = 1000)
    private String rawLine;

    @Column(name = "STATUS", length = 30)
    private String status = "I";

    @Column(name = "UNIQUE_SEQ")
    private String uniqueSeq;

    @Column(name = "TRANSACTION_ID", length = 100)
    private Long transactionId;


    @Column(name = "REMARK", length = 1000)
    private String remark;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
}

