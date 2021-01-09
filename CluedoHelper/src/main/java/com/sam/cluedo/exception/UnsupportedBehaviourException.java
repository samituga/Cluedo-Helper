package com.sam.cluedo.exception;

/**
 * This exception defines that something that should never happen in the program happened
 */
public class UnsupportedBehaviourException extends RuntimeException {

    public UnsupportedBehaviourException(String message) {
        super(message);
    }
}
