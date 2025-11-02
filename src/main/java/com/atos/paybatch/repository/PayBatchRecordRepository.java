package com.atos.paybatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.paybatch.entity.PayBatchFile;
import com.atos.paybatch.entity.PayBatchRecord;

@Repository
public interface PayBatchRecordRepository extends JpaRepository<PayBatchRecord, Long> {

    List<PayBatchRecord> findByPayBatchFile(PayBatchFile file);

    List<PayBatchRecord> findByStatus(String status);

    List<PayBatchRecord> findByPayBatchFileAndStatus(PayBatchFile file, String status);

    List<PayBatchRecord> findByCustomerCode(String customerCode);
}
