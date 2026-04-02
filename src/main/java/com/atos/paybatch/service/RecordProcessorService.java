package com.atos.paybatch.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.paybatch.dto.CustomerDetails;
import com.atos.paybatch.entity.PayBatchRecord;
import com.atos.paybatch.soapclient.CustomerReadClient;
import com.atos.paybatch.soapclient.CustomerSearchClient;
import com.atos.paybatch.soapclient.FinancialAllocationClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Service responsible for orchestrating the processing of payment records.
 *
 * Processing flow: 1. Search for the customer ID via the CustomerSearch SOAP
 * service. 2. Post the financial allocation using the FinancialAllocation SOAP
 * service.
 *
 * Each client internally handles marking records as SUCCESS or FAILED. This
 * class coordinates the process and logs key steps for traceability.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RecordProcessorService {

	private final CustomerSearchClient customerSearchClient;
	private final FinancialAllocationClient financialAllocationClient;
	private final CustomerReadClient customerReadClient;
	

    @Value("${customer.prepaid-price-groups}")
    private String prepaidPriceGroupsConfig;

    @Value("${customer.allow-non-payment-resp}")
    private boolean allowNonPaymentResponsible;


	/**
	 * Processes a single payment record in a transactional context.
	 */
	@Transactional
	public Boolean processRecord(PayBatchRecord record, String glAccount) {
		String recordInfo = String.format("fileId=%d,line=%d,recordId=%d,customerCode=%s,amount=%s",
				record.getPayBatchFile().getId(), record.getLineNo(), record.getId(), record.getCustomerCode(),
				record.getPaymentAmount());

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

			// Step 2: Read Customer Details (priceGroup & paymentResponsible)
			log.info("│ → Step 2: Reading Customer details for customerId={}", customerId);
			CustomerDetails customerDetails = customerReadClient.readCustomer(customerId,record);

			if (customerDetails == null) {
				log.error("│ [SKIPPED] Customer read failed → customerId={}", customerId);
				log.info("└──────────── END RECORD ─────────────");
				return false;
			}

			String priceGroup = customerDetails.getPriceGroup();
			Boolean paymentResponsible = customerDetails.getPaymentResponsible();
			
			
			// Decide if this record can proceed
			if (!isPaymentAllowed(priceGroup, paymentResponsible)) {
			    log.info("└──────────── END RECORD ─────────────");
			    return false; // skip this record
			}


			log.info("│   ↳ priceGroup={}, paymentResponsible={}", priceGroup, paymentResponsible);

			// Step 3: Post Financial Allocation
			log.info("│ → Step 2: Writing Financial Allocation for recordId={} and customerId={}", record.getId(),
					customerId);
			Long transactionId = financialAllocationClient.writeFinancialAllocation(record, customerId, glAccount);

			if (transactionId == null) {
				log.error("│ [SKIPPED] Financial allocation failed → recordId={}, customerId={}", record.getId(),
						customerId);
				log.info("└──────────── END RECORD ─────────────");
				return false;
			}

			// Success
			log.info("│ [SUCCESS] Record processed → customerId={}, transactionId={}", customerId, transactionId);
			log.info("└──────────── END RECORD ─────────────");
			return true;

		} catch (Exception ex) {
			log.error("│ [ERROR] Record processing failed → recordId={}, customerCode={}, error={}", record.getId(),
					record.getCustomerCode(), ex.getMessage(), ex);
			log.info("└──────────── END RECORD ─────────────");
			return false;
		}
	}
	 // Helper to parse the list
    private List<String> prepaidPriceGroups() {
        return Arrays.stream(prepaidPriceGroupsConfig.split(","))
                .map(String::trim)
                .toList();
    }

    public boolean isPaymentAllowed(String priceGroup, Boolean paymentResponsible) {
        // Check prepaid price groups
        if (prepaidPriceGroups().contains(priceGroup)) {
            log.warn("│ [SKIPPED] Customer belongs to prepaid price group → priceGroup={}", priceGroup);
            return false;
        }

        // Check non-payment-responsible flag
        if (!paymentResponsible && !allowNonPaymentResponsible) {
            log.warn("│ [SKIPPED] Customer is not payment responsible → paymentResponsible={}", paymentResponsible);
            return false;
        }

        return true; 
    }
}
