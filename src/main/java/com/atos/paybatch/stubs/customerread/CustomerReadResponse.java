
package com.atos.paybatch.stubs.customerread;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 					<p></p>
 * 				
 * 
 * <p>Java class for customerReadResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerReadResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="tbAmount" type="{http://lhsgroup.com/lhsws/money}money" minOccurs="0"/&gt;
 *         &lt;element name="createdByUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tbMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tbPurpose" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sioActionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sioThresholdAmt" type="{http://lhsgroup.com/lhsws/money}money" minOccurs="0"/&gt;
 *         &lt;element name="maxCarryOverLenght" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="maxCarryOverPeriodType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isIndividualOverdiscDisabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="familyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="listOfAssignments" type="{http://ericsson.com/services/ws_CIL_7/customerread}listOfAssignmentsResponse" minOccurs="0"/&gt;
 *         &lt;element name="csId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="csIdPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csStatusDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="csActivationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="csIdHigh" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="csIdHighPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csLevelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentResp" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="prgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rpcode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="rpcodePub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tradeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="areaCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="costId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="costCodePub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rsCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="rsShdes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="wpCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="srCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="csRemark1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csRemark2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csBillInformation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="callSelectMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="expectPayCurrencyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="expectPayCurrencyIdPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csConvratetypePayment" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="csConvratetypePaymentPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="refundCurrencyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="refundCurrencyIdPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csConvratetypeRefund" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="csConvratetypeRefundPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csCrcheckAgreed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="custcatCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="custcatCodePub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csJurisdictionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="csJurisdictionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csIncorporatedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="csBillcycle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csBillcycleDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csLimitTr1" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="csLimitTr1Pub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csLimitTr2" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="csLimitTr2Pub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csLimitTr3" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="csLimitTr3Pub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csClimit" type="{http://lhsgroup.com/lhsws/money}money" minOccurs="0"/&gt;
 *         &lt;element name="csContresp" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="csLastBcDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="csDeposit" type="{http://lhsgroup.com/lhsws/money}money" minOccurs="0"/&gt;
 *         &lt;element name="csCreditscore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csCscreditStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csCscreditRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csCscreditDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="csDunning" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="csDunningMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csPrepayment" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="csCollector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csFcId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="csFcIdPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csCscurbalance" type="{http://lhsgroup.com/lhsws/money}money" minOccurs="0"/&gt;
 *         &lt;element name="csPrevbalance" type="{http://lhsgroup.com/lhsws/money}money" minOccurs="0"/&gt;
 *         &lt;element name="csUnbilledAmount" type="{http://lhsgroup.com/lhsws/money}money" minOccurs="0"/&gt;
 *         &lt;element name="csPaybehaviour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csNoBouncePay" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="csDealerid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="csDealeridPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csInitPrepaidContrOwner" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="csCreationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="csDeactivationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="csSuspensionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="csReactivationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="lastModificationUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentRespId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="csPaymntRespCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="partyRoleAssignments" type="{http://ericsson.com/services/ws_CIL_7/customerread}partyRoleAssignmentsResponse" minOccurs="0"/&gt;
 *         &lt;element name="partyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="collInd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="markedForRerating" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="externalCustomerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="externalCustomerSetId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="maxCsLevel" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="creditScore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="creditScoreProvider" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csCscreditUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="performCreditScoring" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="cslvlname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrNationality" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="adrNationalityPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adrEmployee" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="csTestbillrun" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="roundingCarryLeftOver" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="allowIndividualBillcycleInd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="billAgreementId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="extLcStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="csAliasName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="creditClassAssignments" type="{http://ericsson.com/services/ws_CIL_7/customerread}creditClassAssignmentsResponse" minOccurs="0"/&gt;
 *         &lt;element name="invoiceLimitPersonalizations" type="{http://ericsson.com/services/ws_CIL_7/customerread}invoiceLimitPersonalizationsResponse" minOccurs="0"/&gt;
 *         &lt;element name="isDummyPreactivated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="fwdChargePrivacyInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="allowRentalFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="rentalThresholdFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="csProtectionMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerReadResponse", propOrder = {

})
public class CustomerReadResponse {

    protected Money tbAmount;
    protected String createdByUser;
    protected String tbMode;
    protected String tbPurpose;
    protected String sioActionType;
    protected Money sioThresholdAmt;
    protected Long maxCarryOverLenght;
    protected String maxCarryOverPeriodType;
    protected Boolean isIndividualOverdiscDisabled;
    protected Long familyId;
    protected ListOfAssignmentsResponse listOfAssignments;
    protected Long csId;
    protected String csIdPub;
    protected String csCode;
    protected String csStatus;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar csStatusDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar csActivationDate;
    protected Long csIdHigh;
    protected String csIdHighPub;
    protected String csLevelCode;
    protected Boolean paymentResp;
    protected String prgCode;
    protected Long rpcode;
    protected String rpcodePub;
    protected String tradeCode;
    protected Long areaCode;
    protected Long costId;
    protected String costCodePub;
    protected String csPassword;
    protected Long rsCode;
    protected String rsShdes;
    protected Long wpCode;
    protected Long srCode;
    protected String csRemark1;
    protected String csRemark2;
    protected Boolean csBillInformation;
    protected String callSelectMode;
    protected Long expectPayCurrencyId;
    protected String expectPayCurrencyIdPub;
    protected Long csConvratetypePayment;
    protected String csConvratetypePaymentPub;
    protected Long refundCurrencyId;
    protected String refundCurrencyIdPub;
    protected Long csConvratetypeRefund;
    protected String csConvratetypeRefundPub;
    protected Boolean csCrcheckAgreed;
    protected Long custcatCode;
    protected String custcatCodePub;
    protected Long csJurisdictionId;
    protected String csJurisdictionCode;
    protected Boolean csIncorporatedInd;
    protected String csBillcycle;
    protected String csBillcycleDesc;
    protected Long csLimitTr1;
    protected String csLimitTr1Pub;
    protected Long csLimitTr2;
    protected String csLimitTr2Pub;
    protected Long csLimitTr3;
    protected String csLimitTr3Pub;
    protected Money csClimit;
    protected Boolean csContresp;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar csLastBcDate;
    protected Money csDeposit;
    protected String csCreditscore;
    protected String csCscreditStatus;
    protected String csCscreditRemark;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar csCscreditDate;
    protected Boolean csDunning;
    protected String csDunningMode;
    protected Boolean csPrepayment;
    protected String csCollector;
    protected Long csFcId;
    protected String csFcIdPub;
    protected Money csCscurbalance;
    protected Money csPrevbalance;
    protected Money csUnbilledAmount;
    protected String csPaybehaviour;
    protected BigInteger csNoBouncePay;
    protected Long csDealerid;
    protected String csDealeridPub;
    protected Boolean csInitPrepaidContrOwner;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar csCreationDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar csDeactivationDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar csSuspensionDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar csReactivationDate;
    protected String lastModificationUser;
    protected Long paymentRespId;
    protected String csPaymntRespCode;
    protected PartyRoleAssignmentsResponse partyRoleAssignments;
    protected String partyType;
    protected Boolean collInd;
    protected Boolean markedForRerating;
    protected String externalCustomerId;
    protected String externalCustomerSetId;
    protected Long maxCsLevel;
    protected String creditScore;
    protected String creditScoreProvider;
    protected String csCscreditUser;
    protected Boolean performCreditScoring;
    protected String cslvlname;
    protected Long adrNationality;
    protected String adrNationalityPub;
    protected Boolean adrEmployee;
    protected String csTestbillrun;
    protected String roundingCarryLeftOver;
    protected Boolean allowIndividualBillcycleInd;
    protected Long billAgreementId;
    protected String extLcStatus;
    protected String csAliasName;
    protected CreditClassAssignmentsResponse creditClassAssignments;
    protected InvoiceLimitPersonalizationsResponse invoiceLimitPersonalizations;
    protected Boolean isDummyPreactivated;
    protected String fwdChargePrivacyInd;
    protected Boolean allowRentalFlag;
    protected Boolean rentalThresholdFlag;
    protected String csProtectionMode;

    /**
     * Gets the value of the tbAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getTbAmount() {
        return tbAmount;
    }

    /**
     * Sets the value of the tbAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setTbAmount(Money value) {
        this.tbAmount = value;
    }

    /**
     * Gets the value of the createdByUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedByUser() {
        return createdByUser;
    }

    /**
     * Sets the value of the createdByUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedByUser(String value) {
        this.createdByUser = value;
    }

    /**
     * Gets the value of the tbMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTbMode() {
        return tbMode;
    }

    /**
     * Sets the value of the tbMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTbMode(String value) {
        this.tbMode = value;
    }

    /**
     * Gets the value of the tbPurpose property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTbPurpose() {
        return tbPurpose;
    }

    /**
     * Sets the value of the tbPurpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTbPurpose(String value) {
        this.tbPurpose = value;
    }

    /**
     * Gets the value of the sioActionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSioActionType() {
        return sioActionType;
    }

    /**
     * Sets the value of the sioActionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSioActionType(String value) {
        this.sioActionType = value;
    }

    /**
     * Gets the value of the sioThresholdAmt property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getSioThresholdAmt() {
        return sioThresholdAmt;
    }

    /**
     * Sets the value of the sioThresholdAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setSioThresholdAmt(Money value) {
        this.sioThresholdAmt = value;
    }

    /**
     * Gets the value of the maxCarryOverLenght property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxCarryOverLenght() {
        return maxCarryOverLenght;
    }

    /**
     * Sets the value of the maxCarryOverLenght property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxCarryOverLenght(Long value) {
        this.maxCarryOverLenght = value;
    }

    /**
     * Gets the value of the maxCarryOverPeriodType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxCarryOverPeriodType() {
        return maxCarryOverPeriodType;
    }

    /**
     * Sets the value of the maxCarryOverPeriodType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxCarryOverPeriodType(String value) {
        this.maxCarryOverPeriodType = value;
    }

    /**
     * Gets the value of the isIndividualOverdiscDisabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsIndividualOverdiscDisabled() {
        return isIndividualOverdiscDisabled;
    }

    /**
     * Sets the value of the isIndividualOverdiscDisabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsIndividualOverdiscDisabled(Boolean value) {
        this.isIndividualOverdiscDisabled = value;
    }

    /**
     * Gets the value of the familyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFamilyId() {
        return familyId;
    }

    /**
     * Sets the value of the familyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFamilyId(Long value) {
        this.familyId = value;
    }

    /**
     * Gets the value of the listOfAssignments property.
     * 
     * @return
     *     possible object is
     *     {@link ListOfAssignmentsResponse }
     *     
     */
    public ListOfAssignmentsResponse getListOfAssignments() {
        return listOfAssignments;
    }

    /**
     * Sets the value of the listOfAssignments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOfAssignmentsResponse }
     *     
     */
    public void setListOfAssignments(ListOfAssignmentsResponse value) {
        this.listOfAssignments = value;
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
     * Gets the value of the csStatusDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCsStatusDate() {
        return csStatusDate;
    }

    /**
     * Sets the value of the csStatusDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCsStatusDate(XMLGregorianCalendar value) {
        this.csStatusDate = value;
    }

    /**
     * Gets the value of the csActivationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCsActivationDate() {
        return csActivationDate;
    }

    /**
     * Sets the value of the csActivationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCsActivationDate(XMLGregorianCalendar value) {
        this.csActivationDate = value;
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
     * Gets the value of the tradeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeCode() {
        return tradeCode;
    }

    /**
     * Sets the value of the tradeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeCode(String value) {
        this.tradeCode = value;
    }

    /**
     * Gets the value of the areaCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAreaCode() {
        return areaCode;
    }

    /**
     * Sets the value of the areaCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAreaCode(Long value) {
        this.areaCode = value;
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
     * Gets the value of the csPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsPassword() {
        return csPassword;
    }

    /**
     * Sets the value of the csPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsPassword(String value) {
        this.csPassword = value;
    }

    /**
     * Gets the value of the rsCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRsCode() {
        return rsCode;
    }

    /**
     * Sets the value of the rsCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRsCode(Long value) {
        this.rsCode = value;
    }

    /**
     * Gets the value of the rsShdes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRsShdes() {
        return rsShdes;
    }

    /**
     * Sets the value of the rsShdes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRsShdes(String value) {
        this.rsShdes = value;
    }

    /**
     * Gets the value of the wpCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getWpCode() {
        return wpCode;
    }

    /**
     * Sets the value of the wpCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setWpCode(Long value) {
        this.wpCode = value;
    }

    /**
     * Gets the value of the srCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSrCode() {
        return srCode;
    }

    /**
     * Sets the value of the srCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSrCode(Long value) {
        this.srCode = value;
    }

    /**
     * Gets the value of the csRemark1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsRemark1() {
        return csRemark1;
    }

    /**
     * Sets the value of the csRemark1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsRemark1(String value) {
        this.csRemark1 = value;
    }

    /**
     * Gets the value of the csRemark2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsRemark2() {
        return csRemark2;
    }

    /**
     * Sets the value of the csRemark2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsRemark2(String value) {
        this.csRemark2 = value;
    }

    /**
     * Gets the value of the csBillInformation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCsBillInformation() {
        return csBillInformation;
    }

    /**
     * Sets the value of the csBillInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCsBillInformation(Boolean value) {
        this.csBillInformation = value;
    }

    /**
     * Gets the value of the callSelectMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallSelectMode() {
        return callSelectMode;
    }

    /**
     * Sets the value of the callSelectMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallSelectMode(String value) {
        this.callSelectMode = value;
    }

    /**
     * Gets the value of the expectPayCurrencyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getExpectPayCurrencyId() {
        return expectPayCurrencyId;
    }

    /**
     * Sets the value of the expectPayCurrencyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setExpectPayCurrencyId(Long value) {
        this.expectPayCurrencyId = value;
    }

    /**
     * Gets the value of the expectPayCurrencyIdPub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpectPayCurrencyIdPub() {
        return expectPayCurrencyIdPub;
    }

    /**
     * Sets the value of the expectPayCurrencyIdPub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpectPayCurrencyIdPub(String value) {
        this.expectPayCurrencyIdPub = value;
    }

    /**
     * Gets the value of the csConvratetypePayment property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCsConvratetypePayment() {
        return csConvratetypePayment;
    }

    /**
     * Sets the value of the csConvratetypePayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCsConvratetypePayment(Long value) {
        this.csConvratetypePayment = value;
    }

    /**
     * Gets the value of the csConvratetypePaymentPub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsConvratetypePaymentPub() {
        return csConvratetypePaymentPub;
    }

    /**
     * Sets the value of the csConvratetypePaymentPub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsConvratetypePaymentPub(String value) {
        this.csConvratetypePaymentPub = value;
    }

    /**
     * Gets the value of the refundCurrencyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRefundCurrencyId() {
        return refundCurrencyId;
    }

    /**
     * Sets the value of the refundCurrencyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRefundCurrencyId(Long value) {
        this.refundCurrencyId = value;
    }

    /**
     * Gets the value of the refundCurrencyIdPub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundCurrencyIdPub() {
        return refundCurrencyIdPub;
    }

    /**
     * Sets the value of the refundCurrencyIdPub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundCurrencyIdPub(String value) {
        this.refundCurrencyIdPub = value;
    }

    /**
     * Gets the value of the csConvratetypeRefund property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCsConvratetypeRefund() {
        return csConvratetypeRefund;
    }

    /**
     * Sets the value of the csConvratetypeRefund property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCsConvratetypeRefund(Long value) {
        this.csConvratetypeRefund = value;
    }

    /**
     * Gets the value of the csConvratetypeRefundPub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsConvratetypeRefundPub() {
        return csConvratetypeRefundPub;
    }

    /**
     * Sets the value of the csConvratetypeRefundPub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsConvratetypeRefundPub(String value) {
        this.csConvratetypeRefundPub = value;
    }

    /**
     * Gets the value of the csCrcheckAgreed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCsCrcheckAgreed() {
        return csCrcheckAgreed;
    }

    /**
     * Sets the value of the csCrcheckAgreed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCsCrcheckAgreed(Boolean value) {
        this.csCrcheckAgreed = value;
    }

    /**
     * Gets the value of the custcatCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCustcatCode() {
        return custcatCode;
    }

    /**
     * Sets the value of the custcatCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCustcatCode(Long value) {
        this.custcatCode = value;
    }

    /**
     * Gets the value of the custcatCodePub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustcatCodePub() {
        return custcatCodePub;
    }

    /**
     * Sets the value of the custcatCodePub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustcatCodePub(String value) {
        this.custcatCodePub = value;
    }

    /**
     * Gets the value of the csJurisdictionId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCsJurisdictionId() {
        return csJurisdictionId;
    }

    /**
     * Sets the value of the csJurisdictionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCsJurisdictionId(Long value) {
        this.csJurisdictionId = value;
    }

    /**
     * Gets the value of the csJurisdictionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsJurisdictionCode() {
        return csJurisdictionCode;
    }

    /**
     * Sets the value of the csJurisdictionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsJurisdictionCode(String value) {
        this.csJurisdictionCode = value;
    }

    /**
     * Gets the value of the csIncorporatedInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCsIncorporatedInd() {
        return csIncorporatedInd;
    }

    /**
     * Sets the value of the csIncorporatedInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCsIncorporatedInd(Boolean value) {
        this.csIncorporatedInd = value;
    }

    /**
     * Gets the value of the csBillcycle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsBillcycle() {
        return csBillcycle;
    }

    /**
     * Sets the value of the csBillcycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsBillcycle(String value) {
        this.csBillcycle = value;
    }

    /**
     * Gets the value of the csBillcycleDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsBillcycleDesc() {
        return csBillcycleDesc;
    }

    /**
     * Sets the value of the csBillcycleDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsBillcycleDesc(String value) {
        this.csBillcycleDesc = value;
    }

    /**
     * Gets the value of the csLimitTr1 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCsLimitTr1() {
        return csLimitTr1;
    }

    /**
     * Sets the value of the csLimitTr1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCsLimitTr1(Long value) {
        this.csLimitTr1 = value;
    }

    /**
     * Gets the value of the csLimitTr1Pub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsLimitTr1Pub() {
        return csLimitTr1Pub;
    }

    /**
     * Sets the value of the csLimitTr1Pub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsLimitTr1Pub(String value) {
        this.csLimitTr1Pub = value;
    }

    /**
     * Gets the value of the csLimitTr2 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCsLimitTr2() {
        return csLimitTr2;
    }

    /**
     * Sets the value of the csLimitTr2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCsLimitTr2(Long value) {
        this.csLimitTr2 = value;
    }

    /**
     * Gets the value of the csLimitTr2Pub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsLimitTr2Pub() {
        return csLimitTr2Pub;
    }

    /**
     * Sets the value of the csLimitTr2Pub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsLimitTr2Pub(String value) {
        this.csLimitTr2Pub = value;
    }

    /**
     * Gets the value of the csLimitTr3 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCsLimitTr3() {
        return csLimitTr3;
    }

    /**
     * Sets the value of the csLimitTr3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCsLimitTr3(Long value) {
        this.csLimitTr3 = value;
    }

    /**
     * Gets the value of the csLimitTr3Pub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsLimitTr3Pub() {
        return csLimitTr3Pub;
    }

    /**
     * Sets the value of the csLimitTr3Pub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsLimitTr3Pub(String value) {
        this.csLimitTr3Pub = value;
    }

    /**
     * Gets the value of the csClimit property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getCsClimit() {
        return csClimit;
    }

    /**
     * Sets the value of the csClimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setCsClimit(Money value) {
        this.csClimit = value;
    }

    /**
     * Gets the value of the csContresp property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCsContresp() {
        return csContresp;
    }

    /**
     * Sets the value of the csContresp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCsContresp(Boolean value) {
        this.csContresp = value;
    }

    /**
     * Gets the value of the csLastBcDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCsLastBcDate() {
        return csLastBcDate;
    }

    /**
     * Sets the value of the csLastBcDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCsLastBcDate(XMLGregorianCalendar value) {
        this.csLastBcDate = value;
    }

    /**
     * Gets the value of the csDeposit property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getCsDeposit() {
        return csDeposit;
    }

    /**
     * Sets the value of the csDeposit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setCsDeposit(Money value) {
        this.csDeposit = value;
    }

    /**
     * Gets the value of the csCreditscore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCreditscore() {
        return csCreditscore;
    }

    /**
     * Sets the value of the csCreditscore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCreditscore(String value) {
        this.csCreditscore = value;
    }

    /**
     * Gets the value of the csCscreditStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCscreditStatus() {
        return csCscreditStatus;
    }

    /**
     * Sets the value of the csCscreditStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCscreditStatus(String value) {
        this.csCscreditStatus = value;
    }

    /**
     * Gets the value of the csCscreditRemark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCscreditRemark() {
        return csCscreditRemark;
    }

    /**
     * Sets the value of the csCscreditRemark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCscreditRemark(String value) {
        this.csCscreditRemark = value;
    }

    /**
     * Gets the value of the csCscreditDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCsCscreditDate() {
        return csCscreditDate;
    }

    /**
     * Sets the value of the csCscreditDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCsCscreditDate(XMLGregorianCalendar value) {
        this.csCscreditDate = value;
    }

    /**
     * Gets the value of the csDunning property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCsDunning() {
        return csDunning;
    }

    /**
     * Sets the value of the csDunning property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCsDunning(Boolean value) {
        this.csDunning = value;
    }

    /**
     * Gets the value of the csDunningMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsDunningMode() {
        return csDunningMode;
    }

    /**
     * Sets the value of the csDunningMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsDunningMode(String value) {
        this.csDunningMode = value;
    }

    /**
     * Gets the value of the csPrepayment property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCsPrepayment() {
        return csPrepayment;
    }

    /**
     * Sets the value of the csPrepayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCsPrepayment(Boolean value) {
        this.csPrepayment = value;
    }

    /**
     * Gets the value of the csCollector property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCollector() {
        return csCollector;
    }

    /**
     * Sets the value of the csCollector property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCollector(String value) {
        this.csCollector = value;
    }

    /**
     * Gets the value of the csFcId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCsFcId() {
        return csFcId;
    }

    /**
     * Sets the value of the csFcId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCsFcId(Long value) {
        this.csFcId = value;
    }

    /**
     * Gets the value of the csFcIdPub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsFcIdPub() {
        return csFcIdPub;
    }

    /**
     * Sets the value of the csFcIdPub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsFcIdPub(String value) {
        this.csFcIdPub = value;
    }

    /**
     * Gets the value of the csCscurbalance property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getCsCscurbalance() {
        return csCscurbalance;
    }

    /**
     * Sets the value of the csCscurbalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setCsCscurbalance(Money value) {
        this.csCscurbalance = value;
    }

    /**
     * Gets the value of the csPrevbalance property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getCsPrevbalance() {
        return csPrevbalance;
    }

    /**
     * Sets the value of the csPrevbalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setCsPrevbalance(Money value) {
        this.csPrevbalance = value;
    }

    /**
     * Gets the value of the csUnbilledAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getCsUnbilledAmount() {
        return csUnbilledAmount;
    }

    /**
     * Sets the value of the csUnbilledAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setCsUnbilledAmount(Money value) {
        this.csUnbilledAmount = value;
    }

    /**
     * Gets the value of the csPaybehaviour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsPaybehaviour() {
        return csPaybehaviour;
    }

    /**
     * Sets the value of the csPaybehaviour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsPaybehaviour(String value) {
        this.csPaybehaviour = value;
    }

    /**
     * Gets the value of the csNoBouncePay property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCsNoBouncePay() {
        return csNoBouncePay;
    }

    /**
     * Sets the value of the csNoBouncePay property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCsNoBouncePay(BigInteger value) {
        this.csNoBouncePay = value;
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
     * Gets the value of the csInitPrepaidContrOwner property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCsInitPrepaidContrOwner() {
        return csInitPrepaidContrOwner;
    }

    /**
     * Sets the value of the csInitPrepaidContrOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCsInitPrepaidContrOwner(Boolean value) {
        this.csInitPrepaidContrOwner = value;
    }

    /**
     * Gets the value of the csCreationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCsCreationDate() {
        return csCreationDate;
    }

    /**
     * Sets the value of the csCreationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCsCreationDate(XMLGregorianCalendar value) {
        this.csCreationDate = value;
    }

    /**
     * Gets the value of the csDeactivationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCsDeactivationDate() {
        return csDeactivationDate;
    }

    /**
     * Sets the value of the csDeactivationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCsDeactivationDate(XMLGregorianCalendar value) {
        this.csDeactivationDate = value;
    }

    /**
     * Gets the value of the csSuspensionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCsSuspensionDate() {
        return csSuspensionDate;
    }

    /**
     * Sets the value of the csSuspensionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCsSuspensionDate(XMLGregorianCalendar value) {
        this.csSuspensionDate = value;
    }

    /**
     * Gets the value of the csReactivationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCsReactivationDate() {
        return csReactivationDate;
    }

    /**
     * Sets the value of the csReactivationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCsReactivationDate(XMLGregorianCalendar value) {
        this.csReactivationDate = value;
    }

    /**
     * Gets the value of the lastModificationUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastModificationUser() {
        return lastModificationUser;
    }

    /**
     * Sets the value of the lastModificationUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastModificationUser(String value) {
        this.lastModificationUser = value;
    }

    /**
     * Gets the value of the paymentRespId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPaymentRespId() {
        return paymentRespId;
    }

    /**
     * Sets the value of the paymentRespId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPaymentRespId(Long value) {
        this.paymentRespId = value;
    }

    /**
     * Gets the value of the csPaymntRespCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsPaymntRespCode() {
        return csPaymntRespCode;
    }

    /**
     * Sets the value of the csPaymntRespCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsPaymntRespCode(String value) {
        this.csPaymntRespCode = value;
    }

    /**
     * Gets the value of the partyRoleAssignments property.
     * 
     * @return
     *     possible object is
     *     {@link PartyRoleAssignmentsResponse }
     *     
     */
    public PartyRoleAssignmentsResponse getPartyRoleAssignments() {
        return partyRoleAssignments;
    }

    /**
     * Sets the value of the partyRoleAssignments property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyRoleAssignmentsResponse }
     *     
     */
    public void setPartyRoleAssignments(PartyRoleAssignmentsResponse value) {
        this.partyRoleAssignments = value;
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
     * Gets the value of the collInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCollInd() {
        return collInd;
    }

    /**
     * Sets the value of the collInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCollInd(Boolean value) {
        this.collInd = value;
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
     * Gets the value of the maxCsLevel property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxCsLevel() {
        return maxCsLevel;
    }

    /**
     * Sets the value of the maxCsLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxCsLevel(Long value) {
        this.maxCsLevel = value;
    }

    /**
     * Gets the value of the creditScore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditScore() {
        return creditScore;
    }

    /**
     * Sets the value of the creditScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditScore(String value) {
        this.creditScore = value;
    }

    /**
     * Gets the value of the creditScoreProvider property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditScoreProvider() {
        return creditScoreProvider;
    }

    /**
     * Sets the value of the creditScoreProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditScoreProvider(String value) {
        this.creditScoreProvider = value;
    }

    /**
     * Gets the value of the csCscreditUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCscreditUser() {
        return csCscreditUser;
    }

    /**
     * Sets the value of the csCscreditUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCscreditUser(String value) {
        this.csCscreditUser = value;
    }

    /**
     * Gets the value of the performCreditScoring property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPerformCreditScoring() {
        return performCreditScoring;
    }

    /**
     * Sets the value of the performCreditScoring property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPerformCreditScoring(Boolean value) {
        this.performCreditScoring = value;
    }

    /**
     * Gets the value of the cslvlname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCslvlname() {
        return cslvlname;
    }

    /**
     * Sets the value of the cslvlname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCslvlname(String value) {
        this.cslvlname = value;
    }

    /**
     * Gets the value of the adrNationality property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdrNationality() {
        return adrNationality;
    }

    /**
     * Sets the value of the adrNationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdrNationality(Long value) {
        this.adrNationality = value;
    }

    /**
     * Gets the value of the adrNationalityPub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrNationalityPub() {
        return adrNationalityPub;
    }

    /**
     * Sets the value of the adrNationalityPub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrNationalityPub(String value) {
        this.adrNationalityPub = value;
    }

    /**
     * Gets the value of the adrEmployee property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAdrEmployee() {
        return adrEmployee;
    }

    /**
     * Sets the value of the adrEmployee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAdrEmployee(Boolean value) {
        this.adrEmployee = value;
    }

    /**
     * Gets the value of the csTestbillrun property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsTestbillrun() {
        return csTestbillrun;
    }

    /**
     * Sets the value of the csTestbillrun property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsTestbillrun(String value) {
        this.csTestbillrun = value;
    }

    /**
     * Gets the value of the roundingCarryLeftOver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoundingCarryLeftOver() {
        return roundingCarryLeftOver;
    }

    /**
     * Sets the value of the roundingCarryLeftOver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoundingCarryLeftOver(String value) {
        this.roundingCarryLeftOver = value;
    }

    /**
     * Gets the value of the allowIndividualBillcycleInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowIndividualBillcycleInd() {
        return allowIndividualBillcycleInd;
    }

    /**
     * Sets the value of the allowIndividualBillcycleInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowIndividualBillcycleInd(Boolean value) {
        this.allowIndividualBillcycleInd = value;
    }

    /**
     * Gets the value of the billAgreementId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBillAgreementId() {
        return billAgreementId;
    }

    /**
     * Sets the value of the billAgreementId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBillAgreementId(Long value) {
        this.billAgreementId = value;
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
     * Gets the value of the creditClassAssignments property.
     * 
     * @return
     *     possible object is
     *     {@link CreditClassAssignmentsResponse }
     *     
     */
    public CreditClassAssignmentsResponse getCreditClassAssignments() {
        return creditClassAssignments;
    }

    /**
     * Sets the value of the creditClassAssignments property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditClassAssignmentsResponse }
     *     
     */
    public void setCreditClassAssignments(CreditClassAssignmentsResponse value) {
        this.creditClassAssignments = value;
    }

    /**
     * Gets the value of the invoiceLimitPersonalizations property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceLimitPersonalizationsResponse }
     *     
     */
    public InvoiceLimitPersonalizationsResponse getInvoiceLimitPersonalizations() {
        return invoiceLimitPersonalizations;
    }

    /**
     * Sets the value of the invoiceLimitPersonalizations property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceLimitPersonalizationsResponse }
     *     
     */
    public void setInvoiceLimitPersonalizations(InvoiceLimitPersonalizationsResponse value) {
        this.invoiceLimitPersonalizations = value;
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

    /**
     * Gets the value of the allowRentalFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowRentalFlag() {
        return allowRentalFlag;
    }

    /**
     * Sets the value of the allowRentalFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowRentalFlag(Boolean value) {
        this.allowRentalFlag = value;
    }

    /**
     * Gets the value of the rentalThresholdFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRentalThresholdFlag() {
        return rentalThresholdFlag;
    }

    /**
     * Sets the value of the rentalThresholdFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRentalThresholdFlag(Boolean value) {
        this.rentalThresholdFlag = value;
    }

    /**
     * Gets the value of the csProtectionMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsProtectionMode() {
        return csProtectionMode;
    }

    /**
     * Sets the value of the csProtectionMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsProtectionMode(String value) {
        this.csProtectionMode = value;
    }

}
