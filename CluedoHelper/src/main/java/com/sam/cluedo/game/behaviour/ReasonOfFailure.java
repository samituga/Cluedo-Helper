package com.sam.cluedo.game.behaviour;

/**
 * This enum defines the possible reasons of failure
 */
public enum ReasonOfFailure {
    NUMBER_OF_PLAYERS("Number of players"),
    NUMBER_OF_CARDS("Number of cards"),
    PLAYER_NUMBER_OF_CARDS("Player number of cards");

    private final String label;

    ReasonOfFailure(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
