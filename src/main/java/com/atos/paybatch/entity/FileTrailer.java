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
@Table(name = "FILE_TRAILER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileTrailer {

    @Id
    @Column(name = "FILE_ID")
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "FILE_ID")
    private InboundFile inboundFile;

    @Column(name = "REC_TYPE", length = 1)
    private String recType;

    @Column(name = "TOTAL_RECORDS")
    private Long totalRecords;

    @Column(name = "TOTAL_AMOUNT", precision = 18, scale = 3)
    private Double totalAmount;

    @Column(name = "RAW_LINE", length = 1000)
    private String rawLine;
}
