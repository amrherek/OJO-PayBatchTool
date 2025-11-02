
package com.atos.paybatch.stubs.customersearch;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 					<p>customer specific attributes</p>
 * 				
 * 
 * <p>Java class for inputAttributes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="inputAttributes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="ignoreBuInd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ignoreDealerInd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="searcher" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csIdHigh" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="csIdHighPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="countryId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="countryIdPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="externalCustomerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="externalCustomerSetId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csIdPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csDealerid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="csDealeridPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="states" type="{http://ericsson.com/services/ws_CIL_7/customerssearch}statesRequest" minOccurs="0"/&gt;
 *         &lt;element name="csLevelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrSocialseno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrDrivelicence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrIdno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrCompno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrTaxno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="prgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rpcode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="rpcodePub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="costId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="costCodePub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrRoles" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrLname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrFname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrStreetno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrBirthdt" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="srchCount" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="startIndex" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="flagCase" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="flagMatchcode" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="paymentResp" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="csContrResp" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="laMember" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="partyRoleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="partyRoleShname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="partyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="useCsrRoles" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="documentIdPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="documentId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="documentRefDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="transactionIdPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="transactionRefDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="transactionDocNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="anonymous" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="markedForRerating" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="bscsContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="rootCsId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="rootCsIdPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billingAccountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="billingAccountCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billingAccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cspAccno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="iban" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="collectionInd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasOpenCreditDoc" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hasOpenDebtDoc" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="billcycle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="extLcStatuses" type="{http://ericsson.com/services/ws_CIL_7/customerssearch}extLcStatusesRequest" minOccurs="0"/&gt;
 *         &lt;element name="csAliasName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isDummyPreactivated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
@XmlType(name = "inputAttributes", propOrder = {

})
public class InputAttributes {

    protected Boolean ignoreBuInd;
    protected Boolean ignoreDealerInd;
    protected String searcher;
    protected Long csIdHigh;
    protected String csIdHighPub;
    protected String adrState;
    protected Long countryId;
    protected String countryIdPub;
    protected String externalCustomerId;
    protected String externalCustomerSetId;
    protected String csCode;
    protected String csIdPub;
    protected Long csDealerid;
    protected String csDealeridPub;
    protected String csStatus;
    protected StatesRequest states;
    protected String csLevelCode;
    protected String adrSocialseno;
    protected String adrDrivelicence;
    protected String adrIdno;
    protected String adrCompno;
    protected String adrTaxno;
    protected String prgCode;
    protected Long rpcode;
    protected String rpcodePub;
    protected Long costId;
    protected String costCodePub;
    protected String adrRoles;
    protected String adrLname;
    protected String adrFname;
    protected String adrName;
    protected String adrZip;
    protected String adrCity;
    protected String adrStreet;
    protected String adrStreetno;
    protected String adrEmail;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar adrBirthdt;
    protected BigInteger srchCount;
    protected Long startIndex;
    protected Boolean flagCase;
    protected Boolean flagMatchcode;
    protected Boolean paymentResp;
    protected Boolean csContrResp;
    protected Boolean laMember;
    protected Long partyRoleId;
    protected String partyRoleShname;
    protected String partyType;
    protected Boolean useCsrRoles;
    protected String documentIdPub;
    protected Long documentId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar documentRefDate;
    protected String transactionIdPub;
    protected Long transactionId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transactionRefDate;
    protected String transactionDocNo;
    protected Boolean anonymous;
    protected Boolean markedForRerating;
    protected Boolean bscsContract;
    protected Long rootCsId;
    protected String rootCsIdPub;
    protected Long billingAccountId;
    protected String billingAccountCode;
    protected String billingAccountName;
    protected String cspAccno;
    protected String iban;
    protected Boolean collectionInd;
    protected Boolean hasOpenCreditDoc;
    protected Boolean hasOpenDebtDoc;
    protected String billcycle;
    protected ExtLcStatusesRequest extLcStatuses;
    protected String csAliasName;
    protected Boolean isDummyPreactivated;
    protected String fwdChargePrivacyInd;

    /**
     * Gets the value of the ignoreBuInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIgnoreBuInd() {
        return ignoreBuInd;
    }

    /**
     * Sets the value of the ignoreBuInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIgnoreBuInd(Boolean value) {
        this.ignoreBuInd = value;
    }

    /**
     * Gets the value of the ignoreDealerInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIgnoreDealerInd() {
        return ignoreDealerInd;
    }

    /**
     * Sets the value of the ignoreDealerInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIgnoreDealerInd(Boolean value) {
        this.ignoreDealerInd = value;
    }

    /**
     * Gets the value of the searcher property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearcher() {
        return searcher;
    }

    /**
     * Sets the value of the searcher property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearcher(String value) {
        this.searcher = value;
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
     * Gets the value of the adrState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrState() {
        return adrState;
    }

    /**
     * Sets the value of the adrState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrState(String value) {
        this.adrState = value;
    }

    /**
     * Gets the value of the countryId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCountryId() {
        return countryId;
    }

    /**
     * Sets the value of the countryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCountryId(Long value) {
        this.countryId = value;
    }

    /**
     * Gets the value of the countryIdPub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryIdPub() {
        return countryIdPub;
    }

    /**
     * Sets the value of the countryIdPub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryIdPub(String value) {
        this.countryIdPub = value;
    }

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
     * Gets the value of the csDealeridPub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsDealeridPub() {
        return csDealeridPub;
    }

    /**
     * Sets the value of the csDealeridPub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsDealeridPub(String value) {
        this.csDealeridPub = value;
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
     * Gets the value of the states property.
     * 
     * @return
     *     possible object is
     *     {@link StatesRequest }
     *     
     */
    public StatesRequest getStates() {
        return states;
    }

    /**
     * Sets the value of the states property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatesRequest }
     *     
     */
    public void setStates(StatesRequest value) {
        this.states = value;
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
     * Gets the value of the adrSocialseno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrSocialseno() {
        return adrSocialseno;
    }

    /**
     * Sets the value of the adrSocialseno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrSocialseno(String value) {
        this.adrSocialseno = value;
    }

    /**
     * Gets the value of the adrDrivelicence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrDrivelicence() {
        return adrDrivelicence;
    }

    /**
     * Sets the value of the adrDrivelicence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrDrivelicence(String value) {
        this.adrDrivelicence = value;
    }

    /**
     * Gets the value of the adrIdno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrIdno() {
        return adrIdno;
    }

    /**
     * Sets the value of the adrIdno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrIdno(String value) {
        this.adrIdno = value;
    }

    /**
     * Gets the value of the adrCompno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrCompno() {
        return adrCompno;
    }

    /**
     * Sets the value of the adrCompno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrCompno(String value) {
        this.adrCompno = value;
    }

    /**
     * Gets the value of the adrTaxno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrTaxno() {
        return adrTaxno;
    }

    /**
     * Sets the value of the adrTaxno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrTaxno(String value) {
        this.adrTaxno = value;
    }

    /**
     * Gets the value of the prgCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrgCode() {
        return prgCode;
    }

    /**
     * Sets the value of the prgCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrgCode(String value) {
        this.prgCode = value;
    }

    /**
     * Gets the value of the rpcode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRpcode() {
        return rpcode;
    }

    /**
     * Sets the value of the rpcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRpcode(Long value) {
        this.rpcode = value;
    }

    /**
     * Gets the value of the rpcodePub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRpcodePub() {
        return rpcodePub;
    }

    /**
     * Sets the value of the rpcodePub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRpcodePub(String value) {
        this.rpcodePub = value;
    }

    /**
     * Gets the value of the costId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCostId() {
        return costId;
    }

    /**
     * Sets the value of the costId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCostId(Long value) {
        this.costId = value;
    }

    /**
     * Gets the value of the costCodePub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCostCodePub() {
        return costCodePub;
    }

    /**
     * Sets the value of the costCodePub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCostCodePub(String value) {
        this.costCodePub = value;
    }

    /**
     * Gets the value of the adrRoles property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrRoles() {
        return adrRoles;
    }

    /**
     * Sets the value of the adrRoles property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrRoles(String value) {
        this.adrRoles = value;
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
     * Gets the value of the adrEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrEmail() {
        return adrEmail;
    }

    /**
     * Sets the value of the adrEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrEmail(String value) {
        this.adrEmail = value;
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
     * Gets the value of the srchCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSrchCount() {
        return srchCount;
    }

    /**
     * Sets the value of the srchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSrchCount(BigInteger value) {
        this.srchCount = value;
    }

    /**
     * Gets the value of the startIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStartIndex() {
        return startIndex;
    }

    /**
     * Sets the value of the startIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStartIndex(Long value) {
        this.startIndex = value;
    }

    /**
     * Gets the value of the flagCase property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFlagCase() {
        return flagCase;
    }

    /**
     * Sets the value of the flagCase property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFlagCase(Boolean value) {
        this.flagCase = value;
    }

    /**
     * Gets the value of the flagMatchcode property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFlagMatchcode() {
        return flagMatchcode;
    }

    /**
     * Sets the value of the flagMatchcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFlagMatchcode(Boolean value) {
        this.flagMatchcode = value;
    }

    /**
     * Gets the value of the paymentResp property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPaymentResp() {
        return paymentResp;
    }

    /**
     * Sets the value of the paymentResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPaymentResp(Boolean value) {
        this.paymentResp = value;
    }

    /**
     * Gets the value of the csContrResp property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCsContrResp() {
        return csContrResp;
    }

    /**
     * Sets the value of the csContrResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCsContrResp(Boolean value) {
        this.csContrResp = value;
    }

    /**
     * Gets the value of the laMember property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLaMember() {
        return laMember;
    }

    /**
     * Sets the value of the laMember property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLaMember(Boolean value) {
        this.laMember = value;
    }

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
     * Gets the value of the useCsrRoles property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseCsrRoles() {
        return useCsrRoles;
    }

    /**
     * Sets the value of the useCsrRoles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseCsrRoles(Boolean value) {
        this.useCsrRoles = value;
    }

    /**
     * Gets the value of the documentIdPub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentIdPub() {
        return documentIdPub;
    }

    /**
     * Sets the value of the documentIdPub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentIdPub(String value) {
        this.documentIdPub = value;
    }

    /**
     * Gets the value of the documentId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDocumentId() {
        return documentId;
    }

    /**
     * Sets the value of the documentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDocumentId(Long value) {
        this.documentId = value;
    }

    /**
     * Gets the value of the documentRefDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDocumentRefDate() {
        return documentRefDate;
    }

    /**
     * Sets the value of the documentRefDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDocumentRefDate(XMLGregorianCalendar value) {
        this.documentRefDate = value;
    }

    /**
     * Gets the value of the transactionIdPub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionIdPub() {
        return transactionIdPub;
    }

    /**
     * Sets the value of the transactionIdPub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionIdPub(String value) {
        this.transactionIdPub = value;
    }

    /**
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTransactionId(Long value) {
        this.transactionId = value;
    }

    /**
     * Gets the value of the transactionRefDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransactionRefDate() {
        return transactionRefDate;
    }

    /**
     * Sets the value of the transactionRefDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransactionRefDate(XMLGregorianCalendar value) {
        this.transactionRefDate = value;
    }

    /**
     * Gets the value of the transactionDocNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionDocNo() {
        return transactionDocNo;
    }

    /**
     * Sets the value of the transactionDocNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionDocNo(String value) {
        this.transactionDocNo = value;
    }

    /**
     * Gets the value of the anonymous property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAnonymous() {
        return anonymous;
    }

    /**
     * Sets the value of the anonymous property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAnonymous(Boolean value) {
        this.anonymous = value;
    }

    /**
     * Gets the value of the markedForRerating property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMarkedForRerating() {
        return markedForRerating;
    }

    /**
     * Sets the value of the markedForRerating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMarkedForRerating(Boolean value) {
        this.markedForRerating = value;
    }

    /**
     * Gets the value of the bscsContract property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBscsContract() {
        return bscsContract;
    }

    /**
     * Sets the value of the bscsContract property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBscsContract(Boolean value) {
        this.bscsContract = value;
    }

    /**
     * Gets the value of the rootCsId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRootCsId() {
        return rootCsId;
    }

    /**
     * Sets the value of the rootCsId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRootCsId(Long value) {
        this.rootCsId = value;
    }

    /**
     * Gets the value of the rootCsIdPub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRootCsIdPub() {
        return rootCsIdPub;
    }

    /**
     * Sets the value of the rootCsIdPub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRootCsIdPub(String value) {
        this.rootCsIdPub = value;
    }

    /**
     * Gets the value of the billingAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBillingAccountId() {
        return billingAccountId;
    }

    /**
     * Sets the value of the billingAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBillingAccountId(Long value) {
        this.billingAccountId = value;
    }

    /**
     * Gets the value of the billingAccountCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingAccountCode() {
        return billingAccountCode;
    }

    /**
     * Sets the value of the billingAccountCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingAccountCode(String value) {
        this.billingAccountCode = value;
    }

    /**
     * Gets the value of the billingAccountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingAccountName() {
        return billingAccountName;
    }

    /**
     * Sets the value of the billingAccountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingAccountName(String value) {
        this.billingAccountName = value;
    }

    /**
     * Gets the value of the cspAccno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCspAccno() {
        return cspAccno;
    }

    /**
     * Sets the value of the cspAccno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCspAccno(String value) {
        this.cspAccno = value;
    }

    /**
     * Gets the value of the iban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIban() {
        return iban;
    }

    /**
     * Sets the value of the iban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIban(String value) {
        this.iban = value;
    }

    /**
     * Gets the value of the collectionInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCollectionInd() {
        return collectionInd;
    }

    /**
     * Sets the value of the collectionInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCollectionInd(Boolean value) {
        this.collectionInd = value;
    }

    /**
     * Gets the value of the hasOpenCreditDoc property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasOpenCreditDoc() {
        return hasOpenCreditDoc;
    }

    /**
     * Sets the value of the hasOpenCreditDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasOpenCreditDoc(Boolean value) {
        this.hasOpenCreditDoc = value;
    }

    /**
     * Gets the value of the hasOpenDebtDoc property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasOpenDebtDoc() {
        return hasOpenDebtDoc;
    }

    /**
     * Sets the value of the hasOpenDebtDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasOpenDebtDoc(Boolean value) {
        this.hasOpenDebtDoc = value;
    }

    /**
     * Gets the value of the billcycle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillcycle() {
        return billcycle;
    }

    /**
     * Sets the value of the billcycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillcycle(String value) {
        this.billcycle = value;
    }

    /**
     * Gets the value of the extLcStatuses property.
     * 
     * @return
     *     possible object is
     *     {@link ExtLcStatusesRequest }
     *     
     */
    public ExtLcStatusesRequest getExtLcStatuses() {
        return extLcStatuses;
    }

    /**
     * Sets the value of the extLcStatuses property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtLcStatusesRequest }
     *     
     */
    public void setExtLcStatuses(ExtLcStatusesRequest value) {
        this.extLcStatuses = value;
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
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDummyPreactivated() {
        return isDummyPreactivated;
    }

    /**
     * Sets the value of the isDummyPreactivated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDummyPreactivated(Boolean value) {
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
