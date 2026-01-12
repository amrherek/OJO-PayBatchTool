package com.atos.paybatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.paybatch.entity.PayBatchRecord;
import com.atos.paybatch.soapclient.CustomerSearchClient;
import com.atos.paybatch.soapclient.FinancialAllocationClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Service responsible for orchestrating the processing of payment records.
 *
 * Processing flow:
 * 1. Search for the customer ID via the CustomerSearch SOAP service.
 * 2. Post the financial allocation using the FinancialAllocation SOAP service.
 *
 * Each client internally handles marking records as SUCCESS or FAILED.
 * This class coordinates the process and logs key steps for traceability.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RecordProcessorService {

    private final CustomerSearchClient customerSearchClient;
    private final FinancialAllocationClient financialAllocationClient;

    /**
     * Processes a single payment record in a transactional context.
     */
    @Transactional
    public Boolean processRecord(PayBatchRecord record, String glAccount) {
        String recordInfo = String.format(
                "file='%s', line=%d, recordId=%d, customerCode=%s, amount=%s",
                record.getPayBatchFile().getFilename(),
                record.getLineNo(),
                record.getId(),
                record.getCustomerCode(),
                record.getPaymentAmount()
        );

        log.info("┌──────────── START RECORD ────────────");
        log.info("│ Processing → {}", recordInfo);

        try {
            // Step 1: Search for Customer ID
            log.info("│ → Step 1: Searching Customer ID for '{}'", record.getCustomerCode());
            Long customerId = customerSearchClient.searchCustomer(record);

            if (customerId == null) {
                log.error("│ [SKIPPED] Customer not found → recordId={}", record.getId());
                log.info("└──────────── END RECORD ─────────────");
                return false;
            }

            // Step 2: Post Financial Allocation
            log.info("│ → Step 2: Writing Financial Allocation for recordId={} and customerId={}",
                    record.getId(), customerId);
            Long transactionId = financialAllocationClient.writeFinancialAllocation(record, customerId, glAccount);

            if (transactionId == null) {
                log.error("│ [SKIPPED] Financial allocation failed → recordId={}, customerId={}",
                        record.getId(), customerId);
                log.info("└──────────── END RECORD ─────────────");
                return false;
            }

            // Success
            log.info("│ [SUCCESS] Record processed → customerId={}, transactionId={}", customerId, transactionId);
            log.info("└──────────── END RECORD ─────────────");
            return true;

        } catch (Exception ex) {
            log.error("│ [ERROR] Record processing failed → recordId={}, customerCode={}, error={}",
                    record.getId(), record.getCustomerCode(), ex.getMessage(), ex);
            log.info("└──────────── END RECORD ─────────────");
            return false;
        }
    }
}
