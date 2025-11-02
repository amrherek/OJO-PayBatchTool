
package com.atos.paybatch.stubs.financialallocation;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 																							<p>Amount of the tax item</p>
 * 																						
 * 
 * <p>Java class for categoryTaxItemListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="categoryTaxItemListResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="taxItemDTO" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}taxItemDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "categoryTaxItemListResponse", propOrder = {
    "taxItemDTO"
})
public class CategoryTaxItemListResponse {

    protected List<TaxItemDTO> taxItemDTO;

    /**
     * Gets the value of the taxItemDTO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxItemDTO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxItemDTO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxItemDTO }
     * 
     * 
     */
    public List<TaxItemDTO> getTaxItemDTO() {
        if (taxItemDTO == null) {
            taxItemDTO = new ArrayList<TaxItemDTO>();
        }
        return this.taxItemDTO;
    }

}
