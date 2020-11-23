package com.sam.cluedo.game;

import com.sam.cluedo.base.NotNull;
import com.sam.cluedo.cards.ICard;
import com.sam.cluedo.cards.Character;
import com.sam.cluedo.cards.Room;
import com.sam.cluedo.cards.Weapon;
import com.sam.cluedo.exception.ExceptionMessageFormatter;
import com.sam.cluedo.player.Player;

import java.util.Objects;

/**
 * This class will store the state of what happened in every round
 */
public class Round {

    private final int number;
    private final Player asked;
    private final Player answered;
    private final Character character;
    private final Weapon weapon;
    private final Room room;
    private final ICard showedCard;


    /**
     * @param number     The number of the round
     * @param asked      The player who made the suspicion
     * @param answered   The player who answered, can be null if no one answered
     * @param character  The suspected character
     * @param weapon     The suspected weapon
     * @param room       The suspected room
     * @param showedCard The card shown, null if no one answered
     */
    public Round(final int number,
                 final Player asked,
                 final Player answered,
                 final Character character,
                 final Weapon weapon,
                 final Room room,
                 final ICard showedCard) {
        final String where = "ctor";
        NotNull.required(this, asked, where);
        NotNull.required(this, character, where);
        NotNull.required(this, weapon, where);
        NotNull.required(this, room, where);

        if (answered != null) {
            NotNull.required(this, showedCard, where);
        }

        if (number < 0) {
            final String exceptionMessage = ExceptionMessageFormatter.message(
                    this,
                    "validate()",
                    "round number can't be lower than 0"
            );
            throw new UnsupportedOperationException(exceptionMessage);
        }

        this.number = number;
        this.asked = asked;
        this.answered = answered;
        this.character = character;
        this.weapon = weapon;
        this.room = room;
        this.showedCard = showedCard;
    }


    /**
     * @return A description of this round
     */
    public String roundDescription() {
        return "At the round number " + number + " the player " + asked.name() +
                " made a suspicion of the character " + character.label() + " that used the weapon " +
                weapon.label() + " in the room " + room.label() + (answered != null ? ", the player " +
                answered.name() + " answered and showed the card " + showedCard.label() : ", no one answered");
    }

    /**
     * @return Getter to the round number
     */
    public int number() {
        return number;
    }

    /**
     * @return Getter to the player who made the suspicion
     */
    public Player asked() {
        return asked;
    }

    /**
     * @return Getter to the player who answered to the suspicion
     */
    public Player answered() {
        return answered;
    }

    /**
     * @return Getter to the suspected character
     */
    public Character character() {
        return character;
    }

    /**
     * @return Getter to the suspected weapon
     */
    public Weapon weapon() {
        return weapon;
    }

    /**
     * @return Getter to the suspected room
     */
    public Room room() {
        return room;
    }

    /**
     * @return Getter to the shown card
     */
    public ICard showedCard() {
        return showedCard;
    }

    @Override
    public String toString() {
        return "Round{" +
                "number=" + number +
                ", asked=" + asked +
                ", answered=" + answered +
                ", character=" + character +
                ", weapon=" + weapon +
                ", room=" + room +
                ", showedCard=" + showedCard +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round that = (Round) o;
        return number == that.number &&
                asked.equals(that.asked) &&
                Objects.equals(answered, that.answered) &&
                character == that.character &&
                weapon == that.weapon &&
                room == that.room &&
                Objects.equals(showedCard, that.showedCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, asked, answered, character, weapon, room, showedCard);
    }
}
