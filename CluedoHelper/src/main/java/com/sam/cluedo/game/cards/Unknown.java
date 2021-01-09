package com.sam.cluedo.game.cards;

public class Unknown implements ICard {     // TODO: 24/11/20 Use this or the Unknown static property?


    @Override
    public String label() {
        return "Unknown";
    }

    @Override
    public Type type() {
        return Type.UNKNOWN;
    }

    @Override
    public boolean isDefault() {
        return false;
    }
}
