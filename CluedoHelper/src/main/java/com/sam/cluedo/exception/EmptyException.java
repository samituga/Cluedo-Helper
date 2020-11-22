package com.sam.cluedo.exception;

/**
 * This exception defines that there is a String or Collection or Map
 * that is empty and it shouldn't be
 */
public class EmptyException extends RuntimeException {

    public EmptyException(String message) {
        super(message);
    }
}
