package com.sam.cluedo.game.player;

import com.sam.cluedo.base.NotEmpty;
import com.sam.cluedo.base.NotNull;
import com.sam.cluedo.exception.UnexpectedBehaviourException;
import com.sam.cluedo.game.Round;
import com.sam.cluedo.game.cards.Character;
import com.sam.cluedo.game.cards.ICard;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class will act as a wrapper to the player class
 * It will serve to match a player with all the cards and display
 * the probability of the player to own that card
 */
public class PlayerWrapper { // TODO: 23/11/20 Keep on working with this class

    private final Player player;
    private final Map<ICard, CardStatistics> cardStatisticsMap;

    public PlayerWrapper(final Player player, final Map<ICard, CardStatistics> cardStatisticsMap) {
        NotEmpty.required(cardStatisticsMap, this, "ctor");
        NotNull.required(player, this, "ctor");

        this.player = player;
        this.cardStatisticsMap = cardStatisticsMap;
    }

    /**
     * Adds a round to the asked list of each card
     *
     * @param suspectedCards The suspected cards
     * @param round          The round
     */
    public void addAsked(final List<ICard> suspectedCards, final Round round) {
        NotNull.required(suspectedCards, this, "addAsked()");
        NotNull.required(round, this, "addAsked()");
        for (ICard suspected : suspectedCards) {
            if (!cardStatisticsMap.containsKey(suspected)) {
                // TODO: 24/11/20 log
                throw new UnexpectedBehaviourException("Card should exist in the map");
            }
            final CardStatistics cardStatistics = cardStatisticsMap.get(suspected);
            cardStatistics.asked(round);
        }
    }

    /**
     * Adds a round to the answered list of each card
     *
     * @param suspectedCards The suspected cards
     * @param round          The round
     */
    public void addAnswered(final List<ICard>  suspectedCards, final Round round) {
        NotEmpty.required(suspectedCards, this, "addAnswered()");
        NotNull.required(round, this, "addAnswered()");
        for (ICard suspected : suspectedCards) {
            if (!cardStatisticsMap.containsKey(suspected)) {
                // TODO: 24/11/20 log
                throw new UnexpectedBehaviourException("Card should exist in the map");
            }
            final CardStatistics cardStatistics = cardStatisticsMap.get(suspected);
            cardStatistics.answered(round);
        }
    }

    /**
     * Updates the probability of owning a specific card
     *
     * @param suspected         The suspected card
     * @param owningProbability The probability of owning the suspected card
     */
    public void updateCardOwningProbability(final ICard suspected, final int owningProbability) {
        NotNull.required(suspected, this, "updateCardOwningProbability()");
        if (!cardStatisticsMap.containsKey(suspected)) {
            // TODO: 24/11/20 log
            throw new UnexpectedBehaviourException("Card should exist in the map");
        }
        final CardStatistics cardStatistics = cardStatisticsMap.get(suspected);
        cardStatistics.updateOwningProbability(owningProbability);
    }

    /**
     * Check the position to play of this player
     *
     * @return The position to play of this player
     */
    public int playPosition() {
        return player.playPosition();
    }

    /**
     * Getter to the deck of this player
     *
     * @return The deck of this player
     */
    public Set<ICard> deck() {
        return player.deck();
    }

    /**
     * Getter to the name of this player
     *
     * @return The name of this player
     */
    public String name() {

        return player.name();
    }

    /**
     * Getter to the character associated with this player
     *
     * @return The character associated with this player
     */
    public Character character() {
        return player.character();
    }

    /**
     * Getter to the card statistics map of this player
     *
     * @return The card statistics map of this player
     */
    public Map<ICard, CardStatistics> cardStatisticsMap() {
        return cardStatisticsMap;
    }
}
