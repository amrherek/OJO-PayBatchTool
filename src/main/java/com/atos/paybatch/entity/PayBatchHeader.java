package com.atos.paybatch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PAYBATCH_HEADER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayBatchHeader {

    @Id
    @Column(name = "FILE_ID")
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "FILE_ID")
    private PayBatchFile payBatchFile;

    @Column(name = "REC_TYPE", length = 1)
    private String recType;

    @Column(name = "BANK_CODE", length = 20)
    private String bankCode;

    @Column(name = "FILE_DATE", length = 8)
    private String fileDate;

    @Column(name = "BANK_ACCT", length = 25)
    private String bankAccount;

    @Column(name = "BANK_COMP_CODE", length = 20)
    private String bankCompCode;

    @Column(name = "RAW_LINE", length = 1000)
    private String rawLine;
}
