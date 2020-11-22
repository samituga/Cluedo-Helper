package com.sam.cluedo;

import com.sam.cluedo.cards.Card;

import java.util.HashSet;
import java.util.Set;

public class Player {

    private final Set<Card> cards;
    private final String name;
    private int playPosition;


    public Player(final String name, final int playPosition) {
        cards = new HashSet<Card>();
        this.name = name;
        this.playPosition = playPosition;
    }

    private boolean addCard(Card card) {
        return cards.add(card);
    }

    private boolean removeCard(Card card) {
        return cards.remove(card);
    }

    public int playPosition() {
        return playPosition;
    }

    public void playPosition(final int playPosition) {
        this.playPosition = playPosition;
    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "cards=" + cards +
                ", name='" + name + '\'' +
                ", playPosition=" + playPosition +
                '}';
    }
}
