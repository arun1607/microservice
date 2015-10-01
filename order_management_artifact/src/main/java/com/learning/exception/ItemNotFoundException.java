package com.learning.exception;

/**
 * Created by amits on 23/09/15.
 */
public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemNotFoundException(String message) {
        super(message);
    }
}
