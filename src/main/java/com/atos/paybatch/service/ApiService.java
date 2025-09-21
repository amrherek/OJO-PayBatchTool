package com.atos.paybatch.service;

import org.springframework.stereotype.Service;

import com.atos.paybatch.entity.PaymentRecord;
import com.atos.paybatch.repository.PaymentRecordRepository;
import com.atos.paybatch.soapclient.CustomerSearchClient;
import com.atos.paybatch.soapclient.FinancialAllocationClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApiService {

    private final CustomerSearchClient customerSearchClient;
    private final FinancialAllocationClient financialAllocationClient;
    private final PaymentRecordRepository paymentRecordRepository;

    public Boolean processRecord(PaymentRecord record, String glaccount) {
        try {
            Long customerId = customerSearchClient.searchCustomer(record);
            Long transactionId = financialAllocationClient.writeFinancialAllocation(record, customerId, glaccount);
    		record.setTransactionId(transactionId);
			record.setStatus("P");
			paymentRecordRepository.save(record);
            log.info("Record {} processed successfully with transactionId {}", record.getId(), transactionId);
            return true;
        } catch (Exception e) {
            log.error("Processing record {} failed: {}", record.getId(), e.getMessage(), e);
            return false;
        }
    }
}
