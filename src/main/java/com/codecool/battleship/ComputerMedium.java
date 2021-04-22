package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;
import com.codecool.battleship.board.Square;

import java.util.ArrayList;
import java.util.Random;

public class ComputerMedium extends ComputerPlayer  {

    public ComputerMedium(Board board, String name){
        super(board, name);
    }

    @Override
    public void shoot(Board board) {
        ArrayList<Square> BasicMoveList = new ArrayList<>();
        Random rand = new Random();
//        while (true) {
//            for (Square[] squareRows: board.getOcean()) {
//                for (Square square: squareRows) {
//                    if (square.GetSquareStatus() != SquareStatus.MISS) {
//
//                    }
//                }
//            }
//        }
    }

    public static Player withBoardSize(String name, int size) {
        Board board = BoardFactory.randomPlacement(size);
        return new ComputerMedium(board, name);
    }
}
