package com.atos.paybatch.config;

import java.net.URL;

import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atos.paybatch.stubs.customersearch.CustomersSearchService;
import com.atos.paybatch.stubs.customersearch.CustomersSearchService_Service;
import com.atos.paybatch.stubs.financialallocation.FinancialAllocationWriteService;
import com.atos.paybatch.stubs.financialallocation.FinancialAllocationWriteService_Service;

@Configuration
public class SoapClientConfig {

    @Value("${soap.customersearch.wsdl-url}")
    private String customerSearchWsdl;

    @Value("${soap.financialallocation.wsdl-url}")
    private String financialAllocationWsdl;

    @Value("${soap.username}")
    private String username;

    @Value("${soap.password}")
    private String password;

    @Bean
    public CustomersSearchService customersSearchPort() throws Exception {
        URL url = new URL(customerSearchWsdl);
        QName serviceName = new QName("http://ericsson.com/services/ws_CIL_7", "CustomersSearchService");

        CustomersSearchService_Service service = new CustomersSearchService_Service(url, serviceName);

        // Add WS-Security if needed
        service.setHandlerResolver(
            portInfo -> java.util.Collections.singletonList(new WSSUsernameTokenSOAPHandler(username, password))
        );
        return service.getCustomersSearchServiceSoap11();
    }
    

    @Bean
    public FinancialAllocationWriteService financialAllocationPort() throws Exception {
        URL url = new URL(financialAllocationWsdl);
        QName serviceName = new QName("http://ericsson.com/services/ws_CIL_7",  "FinancialAllocationWriteService");
        FinancialAllocationWriteService_Service service = new FinancialAllocationWriteService_Service (url, serviceName);
        service.setHandlerResolver(
            portInfo -> java.util.Collections.singletonList(new WSSUsernameTokenSOAPHandler(username, password))
        );
        return service.getFinancialAllocationWriteServiceSoap11();
    }
}
