package com.atos.paybatch.soapclient;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetrySynchronizationManager;
import org.springframework.stereotype.Component;

import com.atos.paybatch.entity.PayBatchRecord;
import com.atos.paybatch.exception.ApigeeFaultException;
import com.atos.paybatch.exception.TransientException;
import com.atos.paybatch.repository.PayBatchRecordRepository;
import com.atos.paybatch.stubs.financialallocation.FinancialAllocationWriteRequest;
import com.atos.paybatch.stubs.financialallocation.FinancialAllocationWriteResponse;
import com.atos.paybatch.stubs.financialallocation.FinancialAllocationWriteService;
import com.atos.paybatch.util.SoapExceptionUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Client responsible for invoking the FinancialAllocationWrite SOAP service.
 * Handles request preparation, service invocation, retry logic, and updates PaymentRecord status.
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class FinancialAllocationClient {

    private static final String FAILURE_STATUS = "F";
    private static final String SUCCESS_STATUS = "P";

    private final FinancialAllocationWriteService financialAllocationWriteService;
    private final RequestBuilder requestBuilder;
    private final SessionBuilder sessionBuilder;
    private final PayBatchRecordRepository paymentRecordRepository;

    @Retryable(
        value = { TransientException.class, ApigeeFaultException.class },
        maxAttemptsExpression = "${financialallocation.api.max-retries:3}",
        backoff = @Backoff(delayExpression = "${financialallocation.api.retry-delay-ms:2000}")
    )
    public Long writeFinancialAllocation(PayBatchRecord record, Long customerId, String glAccount) {

        int attempt = RetrySynchronizationManager.getContext() != null
                ? RetrySynchronizationManager.getContext().getRetryCount() + 1
                : 1;

        log.info("│    → [FinancialAllocation] Invoking API (attempt={})", attempt);

        try {
            FinancialAllocationWriteRequest request = buildRequest(record, customerId, glAccount);
            FinancialAllocationWriteResponse response = financialAllocationWriteService.financialAllocationWrite(request);

            Long transactionId = extractTransactionId(response).orElse(null);
            log.info("│    → [FinancialAllocation] API response: transactionId={}", transactionId);

            if (transactionId == null) {
                String reason = "FinancialAllocationWrite returned no transactionId";
                log.error("│    → [FinancialAllocation] Record failed → recordId={}, customerId={}, reason={}",
                        record.getId(), customerId, reason);
                markRecordFailed(record, reason);
            } else {
                record.setTransactionId(transactionId);
                markRecordSuccess(record);
            }

            return transactionId;

        } catch (Exception ex) {
            log.error("│    → [FinancialAllocation] API error (attempt={}): {}", attempt, ex.getMessage(), ex);

            boolean isTransient = SoapExceptionUtils.isTransient(ex);
            String rootMessage = SoapExceptionUtils.getRootCauseMessage(ex);

            if (isTransient) {
                throw new TransientException("Transient error: " + rootMessage, ex);
            } else {
                log.error("│    → [FinancialAllocation] Record failed → recordId={}, reason={}",
                        record.getId(), rootMessage);
                markRecordFailed(record, "FinancialAllocationWrite failed: " + rootMessage);
                return null;
            }
        }
    }

    @Recover
    public Long recover(RuntimeException ex, PayBatchRecord record) {
        String rootMessage = SoapExceptionUtils.getRootCauseMessage(ex);
        log.error("│    → [FinancialAllocation] Record permanently failed after retries → recordId={}, reason={}",
                record.getId(), rootMessage);
        markRecordFailed(record, "FinancialAllocationWrite failed after retries: " + rootMessage);
        return null;
    }

    private FinancialAllocationWriteRequest buildRequest(PayBatchRecord record, Long customerId, String glAccount) {
        return requestBuilder.buildFinancialAllocationWriteRequest(
                record, customerId, glAccount, sessionBuilder.buildFinancialSession());
    }

    private Optional<Long> extractTransactionId(FinancialAllocationWriteResponse response) {
        return Optional.ofNullable(response)
                .map(FinancialAllocationWriteResponse::getFinancialAllocationWriteOutputDTO)
                .map(out -> out.getTransactions())
                .map(tx -> tx.getTransactionWriteOutDTO())
                .filter(list -> !list.isEmpty())
                .map(list -> list.get(0).getTransactionId());
    }

    private void markRecordFailed(PayBatchRecord record, String remark) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        record.setStatus(FAILURE_STATUS);
        record.setUpdatedAt(currentDateTime);
        record.setRemark(remark);
        paymentRecordRepository.save(record);

        log.error("│    → [FinancialAllocation] Record {} marked as FAILED — reason: {}", record.getId(), remark);
    }

    private void markRecordSuccess(PayBatchRecord record) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        record.setStatus(SUCCESS_STATUS);
        record.setUpdatedAt(currentDateTime);
        record.setRemark("Successfully Processed");
        paymentRecordRepository.save(record);

        log.info("│    → [FinancialAllocation] Record marked as SUCCESS");
    }
}
