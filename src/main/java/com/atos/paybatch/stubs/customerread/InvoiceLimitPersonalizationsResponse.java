
package com.atos.paybatch.stubs.customerread;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								<p>Invoice limit personalization history.</p>
 * 							
 * 
 * <p>Java class for invoiceLimitPersonalizationsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="invoiceLimitPersonalizationsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="item" type="{http://ericsson.com/services/ws_CIL_7/customerread}invoiceLimitPersonalizationsListpartResponse" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invoiceLimitPersonalizationsResponse", propOrder = {
    "item"
})
public class InvoiceLimitPersonalizationsResponse {

    protected List<InvoiceLimitPersonalizationsListpartResponse> item;

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvoiceLimitPersonalizationsListpartResponse }
     * 
     * 
     */
    public List<InvoiceLimitPersonalizationsListpartResponse> getItem() {
        if (item == null) {
            item = new ArrayList<InvoiceLimitPersonalizationsListpartResponse>();
        }
        return this.item;
    }

}
