package com.atos.paybatch.util;

import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.cxf.binding.soap.SoapFault;

/**
 * Utility class for handling and classifying exceptions related to JAX-WS and CXF SOAP clients.
 * This logic can be reused across multiple SOAP client implementations.
 */
public final class SoapExceptionUtils {

    private SoapExceptionUtils() {
        // Prevent instantiation
    }
    
    /**
     * Recursively unwraps the root cause of an exception.
     */
    public static Throwable unwrapRootCause(Throwable ex) {
        Throwable root = ex;
        while (root.getCause() != null && root.getCause() != root) {
            root = root.getCause();
        }
        return root;
    }

    /**
     * Extracts the message from the root cause of an exception.
     */
    public static String getRootCauseMessage(Throwable t) {
        Throwable root = unwrapRootCause(t);
        return root.getMessage() != null ? root.getMessage() : root.getClass().getSimpleName();
    }
    
    /**
     * Classifies a SOAP exception as transient (retryable) or permanent (non-retryable)
     * based on its root cause and type.
     * * @param ex The exception thrown during the SOAP call.
     * @return true if the exception is transient and should be retried.
     */
    public static boolean isTransient(Exception ex) {
        // root = unwrapRootCause(ex);

        // 1. Check for Transient Network/Transport Errors
        // These include timeouts, generic I/O issues (connection reset/broken pipe), and generic WebService exceptions.
        if (ex instanceof WebServiceException) {
            return true;
        }

        // 2. Check for SOAP Faults (Permanent vs. Transient based on fault code)
        if (ex instanceof SOAPFaultException sfe) {
            return isRetryableJaxWsFault(sfe);
        }

        // 3. Check for SOAP Faults (Permanent vs. Transient based on fault code)
        if (ex instanceof SoapFault sf) {
            return isRetryableSoapFault(sf);
        }
        
        // 4. Fallback: Treat everything else as permanent (likely a programming bug, data error, or unclassified issue)
        return false;
    }

    // --- Private classification helpers used by isTransient ---

    private static boolean isRetryableSoapFault(SoapFault sf) {
        if (sf == null) return false;

        String code = sf.getFaultCode() != null ? sf.getFaultCode().getLocalPart() : null;
        // Client/Sender faults are non-retryable (bad request)
        if (code != null && ("Client".equalsIgnoreCase(code) || "Sender".equalsIgnoreCase(code))) {
            return false;
        }
        // Server/Receiver or unknown faults are treated as transient
        return true; 
    }

    private static boolean isRetryableJaxWsFault(SOAPFaultException sfe) {
        if (sfe == null || sfe.getFault() == null) return true;

        String code = sfe.getFault().getFaultCode();
        // Client/Sender faults are non-retryable (bad request)
        if (code != null && (code.contains("Client") || code.contains("Sender"))) {
            return false;
        }
        // Server/Receiver or unknown faults are treated as transient
        return true; 
    }
}
