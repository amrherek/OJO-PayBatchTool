package com.atos.paybatch.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PAYBATCH_CHANNEL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayBatchChannel {

    @Id
    @Column(name = "CHANNEL_ID")
    private Long id;

    @Column(name = "CHANNEL_CODE", nullable = false, length = 50)
    private String channelCode;

    @Column(name = "CHANNEL_NAME", length = 150)
    private String channelName;

    @Column(name = "BANK_ACCOUNT_NUMBER", length = 150)
    private String bankAccountNumber;

    @Column(name = "GLCODE", length = 30)
    private String glCode;

    @Column(name = "COMPANY_CODE", length = 150)
    private String companyCode;

    @Column(name = "FILENAME_REGEX", length = 200)
    private String filenameRegex;

    @Column(name = "BSCS_TAG", length = 100)
    private String bscsTag;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
}
