
package com.atos.paybatch.stubs.financialallocation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for transactionWriteInDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transactionWriteInDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="customer" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}finCustomerReferenceDTO" minOccurs="0"/&gt;
 *         &lt;element name="billingAccount" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}finBillingAccountReferenceDTO" minOccurs="0"/&gt;
 *         &lt;element name="paymentMethod" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}finPaymentMethodReferenceDTO" minOccurs="0"/&gt;
 *         &lt;element name="amount" type="{http://lhsgroup.com/lhsws/money}money" minOccurs="0"/&gt;
 *         &lt;element name="amountDiscountPay" type="{http://lhsgroup.com/lhsws/money}money" minOccurs="0"/&gt;
 *         &lt;element name="largeAccountClearing" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="referenceKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference14" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference15" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference16" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference17" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference18" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference19" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reference20" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="refGLAccountCash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="referenceDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="refBankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="refBankAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="refBankName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="refValidThrough" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="entryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="dueDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="releaseDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="permanentTokenId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="oneTimeToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="oneTimeTokenExpiration" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="bic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="iban" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="batchNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="postingPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="documents" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}documentListRequest" minOccurs="0"/&gt;
 *         &lt;element name="aggregationCriteria" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}aggregationCriteriaListRequest" minOccurs="0"/&gt;
 *         &lt;element name="allocationTerms" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}finAllocationTermsReferenceDTO" minOccurs="0"/&gt;
 *         &lt;element name="paymentChannel" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}finPaymentChannelReferenceDTO" minOccurs="0"/&gt;
 *         &lt;element name="paymentSource" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}finPaymentSourceReferenceDTO" minOccurs="0"/&gt;
 *         &lt;element name="debitDueDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="firstDebitInformation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="secondDebitInformation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="glAccountForDiscounts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transactionWriteInDTO", propOrder = {

})
public class TransactionWriteInDTO {

    protected FinCustomerReferenceDTO customer;
    protected FinBillingAccountReferenceDTO billingAccount;
    protected FinPaymentMethodReferenceDTO paymentMethod;
    protected Money amount;
    protected Money amountDiscountPay;
    protected Boolean largeAccountClearing;
    protected String referenceKey;
    protected String reference1;
    protected String reference2;
    protected String reference3;
    protected String reference4;
    protected String reference5;
    protected String reference6;
    protected String reference7;
    protected String reference8;
    protected String reference9;
    protected String reference10;
    protected String reference11;
    protected String reference12;
    protected String reference13;
    protected String reference14;
    protected String reference15;
    protected String reference16;
    protected String reference17;
    protected String reference18;
    protected String reference19;
    protected String reference20;
    protected String refGLAccountCash;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar referenceDate;
    protected String refBankCode;
    protected String refBankAccount;
    protected String refBankName;
    protected String refValidThrough;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar entryDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dueDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar releaseDate;
    protected Long permanentTokenId;
    protected String oneTimeToken;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar oneTimeTokenExpiration;
    protected String bic;
    protected String iban;
    protected Long batchNo;
    protected String postingPeriod;
    protected DocumentListRequest documents;
    protected AggregationCriteriaListRequest aggregationCriteria;
    protected FinAllocationTermsReferenceDTO allocationTerms;
    protected FinPaymentChannelReferenceDTO paymentChannel;
    protected FinPaymentSourceReferenceDTO paymentSource;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar debitDueDate;
    protected String firstDebitInformation;
    protected String secondDebitInformation;
    protected String glAccountForDiscounts;

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link FinCustomerReferenceDTO }
     *     
     */
    public FinCustomerReferenceDTO getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinCustomerReferenceDTO }
     *     
     */
    public void setCustomer(FinCustomerReferenceDTO value) {
        this.customer = value;
    }

    /**
     * Gets the value of the billingAccount property.
     * 
     * @return
     *     possible object is
     *     {@link FinBillingAccountReferenceDTO }
     *     
     */
    public FinBillingAccountReferenceDTO getBillingAccount() {
        return billingAccount;
    }

    /**
     * Sets the value of the billingAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinBillingAccountReferenceDTO }
     *     
     */
    public void setBillingAccount(FinBillingAccountReferenceDTO value) {
        this.billingAccount = value;
    }

    /**
     * Gets the value of the paymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link FinPaymentMethodReferenceDTO }
     *     
     */
    public FinPaymentMethodReferenceDTO getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the value of the paymentMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinPaymentMethodReferenceDTO }
     *     
     */
    public void setPaymentMethod(FinPaymentMethodReferenceDTO value) {
        this.paymentMethod = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setAmount(Money value) {
        this.amount = value;
    }

    /**
     * Gets the value of the amountDiscountPay property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getAmountDiscountPay() {
        return amountDiscountPay;
    }

    /**
     * Sets the value of the amountDiscountPay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setAmountDiscountPay(Money value) {
        this.amountDiscountPay = value;
    }

    /**
     * Gets the value of the largeAccountClearing property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLargeAccountClearing() {
        return largeAccountClearing;
    }

    /**
     * Sets the value of the largeAccountClearing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLargeAccountClearing(Boolean value) {
        this.largeAccountClearing = value;
    }

    /**
     * Gets the value of the referenceKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceKey() {
        return referenceKey;
    }

    /**
     * Sets the value of the referenceKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceKey(String value) {
        this.referenceKey = value;
    }

    /**
     * Gets the value of the reference1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference1() {
        return reference1;
    }

    /**
     * Sets the value of the reference1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference1(String value) {
        this.reference1 = value;
    }

    /**
     * Gets the value of the reference2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference2() {
        return reference2;
    }

    /**
     * Sets the value of the reference2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference2(String value) {
        this.reference2 = value;
    }

    /**
     * Gets the value of the reference3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference3() {
        return reference3;
    }

    /**
     * Sets the value of the reference3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference3(String value) {
        this.reference3 = value;
    }

    /**
     * Gets the value of the reference4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference4() {
        return reference4;
    }

    /**
     * Sets the value of the reference4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference4(String value) {
        this.reference4 = value;
    }

    /**
     * Gets the value of the reference5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference5() {
        return reference5;
    }

    /**
     * Sets the value of the reference5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference5(String value) {
        this.reference5 = value;
    }

    /**
     * Gets the value of the reference6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference6() {
        return reference6;
    }

    /**
     * Sets the value of the reference6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference6(String value) {
        this.reference6 = value;
    }

    /**
     * Gets the value of the reference7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference7() {
        return reference7;
    }

    /**
     * Sets the value of the reference7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference7(String value) {
        this.reference7 = value;
    }

    /**
     * Gets the value of the reference8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference8() {
        return reference8;
    }

    /**
     * Sets the value of the reference8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference8(String value) {
        this.reference8 = value;
    }

    /**
     * Gets the value of the reference9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference9() {
        return reference9;
    }

    /**
     * Sets the value of the reference9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference9(String value) {
        this.reference9 = value;
    }

    /**
     * Gets the value of the reference10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference10() {
        return reference10;
    }

    /**
     * Sets the value of the reference10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference10(String value) {
        this.reference10 = value;
    }

    /**
     * Gets the value of the reference11 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference11() {
        return reference11;
    }

    /**
     * Sets the value of the reference11 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference11(String value) {
        this.reference11 = value;
    }

    /**
     * Gets the value of the reference12 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference12() {
        return reference12;
    }

    /**
     * Sets the value of the reference12 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference12(String value) {
        this.reference12 = value;
    }

    /**
     * Gets the value of the reference13 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference13() {
        return reference13;
    }

    /**
     * Sets the value of the reference13 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference13(String value) {
        this.reference13 = value;
    }

    /**
     * Gets the value of the reference14 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference14() {
        return reference14;
    }

    /**
     * Sets the value of the reference14 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference14(String value) {
        this.reference14 = value;
    }

    /**
     * Gets the value of the reference15 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference15() {
        return reference15;
    }

    /**
     * Sets the value of the reference15 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference15(String value) {
        this.reference15 = value;
    }

    /**
     * Gets the value of the reference16 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference16() {
        return reference16;
    }

    /**
     * Sets the value of the reference16 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference16(String value) {
        this.reference16 = value;
    }

    /**
     * Gets the value of the reference17 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference17() {
        return reference17;
    }

    /**
     * Sets the value of the reference17 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference17(String value) {
        this.reference17 = value;
    }

    /**
     * Gets the value of the reference18 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference18() {
        return reference18;
    }

    /**
     * Sets the value of the reference18 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference18(String value) {
        this.reference18 = value;
    }

    /**
     * Gets the value of the reference19 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference19() {
        return reference19;
    }

    /**
     * Sets the value of the reference19 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference19(String value) {
        this.reference19 = value;
    }

    /**
     * Gets the value of the reference20 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference20() {
        return reference20;
    }

    /**
     * Sets the value of the reference20 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference20(String value) {
        this.reference20 = value;
    }

    /**
     * Gets the value of the refGLAccountCash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefGLAccountCash() {
        return refGLAccountCash;
    }

    /**
     * Sets the value of the refGLAccountCash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefGLAccountCash(String value) {
        this.refGLAccountCash = value;
    }

    /**
     * Gets the value of the referenceDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReferenceDate() {
        return referenceDate;
    }

    /**
     * Sets the value of the referenceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReferenceDate(XMLGregorianCalendar value) {
        this.referenceDate = value;
    }

    /**
     * Gets the value of the refBankCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefBankCode() {
        return refBankCode;
    }

    /**
     * Sets the value of the refBankCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefBankCode(String value) {
        this.refBankCode = value;
    }

    /**
     * Gets the value of the refBankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefBankAccount() {
        return refBankAccount;
    }

    /**
     * Sets the value of the refBankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefBankAccount(String value) {
        this.refBankAccount = value;
    }

    /**
     * Gets the value of the refBankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefBankName() {
        return refBankName;
    }

    /**
     * Sets the value of the refBankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefBankName(String value) {
        this.refBankName = value;
    }

    /**
     * Gets the value of the refValidThrough property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefValidThrough() {
        return refValidThrough;
    }

    /**
     * Sets the value of the refValidThrough property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefValidThrough(String value) {
        this.refValidThrough = value;
    }

    /**
     * Gets the value of the entryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEntryDate() {
        return entryDate;
    }

    /**
     * Sets the value of the entryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEntryDate(XMLGregorianCalendar value) {
        this.entryDate = value;
    }

    /**
     * Gets the value of the dueDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDueDate() {
        return dueDate;
    }

    /**
     * Sets the value of the dueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDueDate(XMLGregorianCalendar value) {
        this.dueDate = value;
    }

    /**
     * Gets the value of the releaseDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the value of the releaseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReleaseDate(XMLGregorianCalendar value) {
        this.releaseDate = value;
    }

    /**
     * Gets the value of the permanentTokenId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPermanentTokenId() {
        return permanentTokenId;
    }

    /**
     * Sets the value of the permanentTokenId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPermanentTokenId(Long value) {
        this.permanentTokenId = value;
    }

    /**
     * Gets the value of the oneTimeToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOneTimeToken() {
        return oneTimeToken;
    }

    /**
     * Sets the value of the oneTimeToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOneTimeToken(String value) {
        this.oneTimeToken = value;
    }

    /**
     * Gets the value of the oneTimeTokenExpiration property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOneTimeTokenExpiration() {
        return oneTimeTokenExpiration;
    }

    /**
     * Sets the value of the oneTimeTokenExpiration property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOneTimeTokenExpiration(XMLGregorianCalendar value) {
        this.oneTimeTokenExpiration = value;
    }

    /**
     * Gets the value of the bic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBic() {
        return bic;
    }

    /**
     * Sets the value of the bic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBic(String value) {
        this.bic = value;
    }

    /**
     * Gets the value of the iban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIban() {
        return iban;
    }

    /**
     * Sets the value of the iban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIban(String value) {
        this.iban = value;
    }

    /**
     * Gets the value of the batchNo property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBatchNo() {
        return batchNo;
    }

    /**
     * Sets the value of the batchNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBatchNo(Long value) {
        this.batchNo = value;
    }

    /**
     * Gets the value of the postingPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostingPeriod() {
        return postingPeriod;
    }

    /**
     * Sets the value of the postingPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostingPeriod(String value) {
        this.postingPeriod = value;
    }

    /**
     * Gets the value of the documents property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentListRequest }
     *     
     */
    public DocumentListRequest getDocuments() {
        return documents;
    }

    /**
     * Sets the value of the documents property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentListRequest }
     *     
     */
    public void setDocuments(DocumentListRequest value) {
        this.documents = value;
    }

    /**
     * Gets the value of the aggregationCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link AggregationCriteriaListRequest }
     *     
     */
    public AggregationCriteriaListRequest getAggregationCriteria() {
        return aggregationCriteria;
    }

    /**
     * Sets the value of the aggregationCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link AggregationCriteriaListRequest }
     *     
     */
    public void setAggregationCriteria(AggregationCriteriaListRequest value) {
        this.aggregationCriteria = value;
    }

    /**
     * Gets the value of the allocationTerms property.
     * 
     * @return
     *     possible object is
     *     {@link FinAllocationTermsReferenceDTO }
     *     
     */
    public FinAllocationTermsReferenceDTO getAllocationTerms() {
        return allocationTerms;
    }

    /**
     * Sets the value of the allocationTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinAllocationTermsReferenceDTO }
     *     
     */
    public void setAllocationTerms(FinAllocationTermsReferenceDTO value) {
        this.allocationTerms = value;
    }

    /**
     * Gets the value of the paymentChannel property.
     * 
     * @return
     *     possible object is
     *     {@link FinPaymentChannelReferenceDTO }
     *     
     */
    public FinPaymentChannelReferenceDTO getPaymentChannel() {
        return paymentChannel;
    }

    /**
     * Sets the value of the paymentChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinPaymentChannelReferenceDTO }
     *     
     */
    public void setPaymentChannel(FinPaymentChannelReferenceDTO value) {
        this.paymentChannel = value;
    }

    /**
     * Gets the value of the paymentSource property.
     * 
     * @return
     *     possible object is
     *     {@link FinPaymentSourceReferenceDTO }
     *     
     */
    public FinPaymentSourceReferenceDTO getPaymentSource() {
        return paymentSource;
    }

    /**
     * Sets the value of the paymentSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinPaymentSourceReferenceDTO }
     *     
     */
    public void setPaymentSource(FinPaymentSourceReferenceDTO value) {
        this.paymentSource = value;
    }

    /**
     * Gets the value of the debitDueDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDebitDueDate() {
        return debitDueDate;
    }

    /**
     * Sets the value of the debitDueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDebitDueDate(XMLGregorianCalendar value) {
        this.debitDueDate = value;
    }

    /**
     * Gets the value of the firstDebitInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstDebitInformation() {
        return firstDebitInformation;
    }

    /**
     * Sets the value of the firstDebitInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstDebitInformation(String value) {
        this.firstDebitInformation = value;
    }

    /**
     * Gets the value of the secondDebitInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondDebitInformation() {
        return secondDebitInformation;
    }

    /**
     * Sets the value of the secondDebitInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondDebitInformation(String value) {
        this.secondDebitInformation = value;
    }

    /**
     * Gets the value of the glAccountForDiscounts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlAccountForDiscounts() {
        return glAccountForDiscounts;
    }

    /**
     * Sets the value of the glAccountForDiscounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlAccountForDiscounts(String value) {
        this.glAccountForDiscounts = value;
    }

}
