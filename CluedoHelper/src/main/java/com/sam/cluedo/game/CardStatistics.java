package com.sam.cluedo.game;

import com.sam.cluedo.exception.ExceptionMessageFormatter;

import java.util.HashSet;
import java.util.Set;

/**
 * This class will store the state of a relation of a {@link com.sam.cluedo.player.Player}
 * and a {@link com.sam.cluedo.cards.ICard} storing the times that a given player asked for
 * a given card and how many times the same player answered when someone asked for a card
 * it will also store the {@link State} and the probability of the player to contain that card
 */
public class CardStatistics {


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
    private int probability;


    /**
     * The state of this card
     */
    private State state;

    public CardStatistics(final int probability) {
        this.asked = new HashSet<>();
        this.answered = new HashSet<>();
        checkProbability(probability);
        this.probability = probability;
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

    /**
     * Changes the probability of owning this card
     *
     * @param probability The probability to own this card
     */
    public void owningProbability(final int probability) {
        checkProbability(probability);
        updateState();
        this.probability = probability;
    }

    /**
     * Util method to verify if the probability number is ok
     *
     * @param probability The probability to own this card
     * @throws UnsupportedOperationException if probability is higher than 100 or lower than 0
     */
    private void checkProbability(final int probability) {
        if (probability > 100) {
            String exceptionMessage = ExceptionMessageFormatter.message(
                    this,
                    "containProbability()",
                    "Probability can't be higher than 100"
            );
            throw new UnsupportedOperationException(exceptionMessage);
        } else if (probability < 0) {
            String exceptionMessage = ExceptionMessageFormatter.message(
                    this,
                    "containProbability()",
                    "Probability can't be lower than 0"
            );
            throw new UnsupportedOperationException(exceptionMessage);
        }
    }

    /**
     * Updates the state
     */
    private void updateState() {
        if (probability == 100) {
            state = State.HAS;
        } else if (probability == 0) {
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
        return probability;
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
