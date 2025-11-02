
package com.atos.paybatch.stubs.financialallocation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								<p></p>
 * 							
 * 
 * <p>Java class for financialAllocationWriteOutputDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="financialAllocationWriteOutputDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="transactions" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}transactionListResponse" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "financialAllocationWriteOutputDTO", propOrder = {

})
public class FinancialAllocationWriteOutputDTO {

    protected TransactionListResponse transactions;

    /**
     * Gets the value of the transactions property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionListResponse }
     *     
     */
    public TransactionListResponse getTransactions() {
        return transactions;
    }

    /**
     * Sets the value of the transactions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionListResponse }
     *     
     */
    public void setTransactions(TransactionListResponse value) {
        this.transactions = value;
    }

}
