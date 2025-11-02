package com.atos.paybatch.config;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapFault;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atos.paybatch.exception.ApigeeFaultException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Intercepts CXF responses to detect JSON or SOAP faults (e.g., from Apigee).
 * Logs the response before CXF consumes it and throws BusinessFaultException if a fault is detected.
 */
public class ApigeeJsonFaultInterceptor extends AbstractPhaseInterceptor<Message> {

    private static final Logger log = LoggerFactory.getLogger(ApigeeJsonFaultInterceptor.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public ApigeeJsonFaultInterceptor() {
        // Earliest safe inbound phase for reading response
        super(Phase.RECEIVE);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        try {
        	
            String contentType = (String) message.get(Message.CONTENT_TYPE);
            if (contentType != null && !contentType.toLowerCase().contains("json")) {
                // Leave the original InputStream untouched for downstream CXF processing
                log.debug("[ApigeeJsonFaultInterceptor] Non-JSON Content-Type, skipping JSON parsing.");
                return;
            }

        	
            InputStream is = message.getContent(InputStream.class);
            if (is == null) {
                return;
            }

            // Read response into memory
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[8192];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            byte[] bytes = baos.toByteArray();

            // Convert to string
            String response = new String(bytes, StandardCharsets.UTF_8).trim();

            log.debug("[ApigeeJsonFaultInterceptor] Raw response (first {} chars): {}",
                    Math.min(5000, response.length()),
                    response.substring(0, Math.min(5000, response.length())));

            // Detect JSON payloads
            if (response.startsWith("{")) {
                JsonNode root = mapper.readTree(response);

                // Try both structures (SOAP-style or flat Apigee)
                JsonNode faultNode = root.path("Envelope").path("Body").path("Fault");
                if (faultNode.isMissingNode()) {
                    faultNode = root.path("fault");
                }

                if (!faultNode.isMissingNode()) {
                    String faultString = faultNode.path("faultstring").asText("Unknown fault");
                    String errorCode = faultNode.path("detail")
                                                .path("source")
                                                .path("errorcode")
                                                .asText("UnknownError");

                    // Add “Apigee” marker
                    String decoratedMessage = String.format("Apigee JSON fault detected: %s (code: %s)",
                                                            faultString, errorCode);

                    log.error("[ApigeeJsonFaultInterceptor] {} | Full response:\n{}", decoratedMessage, response);

                    // Wrap as SOAP-style fault for CXF to process
                    throw new ApigeeFaultException(
                            decoratedMessage,
                            new SoapFault(decoratedMessage,
                                    new QName("http://schemas.xmlsoap.org/soap/envelope/")));
                }
            }

            // Reattach stream for CXF unmarshalling downstream
            message.setContent(InputStream.class, new ByteArrayInputStream(bytes));

        } catch (SoapFault sf) {
            // CXF native fault — rethrow as is
            throw sf;
        } catch (Exception e) {
            log.error("[ApigeeJsonFaultInterceptor] Error processing inbound message", e);
            throw new Fault(e);
        }
    }
}
