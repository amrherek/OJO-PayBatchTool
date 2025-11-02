
package com.atos.paybatch.stubs.financialallocation;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 											<p>Transaction list</p>
 * 										
 * 
 * <p>Java class for transactionListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transactionListResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="transactionWriteOutDTO" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}transactionWriteOutDTO" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transactionListResponse", propOrder = {
    "transactionWriteOutDTO"
})
public class TransactionListResponse {

    @XmlElement(required = true)
    protected List<TransactionWriteOutDTO> transactionWriteOutDTO;

    /**
     * Gets the value of the transactionWriteOutDTO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transactionWriteOutDTO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransactionWriteOutDTO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransactionWriteOutDTO }
     * 
     * 
     */
    public List<TransactionWriteOutDTO> getTransactionWriteOutDTO() {
        if (transactionWriteOutDTO == null) {
            transactionWriteOutDTO = new ArrayList<TransactionWriteOutDTO>();
        }
        return this.transactionWriteOutDTO;
    }

}
