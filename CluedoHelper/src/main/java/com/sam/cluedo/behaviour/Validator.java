package com.sam.cluedo.behaviour;

import com.sam.cluedo.Player;
import com.sam.cluedo.cards.Card;
import com.sam.cluedo.exception.ExceptionMessageFormatter;
import com.sam.cluedo.exception.UnexpectedBehaviourException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.sam.cluedo.behaviour.ReasonOfFailure.*;
import static com.sam.cluedo.behaviour.Rules.*;

/**
 * Validates all the rules of the game
 */
public class Validator {


    /**
     * Validates if the number of cards matches the rules
     *
     * @param cards Collection with the cards
     * @return The reasons of failure, empty if everything is ok
     */
    private static Map<ReasonOfFailure, String> numberOfCards(final Set<Card> cards) {
        final Map<ReasonOfFailure, String> reasonsMap = new HashMap<>();
        final int numberOfCards = cards.size();
        maxMinValidator(reasonsMap, NUMBER_OF_CARDS, numberOfCards, GAME_CARDS, GAME_CARDS);
        return reasonsMap;
    }

    /**
     * Validates if the number of players matches the rules
     *
     * @param players Collection with the players
     * @return The reasons of failure, empty if everything is ok
     */
    private static Map<ReasonOfFailure, String> numberOfPlayers(final Set<Player> players) {
        final Map<ReasonOfFailure, String> reasonsMap = new HashMap<>();
        final int numberOfPlayers = players.size();
        maxMinValidator(reasonsMap, NUMBER_OF_PLAYERS, numberOfPlayers, GAME_MAX_PLAYERS, GAME_MIN_PLAYERS);
        return reasonsMap;
    }

    /**
     * Validate if the number of cards per players is ok
     *
     * @param players Collection with the players
     * @return The reasons of failure, empty if everything is ok
     */
    private static Map<ReasonOfFailure, String> numberOfPlayerCards(final Set<Player> players) {
        final Map<ReasonOfFailure, String> reasonsMap = new HashMap<>();
        final int numberOfPlayers = players.size();

        if (numberOfPlayers == 3) {
            // When there are three players every player will have six cards
            for (Player player : players) {
                final int numberOfCards = player.deck().size();
                if (numberOfCards != 6) {
                    reasonsMap.put(PLAYER_NUMBER_OF_CARDS, "The player " + player.name() + " has " + numberOfCards +
                            " and should have six cards");
                    return reasonsMap;
                }
            }
        } else if (numberOfPlayers == 4) {
            // When there are four players two of them will have four cards and the others two will have 5 cards
            int playersWithFourCards = 0;
            int playersWithFiveCards = 0;

            for (Player player : players) {
                int numberOfCards = player.deck().size();
                if (numberOfCards == 4) {
                    playersWithFourCards++;
                } else if (numberOfCards == 5) {
                    playersWithFiveCards++;
                } else {
                    reasonsMap.put(PLAYER_NUMBER_OF_CARDS, "The player " + player.name() + " has " + numberOfCards +
                            " and should have four or five cards");
                }
            }
            if (playersWithFiveCards != 2 || playersWithFourCards != 2) {
                reasonsMap.put(PLAYER_NUMBER_OF_CARDS, "When there are four players, two of them should have four " +
                        "cards, and the other two should have five cards, instead we got " + playersWithFourCards +
                        " players with four cards and " + playersWithFiveCards + " with five cards");
                return reasonsMap;
            }
        } else if (numberOfPlayers == 5) {
            // When there are five players two of them will have three cards and the others three will have 4 cards
            int playersWithThreeCards = 0;
            int playersWithFourCards = 0;

            for (Player player : players) {
                int numberOfCards = player.deck().size();
                if (numberOfCards == 3) {
                    playersWithThreeCards++;
                } else if (numberOfCards == 4) {
                    playersWithFourCards++;
                } else {
                    reasonsMap.put(PLAYER_NUMBER_OF_CARDS, "The player " + player.name() + " has " + numberOfCards +
                            " and should have three or four cards");
                    return reasonsMap;
                }
            }
            if (playersWithThreeCards != 2 || playersWithFourCards != 3) {
                reasonsMap.put(PLAYER_NUMBER_OF_CARDS, "When there are five players, two of them should have three " +
                        "cards, and the other three should have four cards, instead we got " + playersWithThreeCards +
                        " players with three cards and " + playersWithFourCards + " with four cards");
                return reasonsMap;
            }
        } else if (numberOfPlayers == 6) {
            // When there are six players every player will have three cards
            for (Player player : players) {
                final int numberOfCards = player.deck().size();
                if (numberOfCards != 3) {
                    reasonsMap.put(PLAYER_NUMBER_OF_CARDS, "The player " + player.name() + " has " + numberOfCards +
                            " and should have three cards");
                    return reasonsMap;
                }
            }
        } else {
            // Program shouldn't be able to get to this statement
            String message = ExceptionMessageFormatter.message(Validator.class, "Program shouldn't be able to get to this statement");
            throw new UnexpectedBehaviourException("Program shouldn't be able to get to this statement");
        }


        return reasonsMap;
    }


    /**
     * Util method to validate a rule that includes a min and a max value
     *
     * @param reasonsMap The map with the reasons of failure
     * @param rule       The rule to validate
     * @param size       The size to validate
     * @param max        The max size supported
     * @param min        The min size supported
     */
    private static void maxMinValidator(final Map<ReasonOfFailure, String> reasonsMap,
                                        final ReasonOfFailure rule,
                                        final int size,
                                        final int max,
                                        final int min) {
        if (size > max) {
            reasonsMap.put(rule, "Size " + size + " is greater than the max supported: " + max);
        } else if (size < min) {
            reasonsMap.put(rule, "Size " + size + " is less than the min supported: " + min);
        }
    }

}
