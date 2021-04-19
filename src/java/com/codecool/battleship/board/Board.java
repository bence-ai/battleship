package java.com.codecool.battleship.board;

/**
 * Class that encapsulates a player board
 * and houses the functions necessary to
 * operate it
 */
public class Board {
    private Square[][] ocean;

    public Board(int sideLength) {
        ocean = new Square[sideLength][sideLength];
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                ocean[i][j] = new Square(i, j);
            }
        }
    }
}
