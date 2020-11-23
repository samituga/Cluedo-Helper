package com.sam.cluedo.cards;

public class Unknown implements ICard {

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
