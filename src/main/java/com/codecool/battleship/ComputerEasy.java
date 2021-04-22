package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ComputerEasy extends ComputerPlayer {
    public ComputerEasy(Board board, String name){
        super(board, name);
    }

    // chooses a random square which is empty or a ship and changes its status to miss or hit.
    @Override
    public void shoot(Board board) {
        Random rand = new Random();
        while (true){
            int randXCoordinate = rand.nextInt(5);
            int randYCoordinate = rand.nextInt(5);

            if (board.isShootOkay(randXCoordinate,randYCoordinate)) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e){
                    System.out.println(e);
                }
                board.markShoot(randXCoordinate,randYCoordinate);
                break;
            }
        }
        board.isShipSunk();
    }

    // creates ComputerEasy instance and place it's ships to it's board

    public static Player withBoardSize(String name, int size) {
        Board board = BoardFactory.randomPlacement(size);
        return new ComputerEasy(board, name);
    }
}
