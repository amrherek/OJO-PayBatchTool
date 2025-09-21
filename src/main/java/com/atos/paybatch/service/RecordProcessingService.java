package com.atos.paybatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atos.paybatch.dto.PaymentRecordDTO;
import com.atos.paybatch.entity.InboundFile;
import com.atos.paybatch.entity.PaymentRecord;
import com.atos.paybatch.repository.PaymentRecordRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecordProcessingService {

	private final PaymentRecordRepository paymentRecordRepository;
	private final ApiService apiService;

	/**
	 * Processes a single payment record. Invalid records are persisted with remark,
	 * valid records trigger API processing.
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean processSingleRecord(PaymentRecordDTO recordDTO, InboundFile inboundFile) {
	    // Map DTO to entity and save it
	    PaymentRecord record = mapDtoToEntity(recordDTO, inboundFile);
	    paymentRecordRepository.save(record);

	    // Return true or false based on payment processing result
	    return processPayment(record, inboundFile);
	}

	/**
	 * Maps PaymentRecordDTO to PaymentRecord entity.
	 */
	private PaymentRecord mapDtoToEntity(PaymentRecordDTO recordDTO, InboundFile inboundFile) {
		PaymentRecord record = new PaymentRecord();
		record.setInboundFile(inboundFile);
		record.setLineNo(recordDTO.getLineNo());
		record.setRecType(recordDTO.getRecType());
		record.setPaymentType(recordDTO.getPaymentType());
		record.setBankAccount(recordDTO.getBankAccount());
		record.setCustomerCode(recordDTO.getCustomerCode());
		record.setInvoiceNo(recordDTO.getInvoiceNo());
		record.setPaymentAmount(recordDTO.getPaymentAmount());
		record.setPaymentDate(recordDTO.getPaymentDate());
		record.setRejectionReason(recordDTO.getRejectionReason());
		record.setRawLine(recordDTO.getRawLine());
		return record;
	}

	/**
	 * Calls external APIs to process the payment. Updates record status,
	 * transaction ID, and saves changes.
	 */
	private boolean processPayment(PaymentRecord record, InboundFile inboundFile) {
		try {
			return apiService.processRecord(record, inboundFile.getChannel().getGlAccount());	
			
		} catch (Exception e) {
			log.error("Error processing record line {}: {}", record.getLineNo(), e.getMessage(), e);
			record.incrementRetryCnt();
			record.setStatus("F");
			record.setRejectionReason("API processing error");
			paymentRecordRepository.save(record);
			return false;
		}
	}
}