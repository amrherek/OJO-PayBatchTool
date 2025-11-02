
package com.atos.paybatch.stubs.financialallocation;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 																	<p>Document list</p>
 * 																
 * 
 * <p>Java class for documentListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="documentListResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="documentWriteOutDTO" type="{http://ericsson.com/services/ws_CIL_7/financialallocationwrite}documentWriteOutDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "documentListResponse", propOrder = {
    "documentWriteOutDTO"
})
public class DocumentListResponse {

    protected List<DocumentWriteOutDTO> documentWriteOutDTO;

    /**
     * Gets the value of the documentWriteOutDTO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentWriteOutDTO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentWriteOutDTO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentWriteOutDTO }
     * 
     * 
     */
    public List<DocumentWriteOutDTO> getDocumentWriteOutDTO() {
        if (documentWriteOutDTO == null) {
            documentWriteOutDTO = new ArrayList<DocumentWriteOutDTO>();
        }
        return this.documentWriteOutDTO;
    }

}
