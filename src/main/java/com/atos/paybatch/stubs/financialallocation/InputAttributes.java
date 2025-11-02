
package com.atos.paybatch.stubs.financialallocation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for inputAttributes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="inputAttributes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="financialAllocationWriteInputDTO" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}financialAllocationWriteInputDTO" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inputAttributes", propOrder = {

})
public class InputAttributes {

    protected FinancialAllocationWriteInputDTO financialAllocationWriteInputDTO;

    /**
     * Gets the value of the financialAllocationWriteInputDTO property.
     * 
     * @return
     *     possible object is
     *     {@link FinancialAllocationWriteInputDTO }
     *     
     */
    public FinancialAllocationWriteInputDTO getFinancialAllocationWriteInputDTO() {
        return financialAllocationWriteInputDTO;
    }

    /**
     * Sets the value of the financialAllocationWriteInputDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialAllocationWriteInputDTO }
     *     
     */
    public void setFinancialAllocationWriteInputDTO(FinancialAllocationWriteInputDTO value) {
        this.financialAllocationWriteInputDTO = value;
    }

}
