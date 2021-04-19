package java.com.codecool.battleship.board;

public class Square {
    private SquareStatus status;
    private final int x;
    private final int y;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        status = SquareStatus.EMPTY;
    }

    public char GetSquareStatus() { return status.GetCharacter(); }
}
