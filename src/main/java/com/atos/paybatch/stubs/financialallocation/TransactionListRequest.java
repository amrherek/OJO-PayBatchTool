
package com.atos.paybatch.stubs.financialallocation;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 											<p>Transaction list</p><p>Transactions list is processed based on the transactions configured for the given use case in the database.</p>
 * 										
 * 
 * <p>Java class for transactionListRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transactionListRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="transactionWriteInDTO" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}transactionWriteInDTO" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transactionListRequest", propOrder = {
    "transactionWriteInDTO"
})
public class TransactionListRequest {

    @XmlElement(required = true)
    protected List<TransactionWriteInDTO> transactionWriteInDTO;

    /**
     * Gets the value of the transactionWriteInDTO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transactionWriteInDTO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransactionWriteInDTO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransactionWriteInDTO }
     * 
     * 
     */
    public List<TransactionWriteInDTO> getTransactionWriteInDTO() {
        if (transactionWriteInDTO == null) {
            transactionWriteInDTO = new ArrayList<TransactionWriteInDTO>();
        }
        return this.transactionWriteInDTO;
    }

}
