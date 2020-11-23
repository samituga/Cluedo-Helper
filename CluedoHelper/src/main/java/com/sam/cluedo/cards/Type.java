package com.sam.cluedo.cards;

/**
 * Defines the type of a card
 */
enum Type {
    CHARACTER("Character"),
    ROOM("Room"),
    WEAPON("Weapon"),
    MURDER("Murder"),
    UNKNOWN("Unknown");

    private final String label;

    Type(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }

    @Override
    public String toString() {
        return "Type{" +
                "label='" + label + '\'' +
                '}';
    }
}
