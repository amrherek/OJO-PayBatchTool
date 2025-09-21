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
@Table(name = "PAYMENT_CHANNEL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentChannel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "channel_seq")
    @SequenceGenerator(name = "channel_seq", sequenceName = "SEQ_CHANNEL_ID", allocationSize = 1)
    @Column(name = "CHANNEL_ID")
    private Long id;

    @Column(name = "CHANNEL_CODE", nullable = false, length = 50)
    private String channelCode;

    @Column(name = "FILENAME_REGEX", length = 200)
    private String filenameRegex;

    @Column(name = "GL_ACCOUNT", length = 100)
    private String glAccount;

    @Column(name = "DESCRIPTION", length = 400)
    private String description;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

}
