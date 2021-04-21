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
        ArrayList<Square> BasicMoveList = new ArrayList<>();
        Random rand = new Random();
        while (true) {
            for (Square[] squareRows: board.getOcean()) {
                for (Square square: squareRows) {
                    if (square.GetSquareStatus() != SquareStatus.MISS) {
                        
                    }
                }
            }
        }
    }
}
