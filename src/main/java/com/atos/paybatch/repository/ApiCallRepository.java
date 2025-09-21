package com.atos.paybatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.paybatch.entity.ApiCall;
import com.atos.paybatch.entity.PaymentRecord;

@Repository
public interface ApiCallRepository extends JpaRepository<ApiCall, Long> {

    List<ApiCall> findByPaymentRecord(PaymentRecord paymentRecord);

    List<ApiCall> findBySuccessFlag(String successFlag);

    List<ApiCall> findByPaymentRecordAndSuccessFlag(PaymentRecord paymentRecord, String successFlag);
}
