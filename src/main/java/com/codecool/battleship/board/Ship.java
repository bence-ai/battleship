package com.codecool.battleship.board;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents one ship the
 * player has to shoot down from their
 * enemy's board.
 */
public class Ship {
    // attributes
    private List<Square> tiles = new ArrayList<>();

    /**
     * Ship object type constructor.
     */
    public void addSquare(Square square) {
        tiles.add(square);
    }

    public List<Square> getTiles() {
        return tiles;
    }
}
