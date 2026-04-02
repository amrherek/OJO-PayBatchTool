
package com.atos.paybatch.stubs.customerread;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.atos.paybatch.stubs.customerread package. 
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

    private final static QName _CustomerReadRequest_QNAME = new QName("http://ericsson.com/services/ws_CIL_7/customerread", "customerReadRequest");
    private final static QName _CustomerReadResponse_QNAME = new QName("http://ericsson.com/services/ws_CIL_7/customerread", "customerReadResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.atos.paybatch.stubs.customerread
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
     * Create an instance of {@link CustomerReadRequest }
     * 
     */
    public CustomerReadRequest createCustomerReadRequest() {
        return new CustomerReadRequest();
    }

    /**
     * Create an instance of {@link CustomerReadResponse }
     * 
     */
    public CustomerReadResponse createCustomerReadResponse() {
        return new CustomerReadResponse();
    }

    /**
     * Create an instance of {@link InvoiceLimitPersonalizationsListpartResponse }
     * 
     */
    public InvoiceLimitPersonalizationsListpartResponse createInvoiceLimitPersonalizationsListpartResponse() {
        return new InvoiceLimitPersonalizationsListpartResponse();
    }

    /**
     * Create an instance of {@link InvoiceLimitPersonalizationsResponse }
     * 
     */
    public InvoiceLimitPersonalizationsResponse createInvoiceLimitPersonalizationsResponse() {
        return new InvoiceLimitPersonalizationsResponse();
    }

    /**
     * Create an instance of {@link CreditClassAssignmentsListpartResponse }
     * 
     */
    public CreditClassAssignmentsListpartResponse createCreditClassAssignmentsListpartResponse() {
        return new CreditClassAssignmentsListpartResponse();
    }

    /**
     * Create an instance of {@link CreditClassAssignmentsResponse }
     * 
     */
    public CreditClassAssignmentsResponse createCreditClassAssignmentsResponse() {
        return new CreditClassAssignmentsResponse();
    }

    /**
     * Create an instance of {@link PartyRoleAssignmentsListpartResponse }
     * 
     */
    public PartyRoleAssignmentsListpartResponse createPartyRoleAssignmentsListpartResponse() {
        return new PartyRoleAssignmentsListpartResponse();
    }

    /**
     * Create an instance of {@link PartyRoleAssignmentsResponse }
     * 
     */
    public PartyRoleAssignmentsResponse createPartyRoleAssignmentsResponse() {
        return new PartyRoleAssignmentsResponse();
    }

    /**
     * Create an instance of {@link ListOfAssignmentsListpartResponse }
     * 
     */
    public ListOfAssignmentsListpartResponse createListOfAssignmentsListpartResponse() {
        return new ListOfAssignmentsListpartResponse();
    }

    /**
     * Create an instance of {@link ListOfAssignmentsResponse }
     * 
     */
    public ListOfAssignmentsResponse createListOfAssignmentsResponse() {
        return new ListOfAssignmentsResponse();
    }

    /**
     * Create an instance of {@link InputAttributes }
     * 
     */
    public InputAttributes createInputAttributes() {
        return new InputAttributes();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerReadRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomerReadRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://ericsson.com/services/ws_CIL_7/customerread", name = "customerReadRequest")
    public JAXBElement<CustomerReadRequest> createCustomerReadRequest(CustomerReadRequest value) {
        return new JAXBElement<CustomerReadRequest>(_CustomerReadRequest_QNAME, CustomerReadRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerReadResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomerReadResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ericsson.com/services/ws_CIL_7/customerread", name = "customerReadResponse")
    public JAXBElement<CustomerReadResponse> createCustomerReadResponse(CustomerReadResponse value) {
        return new JAXBElement<CustomerReadResponse>(_CustomerReadResponse_QNAME, CustomerReadResponse.class, null, value);
    }

}
