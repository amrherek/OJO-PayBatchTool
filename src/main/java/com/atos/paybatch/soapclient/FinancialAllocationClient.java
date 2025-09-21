package com.atos.paybatch.soapclient;

import com.atos.paybatch.entity.PaymentRecord;
import com.atos.paybatch.stubs.financialallocation.FinancialAllocationWriteRequest;
import com.atos.paybatch.stubs.financialallocation.FinancialAllocationWriteResponse;
import com.atos.paybatch.stubs.financialallocation.FinancialAllocationWriteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Client responsible for invoking the FinancialAllocationWrite SOAP service.
 * Handles request preparation, service call, response parsing, and retry logic.
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class FinancialAllocationClient {

    private static final String FAILURE_STATUS = "F";

    private final FinancialAllocationWriteService financialAllocationWriteService;
    private final RequestBuilder requestBuilder;
    private final SessionBuilder sessionBuilder;

    /**
     * Writes financial allocation for a given payment record and customer.
     * Retries only if the SOAP call itself fails.
     */
    @Retryable(
            value = {RuntimeException.class},
            maxAttemptsExpression = "${payment.api.max-retries:3}",
            backoff = @Backoff(delayExpression = "${payment.api.retry-delay-ms:2000}")
    )
    public Long writeFinancialAllocation(PaymentRecord record, Long customerId, String glAccount) {
        log.info("Invoking FinancialAllocationWrite for recordId={} (attempt #{})",
                record.getId(), record.getRetryCount() + 1);

        try {
            FinancialAllocationWriteRequest request = buildRequest(record, customerId, glAccount);
            log.debug("FinancialAllocationWrite request: {}", request);

            FinancialAllocationWriteResponse response = financialAllocationWriteService.financialAllocationWrite(request);
            log.debug("FinancialAllocationWrite response: {}", response);

            // Only warn if transaction ID is null, but don't retry
            Long transactionId = extractTransactionId(response).orElse(null);
            if (transactionId == null) {
                log.warn("FinancialAllocationWrite returned no transaction ID for recordId={}", record.getId());
            }
            return transactionId;

        } catch (Exception ex) {
            record.incrementRetryCnt();
            log.error("FinancialAllocationWrite call failed for recordId={} error={}", record.getId(), ex.getMessage(), ex);
            throw new RuntimeException("FinancialAllocationWrite API call failed", ex);
        }
    }

    /**
     * Recovery method invoked after all retries fail.
     */
    @Recover
    public String recover(RuntimeException ex, PaymentRecord record, Long customerId, String glAccount) {
        log.error("FinancialAllocationWrite permanently failed for recordId={} after {} retries: {}",
                record.getId(), record.getRetryCount(), ex.getMessage(), ex);
        record.setStatus(FAILURE_STATUS);
        record.setRemark(ex.getMessage());
        return null;
    }

    /**
     * Builds the SOAP request for FinancialAllocationWrite.
     */
    private FinancialAllocationWriteRequest buildRequest(PaymentRecord record, Long customerId, String glAccount) {
        return requestBuilder.buildFinancialAllocationWriteRequest(
                record, customerId, glAccount, sessionBuilder.buildFinancialSession());
    }

    /**
     * Extracts the transaction ID from the response safely.
     */
    private Optional<Long> extractTransactionId(FinancialAllocationWriteResponse response) {
        return Optional.ofNullable(response)
                .map(FinancialAllocationWriteResponse::getFinancialAllocationWriteOutputDTO)
                .map(out -> out.getTransactions())
                .map(tx -> tx.getTransactionWriteOutDTO())
                .filter(list -> !list.isEmpty())
                .map(list -> list.get(0).getTransactionId());
    }
}
