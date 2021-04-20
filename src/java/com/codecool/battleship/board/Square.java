package java.com.codecool.battleship.board;

/**
 * Class that represents one tile on a
 * player's board.
 */
public class Square {
    // constants
    // TODO: this is technically wrong
    public static final char _EmptyCharacter = '.';
    public static final char _ShipCharacter = 'O';
    public static final char _MissCharacter = 'X';
    public static final char _HitCharacter = '#';

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
    public void SetSquareStatus( SquareStatus status ) { this.status = status; }
}
