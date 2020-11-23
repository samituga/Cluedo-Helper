package com.sam.cluedo.cards;

import com.sam.cluedo.util.Colour;

/**
 * Defines the character cards
 */
public enum Character implements ICard {
    ADLER("Adler", Colour.EMERALD, false),
    AZURE("Azure", Colour.AZURE, false),
    BROOK("Meadow-Brook", Colour.SAPPHIRE, false),
    BRUNETTE("Brunette", Colour.SYRUP, false),
    GREEN("Green", Colour.GREEN, true),
    GREY("Grey", Colour.GREY, false),
    MORIARTY("Moriarty", Colour.SHADOW, false),
    MUSTARD("Colonel Mustard", Colour.YELLOW, true),
    PEACOCK("Mrs. Peacock", Colour.BLUE, true),
    PLUM("Professor Plum", Colour.PURPLE, true),
    SCARLETT("Miss Scarlett", Colour.RED, true),
    ORCHID("Orchid", Colour.ORCHID, true),
    WHITE("White", Colour.WHITE, false),
    ROSE("Rose", Colour.ROSE, false),
    PEACH("Peach", Colour.PEACH, false),
    RUSTY("Rusty", Colour.RUST, false),
    SHERLOCK("Sherlock", Colour.BROWN, false),
    WATSON("Watson", Colour.VENOM, false);

    private final String label;
    private final Colour colour;
    private final Type type = Type.CHARACTER;
    private final boolean isDefault;

    Character(String label, Colour colour, boolean isDefault) {
        this.label = label;
        this.colour = colour;
        this.isDefault = isDefault;
    }

    /**
     * The colour associated with the character
     *
     * @return The colour associated with the character
     */
    public Colour colour() {
        return colour;
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
