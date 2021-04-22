package com.codecool.battleship.board;

/**
 * Class that represents one tile on a
 * player's board.
 */
public class Square {
    // attributes
    private SquareStatus status;
    private final int x;
    private final int y;

    // constructor
    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        status = SquareStatus.EMPTY;
    }

    // methods
    public char GetSquareStatus() { return status.getCharacter(); }

    public void SetSquareStatus( SquareStatus status ) { this.status = status; }

    public int getY() { return y; }

    public int getX() { return x; }
}
