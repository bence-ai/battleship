package com.codecool.battleship;

import com.codecool.battleship.console.Display;
import com.codecool.battleship.console.Input;

public class Game {

    private Player player;
    private Player opponent;
    private boolean isPlayerOne = true;
    Display display = new Display();
    Input input = new Input();



    // Game constructor
    public Game(Player playerOne, Player playerTwo) {
        this.player = playerOne;
        this.opponent = playerTwo;
    }

    public void playerChanger(){
        Player temp = player;
        player = opponent;
        opponent = temp;
    }


    public void play() {
        boolean isGame = true;
        while (isGame) {
            display.printRound(player);
        }
    }


    private void gameOver(String name) {
        System.out.println(name + " is the winner!");
    }

}
