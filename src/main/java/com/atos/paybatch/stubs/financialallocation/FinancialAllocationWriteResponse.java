
package com.atos.paybatch.stubs.financialallocation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for financialAllocationWriteResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="financialAllocationWriteResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="financialAllocationWriteOutputDTO" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}financialAllocationWriteOutputDTO" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "financialAllocationWriteResponse", propOrder = {

})
public class FinancialAllocationWriteResponse {

    protected FinancialAllocationWriteOutputDTO financialAllocationWriteOutputDTO;

    /**
     * Gets the value of the financialAllocationWriteOutputDTO property.
     * 
     * @return
     *     possible object is
     *     {@link FinancialAllocationWriteOutputDTO }
     *     
     */
    public FinancialAllocationWriteOutputDTO getFinancialAllocationWriteOutputDTO() {
        return financialAllocationWriteOutputDTO;
    }

    /**
     * Sets the value of the financialAllocationWriteOutputDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialAllocationWriteOutputDTO }
     *     
     */
    public void setFinancialAllocationWriteOutputDTO(FinancialAllocationWriteOutputDTO value) {
        this.financialAllocationWriteOutputDTO = value;
    }

}
