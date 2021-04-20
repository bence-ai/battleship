package com.codecool.battleship;

import com.codecool.battleship.board.Board;

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
            "Noe Bark"};

    public ComputerPlayer(Board board) {
        super(board, generateName());
    }

    // generates a name form nameList above.
    private static String generateName() {
        int index = (int)(Math.random() * nameList.length);
        return nameList[index];
    }
}
