
package com.atos.paybatch.stubs.financialallocation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for aggregationCriteriaDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="aggregationCriteriaDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="UDSMember" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}finUDSMemberReferenceDTO" minOccurs="0"/&gt;
 *         &lt;element name="UDSElement" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}finUDSElementReferenceDTO" minOccurs="0"/&gt;
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aggregationCriteriaDTO", propOrder = {

})
public class AggregationCriteriaDTO {

    @XmlElement(name = "UDSMember")
    protected FinUDSMemberReferenceDTO udsMember;
    @XmlElement(name = "UDSElement")
    protected FinUDSElementReferenceDTO udsElement;
    protected String value;

    /**
     * Gets the value of the udsMember property.
     * 
     * @return
     *     possible object is
     *     {@link FinUDSMemberReferenceDTO }
     *     
     */
    public FinUDSMemberReferenceDTO getUDSMember() {
        return udsMember;
    }

    /**
     * Sets the value of the udsMember property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinUDSMemberReferenceDTO }
     *     
     */
    public void setUDSMember(FinUDSMemberReferenceDTO value) {
        this.udsMember = value;
    }

    /**
     * Gets the value of the udsElement property.
     * 
     * @return
     *     possible object is
     *     {@link FinUDSElementReferenceDTO }
     *     
     */
    public FinUDSElementReferenceDTO getUDSElement() {
        return udsElement;
    }

    /**
     * Sets the value of the udsElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinUDSElementReferenceDTO }
     *     
     */
    public void setUDSElement(FinUDSElementReferenceDTO value) {
        this.udsElement = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

}
