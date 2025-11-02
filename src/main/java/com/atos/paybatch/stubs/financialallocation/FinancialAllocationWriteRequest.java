
package com.atos.paybatch.stubs.financialallocation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for financialAllocationWriteRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="financialAllocationWriteRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="inputAttributes" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}inputAttributes" minOccurs="0"/&gt;
 *         &lt;element name="sessionChangeRequest" type="{http://ericsson.com/services/ws_CIL_7/sessionchange}sessionChangeRequest" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "financialAllocationWriteRequest", propOrder = {

})
public class FinancialAllocationWriteRequest {

    protected InputAttributes inputAttributes;
    protected SessionChangeRequest sessionChangeRequest;

    /**
     * Gets the value of the inputAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link InputAttributes }
     *     
     */
    public InputAttributes getInputAttributes() {
        return inputAttributes;
    }

    /**
     * Sets the value of the inputAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputAttributes }
     *     
     */
    public void setInputAttributes(InputAttributes value) {
        this.inputAttributes = value;
    }

    /**
     * Gets the value of the sessionChangeRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SessionChangeRequest }
     *     
     */
    public SessionChangeRequest getSessionChangeRequest() {
        return sessionChangeRequest;
    }

    /**
     * Sets the value of the sessionChangeRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SessionChangeRequest }
     *     
     */
    public void setSessionChangeRequest(SessionChangeRequest value) {
        this.sessionChangeRequest = value;
    }

}
