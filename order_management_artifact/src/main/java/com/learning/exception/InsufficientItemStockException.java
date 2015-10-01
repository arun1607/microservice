package com.learning.exception;

/**
 * Created by amits on 23/09/15.
 */
public class InsufficientItemStockException extends Exception {
    public InsufficientItemStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientItemStockException(String message) {

        super(message);
    }
}
