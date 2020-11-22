package com.sam.cluedo.cards;

/**
 * Defines the type of a card
 */
enum Type {
    CHARACTER("Character"),
    ROOM("Room"),
    WEAPON("Weapon");

    private final String label;

    Type(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
