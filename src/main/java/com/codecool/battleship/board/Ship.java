package com.codecool.battleship.board;

import java.util.List;

/**
 * Class that represents one ship the
 * player has to shoot down from their
 * enemy's board.
 */
public class Ship {
    // attributes
    private List<Square> tiles;

    // constructor

    /**
     * Ship object type constructor.
     * @param startX: Leftmost X coordinate of ship
     * @param startY: Topmost Y coordinate of ship
     * @param endX: Rightmost X coordinate of ship
     * @param endY: Bottom Y coordinate of ship
     */
    public Ship(int startX, int startY, int endX, int endY) {
        // TODO: finish Ship constructor
    }

    public boolean isAlive() {
        for (Square tile :
                tiles) {
            if (tile.GetSquareStatus() == SquareStatus.SHIP) {
                return true;
            }
        }
        return false;
    }
}
