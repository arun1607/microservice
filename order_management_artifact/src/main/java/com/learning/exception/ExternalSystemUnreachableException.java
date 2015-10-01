package com.learning.exception;

/**
 * Created by amits on 30/09/15.
 */
public class ExternalSystemUnreachableException extends RuntimeException {
    public ExternalSystemUnreachableException(String message) {
        super(message);
    }

    public ExternalSystemUnreachableException(String message, Throwable cause) {
        super(message, cause);
    }
}
