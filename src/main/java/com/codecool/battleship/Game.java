package com.codecool.battleship;

public class Game {

    private final Player playerOne;
    private final Player playerTwo;
    private boolean isPlayerOne = true;

    // Game constructor
    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    private void gameOver(String name) {
        System.out.println(name + " is the winner!");
    }

}
