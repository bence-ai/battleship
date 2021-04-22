package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;

public class ComputerHard extends ComputerPlayer  {
    public ComputerHard(Board board, String name){
        super(board, name);
    }

    public static Player withBoardSize(String name, int size) {
        Board board = BoardFactory.randomPlacement(size);
        return new ComputerHard(board, name);
    }
}
