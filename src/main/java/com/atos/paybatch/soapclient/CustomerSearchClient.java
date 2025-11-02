package com.atos.paybatch.soapclient;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetrySynchronizationManager;
import org.springframework.stereotype.Component;

import com.atos.paybatch.entity.PayBatchRecord;
import com.atos.paybatch.exception.TransientException;
import com.atos.paybatch.repository.PayBatchRecordRepository;
import com.atos.paybatch.stubs.customersearch.CustomersSearchRequest;
import com.atos.paybatch.stubs.customersearch.CustomersSearchResponse;
import com.atos.paybatch.stubs.customersearch.CustomersSearchService;
import com.atos.paybatch.stubs.customersearch.InputAttributes;
import com.atos.paybatch.util.SoapExceptionUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerSearchClient {

    private static final String FAILURE_STATUS = "F";

    private final CustomersSearchService customersSearchService;
    private final SessionBuilder sessionBuilder;
    private final PayBatchRecordRepository paymentRecordRepository;

    @Retryable(
        value = { TransientException.class },
        maxAttemptsExpression = "${customersearch.api.max-retries:3}",
        backoff = @Backoff(delayExpression = "${customersearch.api.retry-delay-ms:2000}")
    )
    public Long searchCustomer(PayBatchRecord record) {
        int attempt = RetrySynchronizationManager.getContext() != null
                ? RetrySynchronizationManager.getContext().getRetryCount() + 1
                : 1;

        log.info("│    → [CustomerSearch] Invoking API (attempt={})", attempt);

        try {
            CustomersSearchRequest request = buildRequest(record);
            CustomersSearchResponse response = customersSearchService.customersSearch(request);

            Long customerId = extractCustomerId(response).orElse(null);
            log.info("│    → [CustomerSearch] API response: customerId={}", customerId);

            if (customerId == null) {
                log.warn("│    → [CustomerSearch] No Customer ID returned for recordId={}", record.getId());
                markRecordFailed(record, "CustomerSearch returned no Customer ID");
            }

            return customerId;

        } catch (Exception ex) {
            log.error("│    → [CustomerSearch] API error (attempt={}): {}", attempt, ex.getMessage(), ex);

            boolean isTransient = SoapExceptionUtils.isTransient(ex);
            String rootMessage = SoapExceptionUtils.getRootCauseMessage(ex);

            if (isTransient) {
                throw new TransientException("Transient error: " + rootMessage, ex);
            } else {
                log.error("│    → [CustomerSearch] Record failed → recordId={} | reason={}", record.getId(), rootMessage);
                markRecordFailed(record, "CustomerSearch failed: " + rootMessage);
                return null;
            }
        }
    }

    @Recover
    public Long recover(RuntimeException ex, PayBatchRecord record) {
        String rootMessage = SoapExceptionUtils.getRootCauseMessage(ex);
        log.error("│    → [CustomerSearch] Record permanently failed after retries → recordId={} | reason={}", record.getId(), rootMessage);
        markRecordFailed(record, "CustomerSearch failed after all retry attempts: " + rootMessage);
        return null;
    }

    private CustomersSearchRequest buildRequest(PayBatchRecord record) {
        InputAttributes attributes = new InputAttributes();
        attributes.setCsCode(record.getCustomerCode());

        CustomersSearchRequest request = new CustomersSearchRequest();
        request.setInputAttributes(attributes);
        request.setSessionChangeRequest(sessionBuilder.buildCustomerSearchSession());

        log.debug("│    → [CustomerSearch] Request built for recordId={}", record.getId());
        return request;
    }

    private Optional<Long> extractCustomerId(CustomersSearchResponse response) {
        return Optional.ofNullable(response)
                .map(CustomersSearchResponse::getSearchResult)
                .map(result -> result.getItem())
                .filter(list -> !list.isEmpty())
                .map(list -> list.get(0).getCsId());
    }

    private void markRecordFailed(PayBatchRecord record, String remark) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        record.setStatus(FAILURE_STATUS);
        record.setUpdatedAt(currentDateTime);
        record.setRemark(remark);
        paymentRecordRepository.save(record);

        log.warn("│    → [CustomerSearch] Record {} marked as FAILED — reason: {}", record.getId(), remark);
    }
}
