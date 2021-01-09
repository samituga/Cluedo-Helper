package com.sam.cluedo.game.player;

import com.sam.cluedo.game.cards.ICard;
import com.sam.cluedo.game.Round;
import com.sam.cluedo.game.State;

import java.util.HashSet;
import java.util.Set;

/**
 * This class will store the state of a relation of a {@link Player}
 * and a {@link ICard} storing the times that a given player asked for
 * a given card and how many times the same player answered when someone asked for a card
 * it will also store the {@link State} and the probability of the player to contain that card
 */
class CardStatistics {


    /**
     * The list of rounds that the player made a suspicion about this card
     */
    private final Set<Round> asked;

    /**
     * The list of rounds that the player answered to suspicion about this card
     */
    private final Set<Round> answered;


    /**
     * The probability of the player to own this card
     */
    private int owningProbability;


    /**
     * The state of this card
     */
    private State state;

    public CardStatistics(final int owningProbability) {
        this.asked = new HashSet<>();
        this.answered = new HashSet<>();
        checkProbability(owningProbability);
        this.owningProbability = owningProbability;
        updateState();
    }


    /**
     * Adds a round to the asked list
     *
     * @param round The round that the player asked
     */
    public void asked(final Round round) {
        asked.add(round);
    }

    /**
     * Adds a round to the answered list
     *
     * @param round The round that the player answered
     */
    public void answered(final Round round) {
        answered.add(round);
    }

    public void updateOwningProbability(final int owningProbability) {
        checkProbability(owningProbability);
        updateState();
        this.owningProbability = owningProbability;
    }

    /**
     * Util method to verify if the probability number is ok
     *
     * @param probability The probability to own this card
     * @throws UnsupportedOperationException if probability is higher than 100 or lower than 0
     */
    private void checkProbability(final int probability) {
        if (probability > 100) {
            // TODO: 24/11/20 log
            throw new UnsupportedOperationException("Probability can't be higher than 100");
        } else if (probability < 0) {
            // TODO: 24/11/20 log
            throw new UnsupportedOperationException("Probability can't be lower than 0");
        }
    }

    /**
     * Updates the state
     */
    private void updateState() {
        if (owningProbability == 100) {
            state = State.HAS;
        } else if (owningProbability == 0) {
            state = State.HAS_NOT;
        } else {
            state = State.UNKNOWN;
        }
    }

    /**
     * Getter to the asked collection
     *
     * @return The asked collection
     */
    public Set<Round> asked() {
        return asked;
    }

    /**
     * Getter to the answered collection
     *
     * @return The answered collection
     */
    public Set<Round> answered() {
        return answered;
    }

    /**
     * Getter to the probability of owning this card
     *
     * @return The probability of owning this card
     */
    public int probability() {
        return owningProbability;
    }

    /**
     * Getter to the state of the card
     *
     * @return The state of the card
     */
    public State sState() {
        return state;
    }
}
