package org.example.computer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final int size;
    private final Map<Integer, Integer> snakes; // start -> end
    private final Map<Integer, Integer> ladders; // start -> end

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();

        for (Snake snake : snakes) {
            this.snakes.put(snake.getStart(), snake.getEnd());
        }


        for (Ladder ladder : ladders) {
            this.ladders.put(ladder.getStart(), ladder.getEnd());
        }
    }

    public int getSize() {
        return size;
    }

    public int getNewPosition(int currentPosition) {

        if (snakes.containsKey(currentPosition)) {
            return snakes.get(currentPosition);
        }


        if (ladders.containsKey(currentPosition)) {
            return ladders.get(currentPosition);
        }

        return currentPosition;
    }

    public boolean hasSnake(int position) {
        return snakes.containsKey(position);
    }

    public boolean hasLadder(int position) {
        return ladders.containsKey(position);
    }

    public int getSnakeEnd(int start) {
        return snakes.getOrDefault(start, start);
    }

    public int getLadderEnd(int start) {
        return ladders.getOrDefault(start, start);
    }
}