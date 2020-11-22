package com.sam.cluedo.cards;

/**
 * Define the behaviour that a card should follow
 */
public interface Card {


    /**
     * The label of the card
     * @return The label of the card
     */
    String label();


    /**
     * The type of the card
     * @return The type of the card
     */
    Type type();


    /**
     * This field defines which cards will be available to a game by default
     * @return If the card is default or not
     */
    boolean isDefault();

}
