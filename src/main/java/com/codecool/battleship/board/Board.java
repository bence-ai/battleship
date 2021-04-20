package com.codecool.battleship.board;

/**
 * Class that encapsulates a player board
 * and houses the functions necessary to
 * operate it.
 * All coordinates are [x][y] order!
 */
public class Board {
    // attributes
    private Square[][] ocean;

    // constructor
    public Board(int sideLength) {
        ocean = new Square[sideLength][sideLength];

        // fill board with "empty"-status tiles
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                ocean[i][j] = new Square(i, j);
            }
        }
    }

    /**
     * Function that checks if placement of ship is acceptable.
     * @param startX: Leftmost X coordinate of ship
     * @param startY: Topmost Y coordinate of ship
     * @param endX: Rightmost X coordinate of ship
     * @param endY: Bottom Y coordinate of ship
     * @return false if ship cannot be legally placed at given coordinates, otherwise true
     */
    protected boolean isPlacementOkay(int startX, int startY, int endX, int endY) {
        for (int i = startX - 1; i <= endX + 1; i++)
            for (int j = startY - 1; j <= endY + 1; j++)
                if (ocean[i][j].getSquareStatus() != SquareStatus.EMPTY.getCharacter())
                    return false;
        return true;
    }
}
