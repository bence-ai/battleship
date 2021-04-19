package java.com.codecool.battleship.board;

public enum SquareStatus {
    SHIP ('O'),
    MISS ('X'),
    EMPTY ('.'),
    HIT ('#');
    SquareStatus(char displayCharacter) { this.displayCharacter = displayCharacter; }
    private final char displayCharacter;
    public char GetCharacter() { return displayCharacter; }
}
