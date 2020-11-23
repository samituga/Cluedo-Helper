package com.sam.cluedo.game;

/**
 * The state that a card can have
 */
public enum State {
    HAS("Has"),
    UNKNOWN("Unknown"),
    HAS_NOT("Doesn't have");

    private final String label;

    State(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
