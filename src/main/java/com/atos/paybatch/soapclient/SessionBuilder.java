package com.atos.paybatch.soapclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SessionBuilder {

    public com.atos.paybatch.stubs.customersearch.SessionChangeRequest buildCustomerSearchSession() {
        log.debug("Building session change request for CustomerSearch...");
        var session = new com.atos.paybatch.stubs.customersearch.SessionChangeRequest();
        var values = new com.atos.paybatch.stubs.customersearch.ValuesRequest();
        var item = new com.atos.paybatch.stubs.customersearch.ValuesListpartRequest();
        item.setKey("BU_ID");
        item.setValue("2");
        values.getItem().add(item);
        session.setValues(values);
        return session;
    }

    public com.atos.paybatch.stubs.financialallocation.SessionChangeRequest buildFinancialSession() {
        log.debug("Building session change request for FinancialAllocation...");
        var session = new com.atos.paybatch.stubs.financialallocation.SessionChangeRequest();
        var values = new com.atos.paybatch.stubs.financialallocation.ValuesRequest();
        var item = new com.atos.paybatch.stubs.financialallocation.ValuesListpartRequest();
        item.setKey("BU_ID");
        item.setValue("2");
        values.getItem().add(item);
        session.setValues(values);
        return session;
    }
    
    
    public com.atos.paybatch.stubs.customerread.SessionChangeRequest buildCustomerReadSession() {
        log.debug("Building session change request for CustomerRead...");   
        var session = new com.atos.paybatch.stubs.customerread.SessionChangeRequest();
        var values = new com.atos.paybatch.stubs.customerread.ValuesRequest();
        var item = new com.atos.paybatch.stubs.customerread.ValuesListpartRequest();
        item.setKey("BU_ID");
        item.setValue("2");
        values.getItem().add(item);
        session.setValues(values);
        return session;
    }
    
    
}
