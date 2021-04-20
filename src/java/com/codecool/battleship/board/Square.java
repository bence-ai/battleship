package java.com.codecool.battleship.board;

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
    public char GetSquareStatus() { return status.GetCharacter(); }
}
