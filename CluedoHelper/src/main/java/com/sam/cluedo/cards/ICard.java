package com.sam.cluedo.cards;

import com.sam.cluedo.base.NotNull;
import com.sam.cluedo.base.Typename;

/**
 * Define the behaviour that a card should follow
 */
public interface ICard {


    /**
     * The label of the card
     *
     * @return The label of the card
     */
    String label();


    /**
     * The type of the card
     *
     * @return The type of the card
     */
    Type type();


    /**
     * This field defines which cards will be available to a game by default
     *
     * @return If the card is default or not
     */
    boolean isDefault();


    /**
     * Checks if the parameter is the same class of this class
     *
     * @param clazz The class to compare
     * @return If the parameter is the same class of this class
     */
    default boolean is(final Class<ICard> clazz) {
        NotNull.required(clazz, this.getClass(), "is()");
        return Typename.get(clazz).equals(type().label());
    }

    /**
     * Constructs the string value of the card
     *
     * @return The string value of the card
     */
    default String stringValue() {
        return label() + " " + type();
    }
}
