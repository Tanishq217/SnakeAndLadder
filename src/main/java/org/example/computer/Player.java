package org.example.computer;

import java.util.UUID;

public class Player {
    private final String id;
    private final String name;
    private int position;
    private int consecutiveSixes;
    private boolean skipNextTurn;

    public Player(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.position = 0;
        this.consecutiveSixes = 0;
        this.skipNextTurn = false;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getConsecutiveSixes() {
        return consecutiveSixes;
    }

    public boolean isSkipNextTurn() {
        return skipNextTurn;
    }


    public void setPosition(int position) {
        this.position = position;
    }

    public void setConsecutiveSixes(int consecutiveSixes) {
        this.consecutiveSixes = consecutiveSixes;
    }

    public void setSkipNextTurn(boolean skipNextTurn) {
        this.skipNextTurn = skipNextTurn;
    }

    @Override
    public String toString() {
        return name + " (Position: " + position + ")";
    }
}