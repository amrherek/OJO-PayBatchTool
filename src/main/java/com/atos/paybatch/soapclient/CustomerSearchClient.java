package com.atos.paybatch.soapclient;

import com.atos.paybatch.entity.PaymentRecord;
import com.atos.paybatch.stubs.customersearch.CustomersSearchRequest;
import com.atos.paybatch.stubs.customersearch.CustomersSearchResponse;
import com.atos.paybatch.stubs.customersearch.CustomersSearchService;
import com.atos.paybatch.stubs.customersearch.InputAttributes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Client responsible for invoking the CustomerSearch SOAP service.
 * Handles request preparation, service call, response processing, and retry logic.
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerSearchClient {

    private static final String FAILURE_STATUS = "F";

    private final CustomersSearchService customersSearchService;
    private final SessionBuilder sessionBuilder;

    /**
     * Searches customer by customerCode with retry logic in case of transient failures.
     */
    @Retryable(
            value = {RuntimeException.class},
            maxAttemptsExpression = "${payment.api.max-retries:3}",
            backoff = @Backoff(delayExpression = "${payment.api.retry-delay-ms:2000}")
    )
    public Long searchCustomer(PaymentRecord record) {
        log.info("Invoking CustomerSearch for customerCode={} (attempt #{})",
                record.getCustomerCode(), record.getRetryCount() + 1);

        try {
            CustomersSearchRequest request = buildRequest(record);
            log.debug("CustomerSearch request: {}", request);

            CustomersSearchResponse response = customersSearchService.customersSearch(request);
            log.debug("CustomerSearch response: {}", response);

            return extractCustomerId(response)
                    .orElseThrow(() -> new RuntimeException("Customer ID not found in response"));

        } catch (Exception ex) {
            record.incrementRetryCnt();
            log.error("CustomerSearch call failed for recordId={} error={}", record.getId(), ex.getMessage(), ex);
            throw new RuntimeException("CustomerSearch API call failed", ex);
        }
    }

    /**
     * Fallback method triggered after all retries fail.
     *
     * @param ex     Exception that caused the failure
     * @param record PaymentRecord being processed
     * @return null always, as failure is handled via record status
     */
    @Recover
    public String recover(RuntimeException ex, PaymentRecord record) {
        log.error("CustomerSearch permanently failed for recordId={} after {} retries: {}",
                record.getId(), record.getRetryCount(), ex.getMessage(), ex);
        record.setStatus(FAILURE_STATUS);
        record.setRemark(ex.getMessage());
        return null;
    }

    /**
     * Builds the SOAP request for CustomerSearch.
     */
    private CustomersSearchRequest buildRequest(PaymentRecord record) {
        InputAttributes attributes = new InputAttributes();
        attributes.setCsCode(record.getCustomerCode());

        CustomersSearchRequest request = new CustomersSearchRequest();
        request.setInputAttributes(attributes);
        request.setSessionChangeRequest(sessionBuilder.buildCustomerSearchSession());
        return request;
    }

    /**
     * Extracts customer ID from the response, wrapped in Optional.
     */
    private Optional<Long> extractCustomerId(CustomersSearchResponse response) {
        return Optional.ofNullable(response)
                .map(CustomersSearchResponse::getSearchResult)
                .map(result -> result.getItem())
                .filter(items -> !items.isEmpty())
                .map(items -> items.get(0).getCsId());
    }
}
