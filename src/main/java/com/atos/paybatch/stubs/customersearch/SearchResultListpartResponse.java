
package com.atos.paybatch.stubs.customersearch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for searchResultListpartResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchResultListpartResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="externalCustomerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="externalCustomerSetId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="buId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="partyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csDealerid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="adrLname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrFname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrStreetno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrBirthdt" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="csStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csLevelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentResp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csIdHigh" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="csIdHighPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csContrResp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="csIdPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="markedForRerating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="extLcStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csAliasName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isDummyPreactivated" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fwdChargePrivacyInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchResultListpartResponse", propOrder = {

})
public class SearchResultListpartResponse {

    protected String externalCustomerId;
    protected String externalCustomerSetId;
    protected String csCode;
    protected Long buId;
    protected String partyType;
    protected Long csDealerid;
    protected String adrLname;
    protected String adrFname;
    protected String adrName;
    protected String adrStreet;
    protected String adrStreetno;
    protected String adrZip;
    protected String adrCity;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar adrBirthdt;
    protected String csStatus;
    protected String csLevelCode;
    protected String paymentResp;
    protected Long csIdHigh;
    protected String csIdHighPub;
    protected String csContrResp;
    protected Long csId;
    protected String csIdPub;
    protected String markedForRerating;
    protected String extLcStatus;
    protected String csAliasName;
    protected String isDummyPreactivated;
    protected String fwdChargePrivacyInd;

    /**
     * Gets the value of the externalCustomerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalCustomerId() {
        return externalCustomerId;
    }

    /**
     * Sets the value of the externalCustomerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalCustomerId(String value) {
        this.externalCustomerId = value;
    }

    /**
     * Gets the value of the externalCustomerSetId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalCustomerSetId() {
        return externalCustomerSetId;
    }

    /**
     * Sets the value of the externalCustomerSetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalCustomerSetId(String value) {
        this.externalCustomerSetId = value;
    }

    /**
     * Gets the value of the csCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCode() {
        return csCode;
    }

    /**
     * Sets the value of the csCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCode(String value) {
        this.csCode = value;
    }

    /**
     * Gets the value of the buId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBuId() {
        return buId;
    }

    /**
     * Sets the value of the buId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBuId(Long value) {
        this.buId = value;
    }

    /**
     * Gets the value of the partyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartyType() {
        return partyType;
    }

    /**
     * Sets the value of the partyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartyType(String value) {
        this.partyType = value;
    }

    /**
     * Gets the value of the csDealerid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCsDealerid() {
        return csDealerid;
    }

    /**
     * Sets the value of the csDealerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCsDealerid(Long value) {
        this.csDealerid = value;
    }

    /**
     * Gets the value of the adrLname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrLname() {
        return adrLname;
    }

    /**
     * Sets the value of the adrLname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrLname(String value) {
        this.adrLname = value;
    }

    /**
     * Gets the value of the adrFname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrFname() {
        return adrFname;
    }

    /**
     * Sets the value of the adrFname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrFname(String value) {
        this.adrFname = value;
    }

    /**
     * Gets the value of the adrName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrName() {
        return adrName;
    }

    /**
     * Sets the value of the adrName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrName(String value) {
        this.adrName = value;
    }

    /**
     * Gets the value of the adrStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrStreet() {
        return adrStreet;
    }

    /**
     * Sets the value of the adrStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrStreet(String value) {
        this.adrStreet = value;
    }

    /**
     * Gets the value of the adrStreetno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrStreetno() {
        return adrStreetno;
    }

    /**
     * Sets the value of the adrStreetno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrStreetno(String value) {
        this.adrStreetno = value;
    }

    /**
     * Gets the value of the adrZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrZip() {
        return adrZip;
    }

    /**
     * Sets the value of the adrZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrZip(String value) {
        this.adrZip = value;
    }

    /**
     * Gets the value of the adrCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrCity() {
        return adrCity;
    }

    /**
     * Sets the value of the adrCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrCity(String value) {
        this.adrCity = value;
    }

    /**
     * Gets the value of the adrBirthdt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAdrBirthdt() {
        return adrBirthdt;
    }

    /**
     * Sets the value of the adrBirthdt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAdrBirthdt(XMLGregorianCalendar value) {
        this.adrBirthdt = value;
    }

    /**
     * Gets the value of the csStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsStatus() {
        return csStatus;
    }

    /**
     * Sets the value of the csStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsStatus(String value) {
        this.csStatus = value;
    }

    /**
     * Gets the value of the csLevelCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsLevelCode() {
        return csLevelCode;
    }

    /**
     * Sets the value of the csLevelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsLevelCode(String value) {
        this.csLevelCode = value;
    }

    /**
     * Gets the value of the paymentResp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentResp() {
        return paymentResp;
    }

    /**
     * Sets the value of the paymentResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentResp(String value) {
        this.paymentResp = value;
    }

    /**
     * Gets the value of the csIdHigh property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCsIdHigh() {
        return csIdHigh;
    }

    /**
     * Sets the value of the csIdHigh property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCsIdHigh(Long value) {
        this.csIdHigh = value;
    }

    /**
     * Gets the value of the csIdHighPub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsIdHighPub() {
        return csIdHighPub;
    }

    /**
     * Sets the value of the csIdHighPub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsIdHighPub(String value) {
        this.csIdHighPub = value;
    }

    /**
     * Gets the value of the csContrResp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsContrResp() {
        return csContrResp;
    }

    /**
     * Sets the value of the csContrResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsContrResp(String value) {
        this.csContrResp = value;
    }

    /**
     * Gets the value of the csId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCsId() {
        return csId;
    }

    /**
     * Sets the value of the csId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCsId(Long value) {
        this.csId = value;
    }

    /**
     * Gets the value of the csIdPub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsIdPub() {
        return csIdPub;
    }

    /**
     * Sets the value of the csIdPub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsIdPub(String value) {
        this.csIdPub = value;
    }

    /**
     * Gets the value of the markedForRerating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarkedForRerating() {
        return markedForRerating;
    }

    /**
     * Sets the value of the markedForRerating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarkedForRerating(String value) {
        this.markedForRerating = value;
    }

    /**
     * Gets the value of the extLcStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtLcStatus() {
        return extLcStatus;
    }

    /**
     * Sets the value of the extLcStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtLcStatus(String value) {
        this.extLcStatus = value;
    }

    /**
     * Gets the value of the csAliasName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsAliasName() {
        return csAliasName;
    }

    /**
     * Sets the value of the csAliasName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsAliasName(String value) {
        this.csAliasName = value;
    }

    /**
     * Gets the value of the isDummyPreactivated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsDummyPreactivated() {
        return isDummyPreactivated;
    }

    /**
     * Sets the value of the isDummyPreactivated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsDummyPreactivated(String value) {
        this.isDummyPreactivated = value;
    }

    /**
     * Gets the value of the fwdChargePrivacyInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFwdChargePrivacyInd() {
        return fwdChargePrivacyInd;
    }

    /**
     * Sets the value of the fwdChargePrivacyInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFwdChargePrivacyInd(String value) {
        this.fwdChargePrivacyInd = value;
    }

}
