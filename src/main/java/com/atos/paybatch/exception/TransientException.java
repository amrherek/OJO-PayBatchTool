package com.atos.paybatch.exception;

/**
 * Represents a technical fault in the external service (e.g., network, SOAP, HTTP).
 * Can be retriable or not depending on subclass.
 */
public class TransientException extends ExternalServiceException {
    public TransientException(String message) {
        super(message);
    }

    public TransientException(String message, Throwable cause) {
        super(message, cause);
    }
}
