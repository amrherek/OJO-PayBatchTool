
package com.atos.paybatch.stubs.financialallocation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for financialAllocationWriteInputDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="financialAllocationWriteInputDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="useCase" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}finUseCaseReferenceDTO" minOccurs="0"/&gt;
 *         &lt;element name="suppressAlloc" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="handlingReason" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}finHandlingReasonReferenceDTO" minOccurs="0"/&gt;
 *         &lt;element name="originalTransactionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="originalReferenceKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="simulation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="allocationMethod" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}finAllocationMethodReferenceDTO" minOccurs="0"/&gt;
 *         &lt;element name="externalSystem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="transactions" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}transactionListRequest" minOccurs="0"/&gt;
 *         &lt;element name="bankCharge" type="{http://lhsgroup.com/lhsws/money}money" minOccurs="0"/&gt;
 *         &lt;element name="handlingCharge" type="{http://lhsgroup.com/lhsws/money}money" minOccurs="0"/&gt;
 *         &lt;element name="suspendDirectDebit" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "financialAllocationWriteInputDTO", propOrder = {

})
public class FinancialAllocationWriteInputDTO {

    protected FinUseCaseReferenceDTO useCase;
    protected Boolean suppressAlloc;
    protected FinHandlingReasonReferenceDTO handlingReason;
    protected Long originalTransactionId;
    protected String originalReferenceKey;
    protected Boolean simulation;
    protected String remark;
    protected FinAllocationMethodReferenceDTO allocationMethod;
    protected String externalSystem;
    protected TransactionListRequest transactions;
    protected Money bankCharge;
    protected Money handlingCharge;
    protected Boolean suspendDirectDebit;

    /**
     * Gets the value of the useCase property.
     * 
     * @return
     *     possible object is
     *     {@link FinUseCaseReferenceDTO }
     *     
     */
    public FinUseCaseReferenceDTO getUseCase() {
        return useCase;
    }

    /**
     * Sets the value of the useCase property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinUseCaseReferenceDTO }
     *     
     */
    public void setUseCase(FinUseCaseReferenceDTO value) {
        this.useCase = value;
    }

    /**
     * Gets the value of the suppressAlloc property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSuppressAlloc() {
        return suppressAlloc;
    }

    /**
     * Sets the value of the suppressAlloc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSuppressAlloc(Boolean value) {
        this.suppressAlloc = value;
    }

    /**
     * Gets the value of the handlingReason property.
     * 
     * @return
     *     possible object is
     *     {@link FinHandlingReasonReferenceDTO }
     *     
     */
    public FinHandlingReasonReferenceDTO getHandlingReason() {
        return handlingReason;
    }

    /**
     * Sets the value of the handlingReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinHandlingReasonReferenceDTO }
     *     
     */
    public void setHandlingReason(FinHandlingReasonReferenceDTO value) {
        this.handlingReason = value;
    }

    /**
     * Gets the value of the originalTransactionId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOriginalTransactionId() {
        return originalTransactionId;
    }

    /**
     * Sets the value of the originalTransactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOriginalTransactionId(Long value) {
        this.originalTransactionId = value;
    }

    /**
     * Gets the value of the originalReferenceKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalReferenceKey() {
        return originalReferenceKey;
    }

    /**
     * Sets the value of the originalReferenceKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalReferenceKey(String value) {
        this.originalReferenceKey = value;
    }

    /**
     * Gets the value of the simulation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSimulation() {
        return simulation;
    }

    /**
     * Sets the value of the simulation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSimulation(Boolean value) {
        this.simulation = value;
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * Gets the value of the allocationMethod property.
     * 
     * @return
     *     possible object is
     *     {@link FinAllocationMethodReferenceDTO }
     *     
     */
    public FinAllocationMethodReferenceDTO getAllocationMethod() {
        return allocationMethod;
    }

    /**
     * Sets the value of the allocationMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinAllocationMethodReferenceDTO }
     *     
     */
    public void setAllocationMethod(FinAllocationMethodReferenceDTO value) {
        this.allocationMethod = value;
    }

    /**
     * Gets the value of the externalSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalSystem() {
        return externalSystem;
    }

    /**
     * Sets the value of the externalSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalSystem(String value) {
        this.externalSystem = value;
    }

    /**
     * Gets the value of the transactions property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionListRequest }
     *     
     */
    public TransactionListRequest getTransactions() {
        return transactions;
    }

    /**
     * Sets the value of the transactions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionListRequest }
     *     
     */
    public void setTransactions(TransactionListRequest value) {
        this.transactions = value;
    }

    /**
     * Gets the value of the bankCharge property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getBankCharge() {
        return bankCharge;
    }

    /**
     * Sets the value of the bankCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setBankCharge(Money value) {
        this.bankCharge = value;
    }

    /**
     * Gets the value of the handlingCharge property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getHandlingCharge() {
        return handlingCharge;
    }

    /**
     * Sets the value of the handlingCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setHandlingCharge(Money value) {
        this.handlingCharge = value;
    }

    /**
     * Gets the value of the suspendDirectDebit property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSuspendDirectDebit() {
        return suspendDirectDebit;
    }

    /**
     * Sets the value of the suspendDirectDebit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSuspendDirectDebit(Boolean value) {
        this.suspendDirectDebit = value;
    }

}
