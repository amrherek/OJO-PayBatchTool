package com.atos.paybatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.paybatch.entity.InboundFile;
import com.atos.paybatch.entity.PaymentRecord;

@Repository
public interface PaymentRecordRepository extends JpaRepository<PaymentRecord, Long> {

    List<PaymentRecord> findByInboundFile(InboundFile file);

    List<PaymentRecord> findByStatus(String status);

    List<PaymentRecord> findByInboundFileAndStatus(InboundFile file, String status);

    List<PaymentRecord> findByCustomerCode(String customerCode);
}
