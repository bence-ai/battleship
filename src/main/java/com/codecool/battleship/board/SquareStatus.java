package com.codecool.battleship.board;

/**
 * Enum that defines the states a
 * Square object can be in.
 */
public enum SquareStatus {
    // Statuses
    SHIP (" ⚓️ "),
    MISS (" 🌊 "),
    EMPTY (" 🔵 "),
    HIT (" 🔥 "),
    SUNK(" @");

    SquareStatus(String displayCharacter) {
        this.displayCharacter = displayCharacter;
    }

    // Character representation of statuses
    // Accessed through Square.GetSquareStatus()
    private final String displayCharacter;
    public String getCharacter() {
        return displayCharacter;
    }
}
