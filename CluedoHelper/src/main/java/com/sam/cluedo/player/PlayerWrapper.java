package com.sam.cluedo.player;

import com.sam.cluedo.game.CardStatistics;
import com.sam.cluedo.base.NotEmpty;
import com.sam.cluedo.base.NotNull;
import com.sam.cluedo.cards.ICard;

import java.util.Map;

/**
 * This class will act as a wrapper to the player class
 * It will serve to match a player with all the cards and display,
 * the probability of the player to contain that card
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


    public Player player() {
        return player;
    }

    public Map<ICard, CardStatistics> cardStatisticsMap() {
        return cardStatisticsMap;
    }
}
