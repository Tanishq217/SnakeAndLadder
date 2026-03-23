# Snake and Ladder Game

## Problem Statement
Design and implement a classic Snake and Ladder game that allows multiple players to play on a board with snakes and ladders. The game should be extensible, follow SOLID principles, and support different difficulty levels with varying game rules.

## Requirements

### Core Requirements

#### Board
The game should have a board with configurable size

#### Players
There should be players who make turns  
Support multiple players (2-4 players)

#### Dice
The game should use a dice to generate random numbers for movement

#### Snakes and Ladders
The board should have snakes and ladders at specific positions

#### Turn Management
There should be a queue of players to manage turns in round-robin fashion

#### Movement
The game should handle the movement of players based on dice rolls

#### Snake and Ladder Logic
The game should handle players landing on snakes or ladders

#### Winner
There should be a way to determine the winner when a player reaches the final square

## Design Requirements

### Simplicity
The design should be kept simple and not over-engineered

### SOLID Principles
The implementation should follow SOLID principles where applicable

### Extensibility
The design should be extensible for potential future requirements

## Difficulty Levels

### Easy Version
Allows continuous turns on rolling sixes  
Player gets an extra turn immediately after rolling a 6

### Hard Version
Player gets an extra turn on rolling a 6  
Player skips a turn after three consecutive sixes  
Track consecutive sixes for each player

## Additional Requirements

### Game Loop
The implementation should be able to handle the game logic in a main loop

### End Condition
The game should handle the end condition (reaching the final square)

### Entities
The design should include major entities like Game, Board, Player, Dice, Snake, and Ladder

### Design Patterns
Students should consider using design patterns where appropriate, such as the Strategy pattern for move-making

### Thread Safety
Students should consider thread-safety and concurrency issues, even if not explicitly required

### Documentation
Students should provide a well-created design diagram and a description of their code

## Expected Deliverables
Complete Java implementation with all classes  
Design diagram showing class relationships  
README file with problem statement and implementation details  
Code that follows SOLID principles and uses appropriate design patterns