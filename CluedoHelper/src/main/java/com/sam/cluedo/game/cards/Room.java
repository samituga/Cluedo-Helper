package com.sam.cluedo.game.cards;

/**
 * Defines the room cards
 */
public enum Room implements ICard {
    BALLROOM("Ballroom", true),
    BILLIARD_ROOM("Billiard Room", true),
    CONSERVATORY("Conservatory", true),
    DINING_ROOM("Dining Room", true),
    GUEST_HOUSE("Guest House", false),
    HALL("Hall", true),
    KITCHEN("Kitchen", true),
    LIBRARY("Library", true),
    LIVING_ROOM("Living Room", false),
    LOUNGE("Lounge", true),
    OBSERVATORY("Observatory", false),
    PATIO("Patio", false),
    SPA("Spa", false),
    STUDY("Study", true),
    THEATRE("Theatre", false);

    private final String label;
    private final Type type = Type.ROOM;
    private final boolean isDefault;

    Room(String label, boolean isDefault) {
        this.label = label;
        this.isDefault = isDefault;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String label() {
        return label;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type type() {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDefault() {
        return isDefault;
    }

    @Override
    public String toString() {
        return stringValue();
    }
}
