package org.example.computer;

public class HardMoveStrategy implements MoveStrategy {

    @Override
    public boolean processRoll(Player player, int diceValue) {
        if (diceValue == 6) {
            int consecutiveSixes = player.getConsecutiveSixes() + 1;
            player.setConsecutiveSixes(consecutiveSixes);

            if (consecutiveSixes == 3) {
                System.out.println("Three consecutive sixes! " + player.getName() + " loses next turn!");
                player.setSkipNextTurn(true);
                player.setConsecutiveSixes(0);
                return false;
            }

            System.out.println("Rolled a 6! " + player.getName() + " gets another turn!");
            return true;
        } else {
            player.setConsecutiveSixes(0);
            return false;
        }
    }

    @Override
    public void resetState(Player player) {
        player.setConsecutiveSixes(0);
        player.setSkipNextTurn(false);
    }
}