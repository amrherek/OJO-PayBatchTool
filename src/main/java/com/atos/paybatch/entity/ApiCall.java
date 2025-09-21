package com.atos.paybatch.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "API_CALL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiCall {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "api_call_seq")
    @SequenceGenerator(name = "api_call_seq", sequenceName = "SEQ_API_CALL_ID", allocationSize = 1)
    @Column(name = "API_CALL_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PAYMENT_ID")
    private PaymentRecord paymentRecord;

    @ManyToOne
    @JoinColumn(name = "FILE_ID")
    private InboundFile inboundFile;

    @Column(name = "CALL_TS")
    private LocalDateTime callTs;

    @Column(name = "API_NAME", length = 100)
    private String apiName;

    @Lob
    @Column(name = "REQUEST_PAYLOAD")
    private String requestPayload;

    @Lob
    @Column(name = "RESPONSE_PAYLOAD")
    private String responsePayload;

    @Column(name = "SUCCESS_FLAG", length = 1)
    private String successFlag;

    @Column(name = "ATTEMPT_NO")
    private Integer attemptNo;

    @Column(name = "ERROR_MSG", length = 4000)
    private String errorMsg;
}
