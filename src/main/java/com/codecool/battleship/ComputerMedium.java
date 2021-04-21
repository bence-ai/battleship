package com.codecool.battleship;

import com.codecool.battleship.board.Board;

public class ComputerMedium extends ComputerPlayer  {

    public ComputerMedium(int size){
        super(new Board(size));
    }

}
