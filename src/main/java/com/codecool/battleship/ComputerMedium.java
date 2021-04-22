package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.Square;
import com.codecool.battleship.board.SquareStatus;

import java.util.ArrayList;
import java.util.Random;

public class ComputerMedium extends ComputerPlayer  {

    public ComputerMedium(int size){
        super(new Board(size));
    }
    @Override
    public void shoot(Board board) {
        Random rand = new Random();
        while (true) {
            ArrayList<Square> sunkList = sunkCoordinateException(board);
            ArrayList<Square> predictList = predictionForHit(board);
            if (predictList.isEmpty()) {
                basicMove(board);
                break;
            }
            int randomIndex = rand.nextInt(predictList.size());
            if (!sunkList.contains(predictList.get(randomIndex))) {
                if (board.isShootOkay(predictList.get(randomIndex).getX(),predictList.get(randomIndex).getY())){
                    board.markShoot(predictList.get(randomIndex).getX(),predictList.get(randomIndex).getY());
                    break;
                }
            }
        }
    }

    public ArrayList<Square> sunkCoordinateException(Board board) {
        ArrayList<Square> sunkExceptionList = new ArrayList<>();
        for (Square[] squareRows: board.getOcean()) {
            for (Square square: squareRows) {
                if (square.GetSquareStatus() == SquareStatus.SUNK) {
                    if(square.getX() -1 >= 0) {
                        sunkExceptionList.add(board.getOcean()[square.getX()-1][square.getY()]);
                    }
                    if (square.getX() +1 <= board.getOcean().length -1) {
                        sunkExceptionList.add(board.getOcean()[square.getX()+1][square.getY()]);
                    }
                    if (square.getY() -1 >= 0) {
                        sunkExceptionList.add(board.getOcean()[square.getX()][square.getY()-1]);
                    }
                    if (square.getY() +1 <= board.getOcean().length-1) {
                        sunkExceptionList.add(board.getOcean()[square.getX()][square.getY()+1]);
                    }
                    if (square.getX() -1 >= 0 && square.getY() -1 >= 0) {
                        sunkExceptionList.add(board.getOcean()[square.getX()-1][square.getY()-1]);
                    }
                    if (square.getX() +1 <= board.getOcean().length -1 && square.getY() +1 <= board.getOcean().length-1) {
                        sunkExceptionList.add(board.getOcean()[square.getX()+1][square.getY()+1]);
                    }
                }
            }
        }
        return sunkExceptionList;
    }


    public ArrayList<Square> predictionForHit(Board board) {
        ArrayList<Square> predictionForHit = new ArrayList<>();
        for (Square[] squareRows: board.getOcean()) {
            for (Square square: squareRows) {
                if (square.GetSquareStatus() == SquareStatus.HIT) {
                    if(square.getX() -1 >= 0 ) {
                        predictionForHit.add(board.getOcean()[square.getX()-1][square.getY()]);
                    }
                    if (square.getX() +1 <= board.getOcean().length -1) {
                        predictionForHit.add(board.getOcean()[square.getX()+1][square.getY()]);
                    }
                    if (square.getY() -1 >= 0) {
                        predictionForHit.add(board.getOcean()[square.getX()][square.getY()-1]);
                    }
                    if (square.getY() +1 <= board.getOcean().length-1) {
                        predictionForHit.add(board.getOcean()[square.getX()][square.getY()+1]);
                    }
                }
            }
        }
        return predictionForHit;
    }


    public void basicMove(Board board) {
        Random rand = new Random();
        while (true){
            int randXCoordinate = rand.nextInt(7);
            int randYCoordinate = rand.nextInt(7);

            if (board.isShootOkay(randXCoordinate,randYCoordinate)) {
                board.markShoot(randXCoordinate,randYCoordinate);
                break;
            }
        }
    }
}
