package org.example.computer;

public interface MoveStrategy {

    boolean processRoll(Player player, int diceValue);


    void resetState(Player player);
}