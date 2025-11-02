package com.atos.paybatch.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PAYBATCH_FILE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayBatchFile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "file_seq")
    @SequenceGenerator(name = "file_seq", sequenceName = "SEQ_FILE_ID", allocationSize = 1)
    @Column(name = "FILE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CHANNEL_ID")
    private PayBatchChannel channel;

    @Column(name = "FILENAME", nullable = false, length = 500)
    private String filename;


    @Column(name = "RECORD_COUNT")
    private int recordCount;
    
    @Column(name = "SUCCESS_COUNT")
    private int successCount;

    @Column(name = "ERROR_COUNT")
    private int errorCount;

    @Column(name = "STATUS", length = 30)
    private String status = "I";

    @Column(name = "REMARK", length = 1000)
    private String remark;

    @Column(name = "FILE_CHECKSUM", length = 128, unique = true)
    private String fileChecksum;
   
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "payBatchFile", cascade = CascadeType.ALL)
    private PayBatchHeader fileHeader;

    @OneToOne(mappedBy = "payBatchFile", cascade = CascadeType.ALL)
    private PayBatchTrailer fileTrailer;
}
