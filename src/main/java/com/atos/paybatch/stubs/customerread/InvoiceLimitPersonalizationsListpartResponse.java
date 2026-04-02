
package com.atos.paybatch.stubs.customerread;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for invoiceLimitPersonalizationsListpartResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="invoiceLimitPersonalizationsListpartResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="ovwInvMaxSeqno" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="ovwInvMaxLimit" type="{http://lhsgroup.com/lhsws/money}money" minOccurs="0"/&gt;
 *         &lt;element name="ovwInvMaxLimitValidFrom" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="ovwInvMaxLimitValidTo" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invoiceLimitPersonalizationsListpartResponse", propOrder = {

})
public class InvoiceLimitPersonalizationsListpartResponse {

    protected Long ovwInvMaxSeqno;
    protected Money ovwInvMaxLimit;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar ovwInvMaxLimitValidFrom;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar ovwInvMaxLimitValidTo;

    /**
     * Gets the value of the ovwInvMaxSeqno property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOvwInvMaxSeqno() {
        return ovwInvMaxSeqno;
    }

    /**
     * Sets the value of the ovwInvMaxSeqno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOvwInvMaxSeqno(Long value) {
        this.ovwInvMaxSeqno = value;
    }

    /**
     * Gets the value of the ovwInvMaxLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getOvwInvMaxLimit() {
        return ovwInvMaxLimit;
    }

    /**
     * Sets the value of the ovwInvMaxLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setOvwInvMaxLimit(Money value) {
        this.ovwInvMaxLimit = value;
    }

    /**
     * Gets the value of the ovwInvMaxLimitValidFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOvwInvMaxLimitValidFrom() {
        return ovwInvMaxLimitValidFrom;
    }

    /**
     * Sets the value of the ovwInvMaxLimitValidFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOvwInvMaxLimitValidFrom(XMLGregorianCalendar value) {
        this.ovwInvMaxLimitValidFrom = value;
    }

    /**
     * Gets the value of the ovwInvMaxLimitValidTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOvwInvMaxLimitValidTo() {
        return ovwInvMaxLimitValidTo;
    }

    /**
     * Sets the value of the ovwInvMaxLimitValidTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOvwInvMaxLimitValidTo(XMLGregorianCalendar value) {
        this.ovwInvMaxLimitValidTo = value;
    }

}
