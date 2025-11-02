
package com.atos.paybatch.stubs.customersearch;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								<p>Public key of the external life cycle status of the customer.</p>
 * 							
 * 
 * <p>Java class for extLcStatusesRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="extLcStatusesRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="extLcStatus" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "extLcStatusesRequest", propOrder = {
    "extLcStatus"
})
public class ExtLcStatusesRequest {

    protected List<String> extLcStatus;

    /**
     * Gets the value of the extLcStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extLcStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtLcStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getExtLcStatus() {
        if (extLcStatus == null) {
            extLcStatus = new ArrayList<String>();
        }
        return this.extLcStatus;
    }

}
