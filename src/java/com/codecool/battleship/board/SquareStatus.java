package java.com.codecool.battleship.board;

/**
 * Enum that defines the states a
 * Square object can be in.
 */
public enum SquareStatus {
    // Statuses
    SHIP ('O'),
    MISS ('X'),
    EMPTY ('.'),
    HIT ('#');

    SquareStatus(char displayCharacter) { this.displayCharacter = displayCharacter; }

    // Character representation of statuses
    // Accessed through Square.GetSquareStatus()
    private final char displayCharacter;
    protected char GetCharacter() { return displayCharacter; }
}
