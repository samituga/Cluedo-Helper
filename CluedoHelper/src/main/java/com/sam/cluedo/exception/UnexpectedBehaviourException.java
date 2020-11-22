package com.sam.cluedo.exception;

/**
 * This exception defines that something that should never happen in the program happened
 */
public class UnexpectedBehaviourException extends RuntimeException {

    public UnexpectedBehaviourException(String message) {
        super(message);
    }
}
