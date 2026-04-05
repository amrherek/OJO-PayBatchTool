package com.atos.paybatch.config;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atos.paybatch.stubs.customerread.CustomerReadService;
import com.atos.paybatch.stubs.customerread.CustomerReadService_Service;
import com.atos.paybatch.stubs.customersearch.CustomersSearchService;
import com.atos.paybatch.stubs.customersearch.CustomersSearchService_Service;
import com.atos.paybatch.stubs.financialallocation.FinancialAllocationWriteService;
import com.atos.paybatch.stubs.financialallocation.FinancialAllocationWriteService_Service;
import com.atos.paybatch.util.CxfSSLBypass;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class SoapClientConfig {

	
    @Value("${bscs.webservices.endpoint}")
    private String bscsWebServiceEndpoint;

    @Value("${soap.username}")
    private String username;

    @Value("${soap.password}")
    private String password;
    
    @Value("${soap.logging.enabled:true}")
    private boolean soapLoggingEnabled;

    @Value("${soap.logging.limit:0}") // 0 = unlimited
    private int soapLoggingLimit;
    

    /**
     * Common method to configure any SOAP port
     */
    private <T> T configurePort(T port, String endpoint) {
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

        CxfSSLBypass.disableSslVerificationForPort(port);

        if (soapLoggingEnabled) {
            Client client = ClientProxy.getClient(port);

            LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
            LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();

            if (soapLoggingLimit > 0) {
                inInterceptor.setLimit(soapLoggingLimit);
                outInterceptor.setLimit(soapLoggingLimit);
            }

            client.getInInterceptors().add(inInterceptor);
            client.getOutInterceptors().add(outInterceptor);

            log.info("SOAP logging enabled (limit={} bytes)", soapLoggingLimit);
        } else {
            log.info("SOAP logging disabled");
        }

        return port;
    }

    @Bean
    public CustomersSearchService customersSearchPort() throws Exception {
        URL wsdl = getClass().getResource("/wsdl/ws_CIL_7_CustomersSearchService.wsdl");
        if (wsdl == null) {
            throw new IllegalStateException("WSDL not found: /wsdl/ws_CIL_7_CustomersSearchService.wsdl");
        }

        QName serviceName = new QName("http://ericsson.com/services/ws_CIL_7", "CustomersSearchService");
        CustomersSearchService_Service service = new CustomersSearchService_Service(wsdl, serviceName);
        service.setHandlerResolver(portInfo -> java.util.Collections.singletonList(
                new WSSUsernameTokenSOAPHandler(username, password)));

        CustomersSearchService port = service.getCustomersSearchServiceSoap11();
        log.info("CustomersSearchService endpoint: {}", bscsWebServiceEndpoint);
        return configurePort(port, bscsWebServiceEndpoint);
    }

    @Bean
    public FinancialAllocationWriteService financialAllocationPort() throws Exception {
        URL wsdl = getClass().getResource("/wsdl/ws_CIL_7_FinancialAllocationWriteService.wsdl");
        if (wsdl == null) {
            throw new IllegalStateException("WSDL not found: /wsdl/ws_CIL_7_FinancialAllocationWriteService.wsdl");
        }

        QName serviceName = new QName("http://ericsson.com/services/ws_CIL_7", "FinancialAllocationWriteService");
        FinancialAllocationWriteService_Service service = new FinancialAllocationWriteService_Service(wsdl, serviceName);
        service.setHandlerResolver(portInfo -> java.util.Collections.singletonList(
                new WSSUsernameTokenSOAPHandler(username, password)));

        FinancialAllocationWriteService port = service.getFinancialAllocationWriteServiceSoap11();
        log.info("FinancialAllocationWriteService endpoint: {}", bscsWebServiceEndpoint);
        return configurePort(port, bscsWebServiceEndpoint);
    }
    
    
    @Bean
    public CustomerReadService customerReadPort() throws Exception {
        URL wsdl = getClass().getResource("/wsdl/ws_CIL_7_CustomerReadService.wsdl");
        if (wsdl == null) {
            throw new IllegalStateException("WSDL not found: /wsdl/ws_CIL_7_CustomerReadService.wsdl");
        }

        QName serviceName = new QName("http://ericsson.com/services/ws_CIL_7", "CustomerReadService");
        CustomerReadService_Service service = new CustomerReadService_Service(wsdl, serviceName);

        service.setHandlerResolver(portInfo -> java.util.Collections.singletonList(
                new WSSUsernameTokenSOAPHandler(username, password)));

        CustomerReadService port = service.getCustomerReadServiceSoap11();
        log.info("CustomerReadService endpoint: {}", bscsWebServiceEndpoint);
        return configurePort(port, bscsWebServiceEndpoint);
    }
}
