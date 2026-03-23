package org.example.computer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Snake and Ladder Game ===\n");

        Scanner scanner = new Scanner(System.in);

        // Get game configuration from user
        System.out.println("Select difficulty:");
        System.out.println("1. Easy (Extra turn on 6)");
        System.out.println("2. Hard (3 consecutive sixes skips turn)");
        System.out.print("Enter choice (1 or 2): ");
        int difficultyChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter number of players (2-4): ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        List<String> playerNames = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for player " + (i + 1) + ": ");
            playerNames.add(scanner.nextLine());
        }

        System.out.println("\nUse default board configuration? (y/n): ");
        String useDefault = scanner.nextLine();

        // Create game components
        Board board;
        if (useDefault.equalsIgnoreCase("y")) {
            board = createDefaultBoard();
        } else {
            board = createCustomBoard(scanner);
        }

        Queue<Player> players = createPlayers(playerNames);
        Dice dice = new Dice(6);
        MoveStrategy strategy = (difficultyChoice == 1) ? new EasyMoveStrategy() : new HardMoveStrategy();

        // Create and start game
        Game game = new Game(board, players, dice, strategy);
        game.start();

        // Display game result
        if (game.getWinner() != null) {
            System.out.println("\n🏆 Game Over! Winner: " + game.getWinner().getName() + " 🏆");
        }

        scanner.close();
    }

    private static Board createDefaultBoard() {
        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(16, 6));
        snakes.add(new Snake(47, 26));
        snakes.add(new Snake(49, 11));
        snakes.add(new Snake(56, 53));
        snakes.add(new Snake(62, 19));
        snakes.add(new Snake(64, 60));
        snakes.add(new Snake(87, 24));
        snakes.add(new Snake(93, 73));
        snakes.add(new Snake(95, 75));
        snakes.add(new Snake(98, 78));

        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(1, 38));
        ladders.add(new Ladder(4, 14));
        ladders.add(new Ladder(9, 31));
        ladders.add(new Ladder(21, 42));
        ladders.add(new Ladder(28, 84));
        ladders.add(new Ladder(36, 44));
        ladders.add(new Ladder(51, 67));
        ladders.add(new Ladder(71, 91));
        ladders.add(new Ladder(80, 100));

        return new Board(100, snakes, ladders);
    }

    private static Board createCustomBoard(Scanner scanner) {
        System.out.print("Enter board size (default 100): ");
        int boardSize = scanner.nextInt();
        scanner.nextLine();

        List<Snake> snakes = new ArrayList<>();
        System.out.print("How many snakes? ");
        int numSnakes = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numSnakes; i++) {
            System.out.print("Enter snake " + (i+1) + " (start end): ");
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            scanner.nextLine();
            snakes.add(new Snake(start, end));
        }

        List<Ladder> ladders = new ArrayList<>();
        System.out.print("How many ladders? ");
        int numLadders = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numLadders; i++) {
            System.out.print("Enter ladder " + (i+1) + " (start end): ");
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            scanner.nextLine();
            ladders.add(new Ladder(start, end));
        }

        return new Board(boardSize, snakes, ladders);
    }

    private static Queue<Player> createPlayers(List<String> playerNames) {
        Queue<Player> players = new LinkedList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        return players;
    }
}