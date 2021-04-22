package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.Square;
import com.codecool.battleship.board.SquareStatus;

import java.util.ArrayList;
import java.util.Random;

/**
 * abstract class that extends player class
 * and the super class of easy, medium and hard computer classes.
 * this class has it's methods depends on difficulties.
 */

public abstract class ComputerPlayer extends Player {
    protected static String[] nameList = {"Dreadnought",
            "Falling Star",
            "Frontier",
            "Midway",
            "Agamemnon",
            "HMS Frontier",
            "BS Last Hope",
            "ISS Avius",
            "BS Warrior",
            "BC Destructor",
            "Noe's Bark"};

    public ComputerPlayer(Board board, String name) {
        super(board, name);
    }

    // generates a name form nameList above.
    public static String generateName() {
        int index = (int)(Math.random() * nameList.length);
        return nameList[index];
    }



    // shoot method overrides player's shoot method and examines the opponent's board and change it's status trough checkers

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
            if (!sunkList.contains(predictList.get(randomIndex))) {
                if (board.isShootOkay(predictList.get(randomIndex).getX(),predictList.get(randomIndex).getY())){
                    board.markShoot(predictList.get(randomIndex).getX(),predictList.get(randomIndex).getY());
                    break;
                }
            }
        }board.isShipSunk();
    }

    // sunkCoordinateException method checks if a player's ship is sunk and demand on the game's rules except certain moves.

    public ArrayList<Square> sunkCoordinateException(Board board) {
        ArrayList<Square> sunkExceptionList = new ArrayList<>();
        for (Square[] squareRows: board.getOcean()) {
            for (Square square: squareRows) {
                if (square.GetSquareStatus() == SquareStatus.SUNK) {
                    checkAroundHit(board, sunkExceptionList, square);
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

    // whenever computer lands a shoot predicts the other part of the ship.

    public ArrayList<Square> predictionForHit(Board board) {
        ArrayList<Square> predictionForHit = new ArrayList<>();
        for (Square[] squareRows: board.getOcean()) {
            for (Square square: squareRows) {
                if (square.GetSquareStatus() == SquareStatus.HIT) {
                    checkAroundHit(board, predictionForHit, square);
                }
            }
        }
        return predictionForHit;
    }

    // whenever the computer lands a shoot collects all possible places around the hit to predict an other one later.

    public void checkAroundHit(Board board, ArrayList<Square> predictionForHit, Square square) {
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

    // basicMove random takes shots to places what are empty or ship part and excludes places around sunk ships

    public void basicMove(Board board, ArrayList<Square> sunkList) {
        Random rand = new Random();
        while (true){
            int randXCoordinate = rand.nextInt(7);
            int randYCoordinate = rand.nextInt(7);
            Square sunkSquare = board.getOcean()[randXCoordinate][randYCoordinate];
            if (board.isShootOkay(randXCoordinate,randYCoordinate) && !sunkList.contains(sunkSquare)) {
                board.markShoot(randXCoordinate,randYCoordinate);
                break;
            }
        }
    }
}
