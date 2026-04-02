
package com.atos.paybatch.stubs.customerread;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for creditClassAssignmentsListpartResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="creditClassAssignmentsListpartResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="creditClassId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="creditClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="creditClassAssignmtSeqno" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="creditClassValidFrom" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="creditClassValidTo" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creditClassAssignmentsListpartResponse", propOrder = {

})
public class CreditClassAssignmentsListpartResponse {

    protected Long creditClassId;
    protected String creditClassName;
    protected Long creditClassAssignmtSeqno;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar creditClassValidFrom;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar creditClassValidTo;

    /**
     * Gets the value of the creditClassId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCreditClassId() {
        return creditClassId;
    }

    /**
     * Sets the value of the creditClassId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCreditClassId(Long value) {
        this.creditClassId = value;
    }

    /**
     * Gets the value of the creditClassName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditClassName() {
        return creditClassName;
    }

    /**
     * Sets the value of the creditClassName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditClassName(String value) {
        this.creditClassName = value;
    }

    /**
     * Gets the value of the creditClassAssignmtSeqno property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCreditClassAssignmtSeqno() {
        return creditClassAssignmtSeqno;
    }

    /**
     * Sets the value of the creditClassAssignmtSeqno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCreditClassAssignmtSeqno(Long value) {
        this.creditClassAssignmtSeqno = value;
    }

    /**
     * Gets the value of the creditClassValidFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreditClassValidFrom() {
        return creditClassValidFrom;
    }

    /**
     * Sets the value of the creditClassValidFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreditClassValidFrom(XMLGregorianCalendar value) {
        this.creditClassValidFrom = value;
    }

    /**
     * Gets the value of the creditClassValidTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreditClassValidTo() {
        return creditClassValidTo;
    }

    /**
     * Sets the value of the creditClassValidTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreditClassValidTo(XMLGregorianCalendar value) {
        this.creditClassValidTo = value;
    }

}
