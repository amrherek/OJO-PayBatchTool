
package com.atos.paybatch.soapclient;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
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
	@Value("${customer.prepaid-price-groups}")
	private String prepaidPriceGroupsConfig;

	@Value("${customer.allow-non-payment-resp}")
	private boolean allowNonPaymentResponsible;

	@Retryable(value = {
			TransientException.class }, maxAttemptsExpression = "${customerread.api.max-retries:3}", backoff = @Backoff(delayExpression = "${customerread.api.retry-delay-ms:2000}"))
	public boolean readCustomer(Long customerId, PayBatchRecord record) {

		int attempt = RetrySynchronizationManager.getContext() != null
				? RetrySynchronizationManager.getContext().getRetryCount() + 1
				: 1;

		log.info("│    → [CustomerRead] Invoking API (attempt={})", attempt);

		try {
			CustomerReadRequest request = buildRequest(customerId);
			CustomerReadResponse response = customerReadService.customerRead(request);

			CustomerDetails details = extractCustomerDetails(response).orElse(null);

			if (details == null) {
				log.error("│    → [CustomerRead] No data returned for customerId={}", customerId);
				markRecordFailed(record, "CustomerRead returned no data");
				return false;
			}

			String priceGroup = details.getPriceGroup();
			Boolean paymentResponsible = details.getPaymentResponsible();

			log.info("│    → [CustomerRead] API response: priceGroup={}, paymentResponsible={}", priceGroup,
					paymentResponsible);

			// APPLY SAME LOGIC HERE
			return isPaymentAllowed(priceGroup, paymentResponsible, record);

		} catch (Exception ex) {
			log.error("│    → [CustomerRead] API error (attempt={}): {}", attempt, ex.getMessage(), ex);

			boolean isTransient = SoapExceptionUtils.isTransient(ex);
			String rootMessage = SoapExceptionUtils.getRootCauseMessage(ex);

			if (isTransient) {
				throw new TransientException("Transient error: " + rootMessage, ex);
			} else {
				log.error("│    → [CustomerRead] Record failed → recordId={} | reason={}", record.getId(), rootMessage);
				markRecordFailed(record, "CustomerRead failed: " + rootMessage);
				return false;
			}
		}
	}

	@Recover
	public boolean recover(RuntimeException ex, Long customerId, PayBatchRecord record) {
		String rootMessage = SoapExceptionUtils.getRootCauseMessage(ex);
		log.error("│    → [CustomerRead] Record permanently failed after retries → recordId={} | reason={}",
				record.getId(), rootMessage);
		markRecordFailed(record, "CustomerRead failed after all retry attempts: " + rootMessage);
		return false;
	}

	private CustomerReadRequest buildRequest(Long customerId) {
		InputAttributes attributes = new InputAttributes();
		attributes.setCsId(customerId);
		;
		// attributes.setSyncWithDb(Boolean.FALSE);

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

	private List<String> prepaidPriceGroups() {
		return Arrays.stream(prepaidPriceGroupsConfig.split(",")).map(String::trim).toList();
	}

	private boolean isPaymentAllowed(String priceGroup, Boolean paymentResponsible, PayBatchRecord record) {

		if (priceGroup != null && prepaidPriceGroups().contains(priceGroup))
		 {
			String remark = "Customer belongs to prepaid price group: " + priceGroup;
			markRecordFailed(record, remark);
			log.error("│ [SKIPPED] Customer belongs to prepaid price group → recordId={}, priceGroup={}",
					record.getId(), priceGroup);
			return false;
		}

		if (Boolean.FALSE.equals(paymentResponsible) && !allowNonPaymentResponsible) {
			String remark = "Customer is not payment responsible";
			markRecordFailed(record, remark);
			log.error("│ [SKIPPED] Customer is not payment responsible → recordId={}, paymentResponsible={}",
					record.getId(), paymentResponsible);
			return false;
		}

		return true;
	}

}
