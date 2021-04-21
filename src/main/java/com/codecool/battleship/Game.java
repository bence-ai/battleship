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

<<<<<<< HEAD
    private void gameOver(String name) {
        System.out.println(name + " is the winner!");
=======

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
>>>>>>> e085b70270e47a6c3c329169a090824318d338ab
    }




}
