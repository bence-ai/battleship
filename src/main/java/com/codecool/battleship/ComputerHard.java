package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;
import com.codecool.battleship.board.Square;
import com.codecool.battleship.board.SquareStatus;

import java.util.ArrayList;
import java.util.Random;

public class ComputerHard extends ComputerPlayer  {
    public ComputerHard(Board board, String name){
        super(board, name);
    }

    // creates ComputerHard instance and place it's ships to it's board

    public static Player withBoardSize(String name, int size) {
        Board board = BoardFactory.randomPlacement(size);
        return new ComputerHard(board, name);
    }

    // overrides shoot from ComputerPlayer but if lands a shot to a ship part, it will shoot it until it sinks.

    @Override
    public void shoot(Board board) {
        Random rand = new Random();
        while (true) {
            ArrayList<Square> sunkList = sunkCoordinateException(board);
            ArrayList<Square> predictList = predictionForHit(board);
            if (predictList.isEmpty()) {
                basicMove(board, sunkList);
                break;
            }
            int randomIndex = rand.nextInt(predictList.size());
            if (!sunkList.contains(predictList.get(randomIndex)) &&
                    predictList.get(randomIndex).GetSquareStatus() == SquareStatus.SHIP) {
                if (board.isShootOkay(predictList.get(randomIndex).getX(),predictList.get(randomIndex).getY()) ){
                    board.markShoot(predictList.get(randomIndex).getX(),predictList.get(randomIndex).getY());
                    break;
                }
            }
        }board.isShipSunk();
    }

    // overrides basicMove from ComputerPlayer, but uses diagonal searching for higher chance

    @Override
    public void basicMove(Board board, ArrayList<Square> sunkList) {
        Random rand = new Random();
        ArrayList<Square> diagonalSquaresList = new ArrayList<>();
        for (int i = 0; i < board.getOcean().length; i++) {
            for (int j = 0; j < board.getOcean().length; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    diagonalSquaresList.add(board.getOcean()[i][j]);
                }
                if (i % 2 == 1 && j % 2 == 1) {
                    diagonalSquaresList.add(board.getOcean()[i][j]);
                }
            }
        }
        while(true){
            int randomIndex = rand.nextInt(diagonalSquaresList.size());
            Square diagonalSquare = diagonalSquaresList.get(randomIndex);
            if (board.isShootOkay(diagonalSquare.getX(),diagonalSquare.getY()) && !sunkList.contains(diagonalSquare)) {
                board.markShoot(diagonalSquare.getX(),diagonalSquare.getY());
                break;
            }
        }
    }
}
