package com.sam.cluedo.game.behaviour;

import com.sam.cluedo.game.cards.ICard;
import com.sam.cluedo.exception.UnsupportedBehaviourException;
import com.sam.cluedo.game.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.sam.cluedo.game.behaviour.ReasonOfFailure.*;
import static com.sam.cluedo.game.behaviour.Rules.*;

/**
 * Validates all the rules of the game
 */
public class Validator {


    /**
     * Validates if the number of ICards matches the rules
     *
     * @param ICards Collection with the ICards
     * @return The reasons of failure, empty if everything is ok
     */
    private static Map<ReasonOfFailure, String> numberOfCards(final Set<ICard> ICards) {
        final Map<ReasonOfFailure, String> reasonsMap = new HashMap<>();
        final int numberOfCards = ICards.size();
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
     * Validate if the number of ICards per players is ok
     *
     * @param players Collection with the players
     * @return The reasons of failure, empty if everything is ok
     */
    private static Map<ReasonOfFailure, String> numberOfPlayerCards(final Set<Player> players) {
        final Map<ReasonOfFailure, String> reasonsOfFailure = new HashMap<>();
        final int numberOfPlayers = players.size();

        if (numberOfPlayers == 3) {
            // When there are three players every player will have six ICards
            for (Player player : players) {
                final int numberOfCards = player.deck().size();
                if (numberOfCards != 6) {
                    reasonsOfFailure.put(PLAYER_NUMBER_OF_CARDS, "The player " + player.name() + " has " + numberOfCards +
                            " and should have six ICards");
                    return reasonsOfFailure;
                }
            }
        } else if (numberOfPlayers == 4) {
            // When there are four players two of them will have four ICards and the others two will have 5 ICards
            int playersWithFourCards = 0;
            int playersWithFiveCards = 0;

            for (Player player : players) {
                int numberOfCards = player.deck().size();
                if (numberOfCards == 4) {
                    playersWithFourCards++;
                } else if (numberOfCards == 5) {
                    playersWithFiveCards++;
                } else {
                    reasonsOfFailure.put(PLAYER_NUMBER_OF_CARDS, "The player " + player.name() + " has " + numberOfCards +
                            " and should have four or five ICards");
                }
            }
            if (playersWithFiveCards != 2 || playersWithFourCards != 2) {
                reasonsOfFailure.put(PLAYER_NUMBER_OF_CARDS, "When there are four players, two of them should have four " +
                        "ICards, and the other two should have five ICards, instead we got " + playersWithFourCards +
                        " players with four ICards and " + playersWithFiveCards + " with five ICards");
                return reasonsOfFailure;
            }
        } else if (numberOfPlayers == 5) {
            // When there are five players two of them will have three ICards and the others three will have 4 ICards
            int playersWithThreeCards = 0;
            int playersWithFourCards = 0;

            for (Player player : players) {
                int numberOfCards = player.deck().size();
                if (numberOfCards == 3) {
                    playersWithThreeCards++;
                } else if (numberOfCards == 4) {
                    playersWithFourCards++;
                } else {
                    reasonsOfFailure.put(PLAYER_NUMBER_OF_CARDS, "The player " + player.name() + " has " + numberOfCards +
                            " and should have three or four ICards");
                    return reasonsOfFailure;
                }
            }
            if (playersWithThreeCards != 2 || playersWithFourCards != 3) {
                reasonsOfFailure.put(PLAYER_NUMBER_OF_CARDS, "When there are five players, two of them should have three " +
                        "ICards, and the other three should have four ICards, instead we got " + playersWithThreeCards +
                        " players with three ICards and " + playersWithFourCards + " with four ICards");
                return reasonsOfFailure;
            }
        } else if (numberOfPlayers == 6) {
            // When there are six players every player will have three ICards
            for (Player player : players) {
                final int numberOfCards = player.deck().size();
                if (numberOfCards != 3) {
                    reasonsOfFailure.put(PLAYER_NUMBER_OF_CARDS, "The player " + player.name() + " has " + numberOfCards +
                            " and should have three ICards");
                    return reasonsOfFailure;
                }
            }
        } else {
            // Program shouldn't be able to get to this statement
            throw new UnsupportedBehaviourException("Invalid number of players");
        }


        return reasonsOfFailure;
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
            reasonsMap.put(rule, size + " is greater than the max supported: " + max);
        } else if (size < min) {
            reasonsMap.put(rule, size + " is less than the min supported: " + min);
        }
    }

}
