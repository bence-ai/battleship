package java.com.codecool.battleship.board;

/**
 * Enum that defines the states a
 * Square object can be in.
 */
public enum SquareStatus {
    // Statuses
    SHIP (Square._ShipCharacter),
    MISS (Square._MissCharacter),
    EMPTY (Square._EmptyCharacter),
    HIT (Square._HitCharacter);

    SquareStatus(char displayCharacter) { this.displayCharacter = displayCharacter; }

    // Character representation of statuses
    // Accessed through Square.GetSquareStatus()
    private final char displayCharacter;
    protected char GetCharacter() { return displayCharacter; }
}
