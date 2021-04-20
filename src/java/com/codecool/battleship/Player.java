package java.com.codecool.battleship;

import java.com.codecool.battleship.board.Board;

public class Player {
    private String name;
    private Board board;

    public Player(int size) {
        this.board = new Board(size);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
