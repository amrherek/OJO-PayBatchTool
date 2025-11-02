package com.atos.paybatch.soapclient;

import com.atos.paybatch.entity.PayBatchRecord;
import com.atos.paybatch.stubs.financialallocation.*;
import com.atos.paybatch.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Map;

@Component
@Slf4j
public class RequestBuilder {

    // Map for PaymentType mapping
    private static final Map<String, String> PAYMENT_TYPE_MAP = Map.of(
            "1", "P", // Cash
            "2", "H", // Cheque
            "3", "R"  // Direct Debit
    );

    /**
     * Builds the FinancialAllocationWriteRequest based on PaymentRecord details.
     */
    public FinancialAllocationWriteRequest buildFinancialAllocationWriteRequest(
            PayBatchRecord record,
            Long customerId,
            String glaccount,
            SessionChangeRequest sessionChangeRequest
    ) {
        log.debug("Building FinancialAllocationWriteRequest for record {}", record.getId());

        FinancialAllocationWriteRequest request = new FinancialAllocationWriteRequest();
        request.setSessionChangeRequest(sessionChangeRequest);

        // Input attributes & DTO
        InputAttributes inputAttributes = new InputAttributes();
        FinancialAllocationWriteInputDTO inputDto = new FinancialAllocationWriteInputDTO();

        // Use case
        FinUseCaseReferenceDTO useCase = new FinUseCaseReferenceDTO();
        useCase.setPublicKey("PAYMENT");
        inputDto.setUseCase(useCase);

        // Remark from filename
        inputDto.setRemark(record.getPayBatchFile().getFilename());

        // Build Transaction DTO
        TransactionWriteInDTO transactionDto = buildTransaction(record, customerId, glaccount);

        // Add transaction to list
        TransactionListRequest transactionList = new TransactionListRequest();
        transactionList.getTransactionWriteInDTO().add(transactionDto);
        inputDto.setTransactions(transactionList);

        // Set into attributes
        inputAttributes.setFinancialAllocationWriteInputDTO(inputDto);
        request.setInputAttributes(inputAttributes);

        log.debug("FinancialAllocationWriteRequest built for record {}: {}", record.getId(), request);
        return request;
    }

    /**
     * Builds TransactionWriteInDTO for each PaymentRecord.
     */
    private TransactionWriteInDTO buildTransaction(PayBatchRecord record, Long customerId, String glaccount) {
        TransactionWriteInDTO transactionDto = new TransactionWriteInDTO();

        // Customer
        FinCustomerReferenceDTO customerRef = new FinCustomerReferenceDTO();
        customerRef.setPrivateKey(customerId);
        transactionDto.setCustomer(customerRef);

        // Payment method mapping
        FinPaymentMethodReferenceDTO paymentMethod = new FinPaymentMethodReferenceDTO();
        String paymentTypeCode = PAYMENT_TYPE_MAP.getOrDefault(record.getPaymentType(), "P");
        paymentMethod.setPublicKey(paymentTypeCode);
        transactionDto.setPaymentMethod(paymentMethod);

        // Amount
        Money amount = new Money();
        amount.setAmount(record.getPaymentAmount());
        amount.setCurrency("JOD");
        transactionDto.setAmount(amount);

        // Reference key
        transactionDto.setReferenceKey(record.getUniqueSeq());
        

        // GL cash account
        transactionDto.setRefGLAccountCash(glaccount);

        // Dates
        XMLGregorianCalendar xmlDate = DateUtil.toXMLGregorianCalendar(record.getPaymentDate());
        transactionDto.setReferenceDate(xmlDate);
        transactionDto.setEntryDate(xmlDate);

        // Documents (only if invoice no. not all zeros)
        if (record.getInvoiceNo() != null && !record.getInvoiceNo().trim().matches("0+")) {
            transactionDto.setDocuments(buildDocumentList(record));
        }

        return transactionDto;
    }

    /**
     * Builds DocumentListRequest if invoice number is valid.
     */
    private DocumentListRequest buildDocumentList(PayBatchRecord record) {
        DocumentListRequest documentList = new DocumentListRequest();
        DocumentDTO documentDTO = new DocumentDTO();

        documentDTO.setCode(record.getInvoiceNo());

        Money invoiceAmount = new Money();
        invoiceAmount.setAmount(record.getPaymentAmount());
        invoiceAmount.setCurrency("JOD");
        documentDTO.setAmount(invoiceAmount);

        documentList.getDocumentDTO().add(documentDTO);
        return documentList;
    }
}
