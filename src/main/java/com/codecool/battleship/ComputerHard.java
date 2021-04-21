package com.codecool.battleship;

import com.codecool.battleship.board.Board;

public class ComputerHard extends ComputerPlayer  {
    public ComputerHard(int size){
        super(new Board(size));
    }
}
