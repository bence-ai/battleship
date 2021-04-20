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

//    // Play rounds
//    public void makesMove() {
//        boolean isGame = true;
//
//        while (isGame) {
//            if (isPlayerOne) {
//                playerOne.shoot(playerTwo.board, playerTwo.ships);
//                if (!playerTwo.isAlive()) {
//                    gameOver(playerOne.getName());
//                    isGame = false;
//                }
//            }
//            else {
//                playerTwo.shoot(playerOne.board, playerOne.ships);
//                if (!playerOne.isAlive()) {
//                    gameOver(playerTwo.getName());
//                    isGame = false;
//                }
//            }
//            isPlayerOne = !isPlayerOne;
//        }
//    }
    //
    private void gameOver(String name) {
        System.out.println(name + " is the winner!");
    }

}
