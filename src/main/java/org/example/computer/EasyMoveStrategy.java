package org.example.computer;

public class EasyMoveStrategy implements MoveStrategy {

    @Override
    public boolean processRoll(Player player, int diceValue) {
        if (diceValue == 6) {
            System.out.println("Rolled a 6! " + player.getName() + " gets another turn!");
            return true;
        }
        return false;
    }

    @Override
    public void resetState(Player player) {
    }
}