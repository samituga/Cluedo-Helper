package com.sam.cluedo.game.cards;

/**
 * Defines the weapon cards
 */
public enum Weapon implements ICard {
    CANDLESTICK("Candlestick", true),
    DAGGER("Dagger", true),
    LEAD_PIPE("Lead Pipe", true),
    REVOLVER("Spanner", true),
    ROPE("Rope", true),
    SPANNER("Spanner", false),
    WRENCH("Wrench", true);

    private final String label;
    private final Type type = Type.WEAPON;
    private final boolean isDefault;

    Weapon(String label, boolean isDefault) {
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
