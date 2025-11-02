
package com.atos.paybatch.stubs.customersearch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 					<p></p>
 * 				
 * 
 * <p>Java class for customersSearchResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customersSearchResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="searchResult" type="{http://ericsson.com/services/ws_CIL_7/customerssearch}searchResultResponse" minOccurs="0"/&gt;
 *         &lt;element name="searchIsComplete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customersSearchResponse", propOrder = {

})
public class CustomersSearchResponse {

    protected SearchResultResponse searchResult;
    protected Boolean searchIsComplete;

    /**
     * Gets the value of the searchResult property.
     * 
     * @return
     *     possible object is
     *     {@link SearchResultResponse }
     *     
     */
    public SearchResultResponse getSearchResult() {
        return searchResult;
    }

    /**
     * Sets the value of the searchResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchResultResponse }
     *     
     */
    public void setSearchResult(SearchResultResponse value) {
        this.searchResult = value;
    }

    /**
     * Gets the value of the searchIsComplete property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSearchIsComplete() {
        return searchIsComplete;
    }

    /**
     * Sets the value of the searchIsComplete property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSearchIsComplete(Boolean value) {
        this.searchIsComplete = value;
    }

}
