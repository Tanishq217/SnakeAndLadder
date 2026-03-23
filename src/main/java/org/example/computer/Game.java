package org.example.computer;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    private final Board board;
    private final Queue<Player> players;
    private final Dice dice;
    private final MoveStrategy moveStrategy;
    private Player currentPlayer;
    private boolean gameActive;
    private Player winner;

    public Game(Board board, Queue<Player> players, Dice dice, MoveStrategy moveStrategy) {
        this.board = board;
        this.players = new LinkedList<>(players);
        this.dice = dice;
        this.moveStrategy = moveStrategy;
        this.gameActive = true;
        this.currentPlayer = null;
        this.winner = null;
    }

    public void start() {
        System.out.println("Game Started!");
        System.out.println("Board size: " + board.getSize());
        System.out.println("Players: " + players.size());
        System.out.println("Difficulty: " + (moveStrategy.getClass().getSimpleName().equals("EasyMoveStrategy") ? "Easy" : "Hard"));
        System.out.println("----------------------------------------");

        play();
    }

    private void play() {
        while (gameActive) {
            currentPlayer = players.poll();

            if (currentPlayer.isSkipNextTurn()) {
                System.out.println(currentPlayer.getName() + " skips this turn!");
                currentPlayer.setSkipNextTurn(false);
                players.offer(currentPlayer);
                continue;
            }

            processTurn(currentPlayer);

            if (currentPlayer.getPosition() == board.getSize()) {
                winner = currentPlayer;
                gameActive = false;
                System.out.println("\n🎉 " + winner.getName() + " wins the game! 🎉");
                break;
            }

            players.offer(currentPlayer);
        }
    }

    private void processTurn(Player player) {
        System.out.println("\n" + player.getName() + "'s turn (Position: " + player.getPosition() + ")");

        int roll = dice.roll();
        System.out.println("Rolled: " + roll);

        int newPosition = player.getPosition() + roll;

        if (newPosition > board.getSize()) {
            System.out.println("Need exactly " + (board.getSize() - player.getPosition()) + " to win!");
            System.out.println("Stay at position " + player.getPosition());
            moveStrategy.processRoll(player, roll);
            return;
        }

        player.setPosition(newPosition);
        System.out.println("Moved to position: " + newPosition);

        int finalPosition = board.getNewPosition(newPosition);
        if (finalPosition != newPosition) {
            if (board.hasSnake(newPosition)) {
                System.out.println("🐍 Oops! Snake bites! Sliding down from " + newPosition + " to " + finalPosition);
            } else if (board.hasLadder(newPosition)) {
                System.out.println("🪜 Lucky! Climbing ladder from " + newPosition + " to " + finalPosition);
            }
            player.setPosition(finalPosition);
        }

        System.out.println("Final position: " + player.getPosition());

        boolean getsAnotherTurn = moveStrategy.processRoll(player, roll);
        if (getsAnotherTurn) {
            System.out.println(player.getName() + " gets another turn!");
            processTurn(player);
        }
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isGameActive() {
        return gameActive;
    }
}