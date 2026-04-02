
package com.atos.paybatch.stubs.customerread;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for partyRoleAssignmentsListpartResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="partyRoleAssignmentsListpartResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="partyRoleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="partyRoleShname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="partyRoleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="partyRoleDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "partyRoleAssignmentsListpartResponse", propOrder = {

})
public class PartyRoleAssignmentsListpartResponse {

    protected Long partyRoleId;
    protected String partyRoleShname;
    protected String partyRoleName;
    protected String partyRoleDescription;

    /**
     * Gets the value of the partyRoleId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPartyRoleId() {
        return partyRoleId;
    }

    /**
     * Sets the value of the partyRoleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPartyRoleId(Long value) {
        this.partyRoleId = value;
    }

    /**
     * Gets the value of the partyRoleShname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartyRoleShname() {
        return partyRoleShname;
    }

    /**
     * Sets the value of the partyRoleShname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartyRoleShname(String value) {
        this.partyRoleShname = value;
    }

    /**
     * Gets the value of the partyRoleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartyRoleName() {
        return partyRoleName;
    }

    /**
     * Sets the value of the partyRoleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartyRoleName(String value) {
        this.partyRoleName = value;
    }

    /**
     * Gets the value of the partyRoleDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartyRoleDescription() {
        return partyRoleDescription;
    }

    /**
     * Sets the value of the partyRoleDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartyRoleDescription(String value) {
        this.partyRoleDescription = value;
    }

}
