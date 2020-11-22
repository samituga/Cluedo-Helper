package com.sam.cluedo;

import com.sam.cluedo.cards.Card;
import com.sam.cluedo.cards.Character;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * This class defines the player
 */
public class Player {

    // TODO: 22/11/20 Package for this class

    private final Set<Card> deck;
    private final String name;
    private final Character character;
    private final int playPosition;


    /**
     * Use this constructor when the name of the player is not important
     * The player name will be the name of the character
     *
     * @param character    The character associated with the player
     * @param playPosition The position that the player will play
     */
    public Player(final Character character, final int playPosition) {
        this(character.label(), character, playPosition);
    }

    /**
     * @param name         The name of the player
     * @param character    The character associated with the player
     * @param playPosition The position that the player will play
     */
    public Player(final String name, final Character character, final int playPosition) {
        deck = new HashSet<>();
        this.name = name;
        this.character = character;
        this.playPosition = playPosition;
    }


    /**
     * Adds a card to the deck of the player
     *
     * @param card The card to add
     * @return True if the card didn't exist in the deck
     */
    private boolean addCard(Card card) {
        return deck.add(card);
    }


    /**
     * Removes a card from the deck of the player
     *
     * @param card The card to remove
     * @return True if the card existed in the deck
     */
    private boolean removeCard(Card card) {
        return deck.remove(card);
    }

    /**
     * Check the position to play of this player
     *
     * @return The position to play of this player
     */
    public int playPosition() {
        return playPosition;
    }

    /**
     * Getter to the deck of the player
     *
     * @return The deck of the player
     */
    public Set<Card> deck() {
        return deck;
    }

    /**
     * Getter to the name of the player
     *
     * @return The name of the player
     */
    public String name() {
        return name;
    }

    /**
     * Getter to the character associated with the player
     *
     * @return The character associated with the player
     */
    public Character character() {
        return character;
    }

    @Override
    public String toString() {
        return "Player{" +
                "cards=" + deck +
                ", name='" + name + '\'' +
                ", playPosition=" + playPosition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playPosition == player.playPosition &&
                Objects.equals(deck, player.deck) &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deck, name, playPosition);
    }
}
