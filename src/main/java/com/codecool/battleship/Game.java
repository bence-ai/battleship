package com.codecool.battleship;

import com.codecool.battleship.console.Display;
import com.codecool.battleship.console.Input;

import java.util.concurrent.TimeUnit;

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
        while (true) {
//            display.printBoard(opponent.board.toString());
            display.printRound(player);
            player.shoot(opponent.board);
            try {
//                display.printBoard(opponent.board.toString());
                display.getReady(opponent);
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e){
                display.error(e.toString());
            } if (!opponent.isAlive()) {
                break;
            } playerChanger();


        }
        display.printWinner(player);
    }




}
