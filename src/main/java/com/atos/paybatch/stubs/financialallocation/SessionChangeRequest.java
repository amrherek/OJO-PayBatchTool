
package com.atos.paybatch.stubs.financialallocation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 					<p>
 * 					
 * 					</p>
 * 				
 * 
 * <p>Java class for sessionChangeRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sessionChangeRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="values" type="{http://ericsson.com/services/ws_CIL_7/sessionchange}valuesRequest" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sessionChangeRequest", namespace = "http://ericsson.com/services/ws_CIL_7/sessionchange", propOrder = {

})
public class SessionChangeRequest {

    protected ValuesRequest values;

    /**
     * Gets the value of the values property.
     * 
     * @return
     *     possible object is
     *     {@link ValuesRequest }
     *     
     */
    public ValuesRequest getValues() {
        return values;
    }

    /**
     * Sets the value of the values property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValuesRequest }
     *     
     */
    public void setValues(ValuesRequest value) {
        this.values = value;
    }

}
