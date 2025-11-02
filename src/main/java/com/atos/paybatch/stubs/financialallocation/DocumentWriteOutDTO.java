
package com.atos.paybatch.stubs.financialallocation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for documentWriteOutDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="documentWriteOutDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="documentId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="documentCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="amount" type="{http://lhsgroup.com/lhsws/money}money" minOccurs="0"/&gt;
 *         &lt;element name="amountNet" type="{http://lhsgroup.com/lhsws/money}money" minOccurs="0"/&gt;
 *         &lt;element name="grantedDiscountAmountDoc" type="{http://lhsgroup.com/lhsws/money}money" minOccurs="0"/&gt;
 *         &lt;element name="billingAccountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="billingAccountIdPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lineItems" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}lineItemListResponse" minOccurs="0"/&gt;
 *         &lt;element name="taxItems" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}categoryTaxItemListResponse" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "documentWriteOutDTO", propOrder = {

})
public class DocumentWriteOutDTO {

    protected Long documentId;
    protected String documentCode;
    protected String type;
    protected Money amount;
    protected Money amountNet;
    protected Money grantedDiscountAmountDoc;
    protected Long billingAccountId;
    protected String billingAccountIdPub;
    protected LineItemListResponse lineItems;
    protected CategoryTaxItemListResponse taxItems;

    /**
     * Gets the value of the documentId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDocumentId() {
        return documentId;
    }

    /**
     * Sets the value of the documentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDocumentId(Long value) {
        this.documentId = value;
    }

    /**
     * Gets the value of the documentCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentCode() {
        return documentCode;
    }

    /**
     * Sets the value of the documentCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentCode(String value) {
        this.documentCode = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
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
     * Gets the value of the amountNet property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getAmountNet() {
        return amountNet;
    }

    /**
     * Sets the value of the amountNet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setAmountNet(Money value) {
        this.amountNet = value;
    }

    /**
     * Gets the value of the grantedDiscountAmountDoc property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getGrantedDiscountAmountDoc() {
        return grantedDiscountAmountDoc;
    }

    /**
     * Sets the value of the grantedDiscountAmountDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setGrantedDiscountAmountDoc(Money value) {
        this.grantedDiscountAmountDoc = value;
    }

    /**
     * Gets the value of the billingAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBillingAccountId() {
        return billingAccountId;
    }

    /**
     * Sets the value of the billingAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBillingAccountId(Long value) {
        this.billingAccountId = value;
    }

    /**
     * Gets the value of the billingAccountIdPub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingAccountIdPub() {
        return billingAccountIdPub;
    }

    /**
     * Sets the value of the billingAccountIdPub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingAccountIdPub(String value) {
        this.billingAccountIdPub = value;
    }

    /**
     * Gets the value of the lineItems property.
     * 
     * @return
     *     possible object is
     *     {@link LineItemListResponse }
     *     
     */
    public LineItemListResponse getLineItems() {
        return lineItems;
    }

    /**
     * Sets the value of the lineItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineItemListResponse }
     *     
     */
    public void setLineItems(LineItemListResponse value) {
        this.lineItems = value;
    }

    /**
     * Gets the value of the taxItems property.
     * 
     * @return
     *     possible object is
     *     {@link CategoryTaxItemListResponse }
     *     
     */
    public CategoryTaxItemListResponse getTaxItems() {
        return taxItems;
    }

    /**
     * Sets the value of the taxItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryTaxItemListResponse }
     *     
     */
    public void setTaxItems(CategoryTaxItemListResponse value) {
        this.taxItems = value;
    }

}
