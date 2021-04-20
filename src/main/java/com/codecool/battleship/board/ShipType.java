package com.codecool.battleship.board;

/**
 * Enum that defines the types of ships
 * and their lengths.
 */
public enum ShipType {
    CARRIER (1),
    CRUISER (2),
    BATTLESHIP (3),
    SUBMARINE (4),
    DESTROYER (5);

    ShipType(int length) {
        this.length = length;
    }

    // Number of Square objects to set to "ship" status when a ship of this type is placed
    private final int length;
    protected int GetLength() {
        return length;
    }
}
