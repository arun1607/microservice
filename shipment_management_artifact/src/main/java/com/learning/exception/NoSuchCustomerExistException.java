package com.learning.exception;

/**
 * Created by amits on 24/09/15.
 */
public class NoSuchCustomerExistException extends Exception {
    public NoSuchCustomerExistException(String message) {
        super(message);
    }

    public NoSuchCustomerExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
