package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.Ship;
import com.codecool.battleship.board.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerEasy extends ComputerPlayer {
    public ComputerEasy(int size){
        super(new Board(size));
    }

    // chooses a random square which is empty or a ship and returns its coordinates in an int[] array.
    @Override
    public void shoot(Board board) {
        Random rand = new Random();
        while (true){
            int randXCoordinate = rand.nextInt(5);
            int randYCoordinate = rand.nextInt(5);

            if (board.isShootOkay(randXCoordinate,randYCoordinate)) {
                board.markShoot(randXCoordinate,randYCoordinate);
                break;
            }
        }
//        for (Board squaresRow: board) {
//            for (Square squares: squaresRow) {
//                if(squares.getSquareStatus() == '.' || squares.getSquareStatus() == 'O') {
//                    nonShotSquares.add(squares);
//                }
//            }
//        }
//        int index = (int) (Math.random() * nonShotSquares.size());
//        Square easyShoot = nonShotSquares.get(index);
//        int [] shootCoordinate = new int[2];
//        shootCoordinate[0] = easyShoot.getX();
//        shootCoordinate[1] = easyShoot.getY();
//        return shootCoordinate; // or Square instance depends on what we need...;
        }
}
