package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;

public class ComputerMedium extends ComputerPlayer  {

    public ComputerMedium(Board board, String name){
        super(board, name);
    }

    // creates ComputerMedium instance and place it's ships to it's board

    public static Player withBoardSize(String name, int size) {
        Board board = BoardFactory.randomPlacement(size);
        return new ComputerMedium(board, name);

    }
}
