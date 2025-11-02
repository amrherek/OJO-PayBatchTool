
package com.atos.paybatch.stubs.financialallocation;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 																							<p>Net amount allocated to the line item.</p>
 * 																							<p>Merged DTO element: this element might be invalid for SOI command FINANCIAL_ALLOCATION.WRITE depending on which area it is set. Please verify CDF for that command.</p>
 * 																						
 * 
 * <p>Java class for lineItemListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lineItemListResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lineItemDTO" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}lineItemDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lineItemListResponse", propOrder = {
    "lineItemDTO"
})
public class LineItemListResponse {

    protected List<LineItemDTO> lineItemDTO;

    /**
     * Gets the value of the lineItemDTO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineItemDTO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineItemDTO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineItemDTO }
     * 
     * 
     */
    public List<LineItemDTO> getLineItemDTO() {
        if (lineItemDTO == null) {
            lineItemDTO = new ArrayList<LineItemDTO>();
        }
        return this.lineItemDTO;
    }

}
