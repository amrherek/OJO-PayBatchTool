
package com.atos.paybatch.stubs.customersearch;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.atos.paybatch.stubs.customersearch package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CustomersSearchRequest_QNAME = new QName("http://ericsson.com/services/ws_CIL_7/customerssearch", "customersSearchRequest");
    private final static QName _CustomersSearchResponse_QNAME = new QName("http://ericsson.com/services/ws_CIL_7/customerssearch", "customersSearchResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.atos.paybatch.stubs.customersearch
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Money }
     * 
     */
    public Money createMoney() {
        return new Money();
    }

    /**
     * Create an instance of {@link Svlany }
     * 
     */
    public Svlany createSvlany() {
        return new Svlany();
    }

    /**
     * Create an instance of {@link SessionChangeResponse }
     * 
     */
    public SessionChangeResponse createSessionChangeResponse() {
        return new SessionChangeResponse();
    }

    /**
     * Create an instance of {@link ValuesListpartRequest }
     * 
     */
    public ValuesListpartRequest createValuesListpartRequest() {
        return new ValuesListpartRequest();
    }

    /**
     * Create an instance of {@link ValuesRequest }
     * 
     */
    public ValuesRequest createValuesRequest() {
        return new ValuesRequest();
    }

    /**
     * Create an instance of {@link SessionChangeRequest }
     * 
     */
    public SessionChangeRequest createSessionChangeRequest() {
        return new SessionChangeRequest();
    }

    /**
     * Create an instance of {@link CustomersSearchRequest }
     * 
     */
    public CustomersSearchRequest createCustomersSearchRequest() {
        return new CustomersSearchRequest();
    }

    /**
     * Create an instance of {@link CustomersSearchResponse }
     * 
     */
    public CustomersSearchResponse createCustomersSearchResponse() {
        return new CustomersSearchResponse();
    }

    /**
     * Create an instance of {@link SearchResultListpartResponse }
     * 
     */
    public SearchResultListpartResponse createSearchResultListpartResponse() {
        return new SearchResultListpartResponse();
    }

    /**
     * Create an instance of {@link SearchResultResponse }
     * 
     */
    public SearchResultResponse createSearchResultResponse() {
        return new SearchResultResponse();
    }

    /**
     * Create an instance of {@link ExtLcStatusesRequest }
     * 
     */
    public ExtLcStatusesRequest createExtLcStatusesRequest() {
        return new ExtLcStatusesRequest();
    }

    /**
     * Create an instance of {@link StatesRequest }
     * 
     */
    public StatesRequest createStatesRequest() {
        return new StatesRequest();
    }

    /**
     * Create an instance of {@link InputAttributes }
     * 
     */
    public InputAttributes createInputAttributes() {
        return new InputAttributes();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomersSearchRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomersSearchRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://ericsson.com/services/ws_CIL_7/customerssearch", name = "customersSearchRequest")
    public JAXBElement<CustomersSearchRequest> createCustomersSearchRequest(CustomersSearchRequest value) {
        return new JAXBElement<CustomersSearchRequest>(_CustomersSearchRequest_QNAME, CustomersSearchRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomersSearchResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomersSearchResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ericsson.com/services/ws_CIL_7/customerssearch", name = "customersSearchResponse")
    public JAXBElement<CustomersSearchResponse> createCustomersSearchResponse(CustomersSearchResponse value) {
        return new JAXBElement<CustomersSearchResponse>(_CustomersSearchResponse_QNAME, CustomersSearchResponse.class, null, value);
    }

}
