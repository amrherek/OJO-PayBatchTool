
package com.atos.paybatch.soapclient;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetrySynchronizationManager;
import org.springframework.stereotype.Component;

import com.atos.paybatch.dto.CustomerDetails;
import com.atos.paybatch.entity.PayBatchRecord;
import com.atos.paybatch.exception.TransientException;
import com.atos.paybatch.repository.PayBatchRecordRepository;
import com.atos.paybatch.stubs.customerread.CustomerReadRequest;
import com.atos.paybatch.stubs.customerread.CustomerReadResponse;
import com.atos.paybatch.stubs.customerread.CustomerReadService;
import com.atos.paybatch.stubs.customerread.InputAttributes;
import com.atos.paybatch.util.SoapExceptionUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerReadClient {

	private static final String FAILURE_STATUS = "F";

	private final CustomerReadService customerReadService;
	private final SessionBuilder sessionBuilder;
	private final PayBatchRecordRepository paymentRecordRepository;

	@Retryable(value = {
			TransientException.class }, maxAttemptsExpression = "${customerread.api.max-retries:3}", backoff = @Backoff(delayExpression = "${customerread.api.retry-delay-ms:2000}"))
	public CustomerDetails readCustomer(Long customerId, PayBatchRecord record) {

		int attempt = RetrySynchronizationManager.getContext() != null
				? RetrySynchronizationManager.getContext().getRetryCount() + 1
				: 1;

		log.info("│    → [CustomerRead] Invoking API (attempt={})", attempt);

		try {
			CustomerReadRequest request = buildRequest(customerId);
			CustomerReadResponse response = customerReadService.customerRead(request);

			CustomerDetails details = extractCustomerDetails(response).orElse(null);

			log.info("│    → [CustomerRead] API response: priceGroup={}, paymentResponsible={}",
					details != null ? details.getPriceGroup() : null,
					details != null ? details.getPaymentResponsible() : null);

			if (details == null) {
				log.error("│    → [CustomerRead] No data returned for customerId={}", customerId);
				markRecordFailed(record, "CustomerRead returned no data");
			}

			return details;

		} catch (Exception ex) {
			log.error("│    → [CustomerRead] API error (attempt={}): {}", attempt, ex.getMessage(), ex);

			boolean isTransient = SoapExceptionUtils.isTransient(ex);
			String rootMessage = SoapExceptionUtils.getRootCauseMessage(ex);

			if (isTransient) {
				throw new TransientException("Transient error: " + rootMessage, ex);
			} else {
				log.error("│    → [CustomerRead] Record failed → recordId={} | reason={}", record.getId(), rootMessage);
				markRecordFailed(record, "CustomerRead failed: " + rootMessage);
				return null;
			}
		}
	}

	@Recover
	public CustomerDetails recover(RuntimeException ex, Long customerId, PayBatchRecord record) {
		String rootMessage = SoapExceptionUtils.getRootCauseMessage(ex);
		log.error("│    → [CustomerRead] Record permanently failed after retries → recordId={} | reason={}",
				record.getId(), rootMessage);
		markRecordFailed(record, "CustomerRead failed after all retry attempts: " + rootMessage);
		return null;
	}

	private CustomerReadRequest buildRequest(Long customerId) {
		InputAttributes attributes = new InputAttributes();
		attributes.setCsId(customerId);;
		//attributes.setSyncWithDb(Boolean.FALSE);
		
		CustomerReadRequest request = new CustomerReadRequest();
		request.setInputAttributes(attributes);
		request.setSessionChangeRequest(sessionBuilder.buildCustomerReadSession());

		log.debug("│    → [CustomerRead] Request built for customerId={}", customerId);
		return request;
	}

	private Optional<CustomerDetails> extractCustomerDetails(CustomerReadResponse response) {
		return Optional.ofNullable(response).map(resp -> {
			CustomerDetails details = new CustomerDetails();

			// prgCode → priceGroup
			if (resp.getPrgCode() != null) {
				details.setPriceGroup(String.valueOf(resp.getPrgCode()));
			}

			// paymentResp → paymentResponsible (Boolean مباشرة)
			details.setPaymentResponsible(resp.isPaymentResp());

			return details;
		});
	}

	private void markRecordFailed(PayBatchRecord record, String remark) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		record.setStatus(FAILURE_STATUS);
		record.setUpdatedAt(currentDateTime);
		record.setRemark(remark);
		paymentRecordRepository.save(record);

		log.error("│    → [CustomerRead] Record {} marked as FAILED — reason: {}", record.getId(), remark);
	}
}
