package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;
import com.codecool.battleship.console.Input;

/**
 * Player class has Square[][] board, String name, List<Ship> ships.
 */
public class Player {
    protected Board board;
    protected String name;
    Input input = new Input();

    public Player(Board board, String name) {
        this.board = board;
        this.name = name;
    }

    public static Player withBoardSize(String name, int size) {
        Board board = BoardFactory.manualPlacement(size);
        return new Player(board, name);
    }

    public String getName() {
        return name;
    }
    /**
     * Player shoots, and change the shot Square status.
     */
    public void shoot(Board board) {
        while (true) {
            int[] shootInput = input.coordinateInput(board.getOcean().length);
            if (board.isShootOkay(shootInput[0], shootInput[1])) {
                board.markShoot(shootInput[0], shootInput[1]);
                break;
            }
        }
        board.isShipSunk();
    }
    /**
     * Check that player still have at least one Square ship.
     */
    public boolean isAlive() {
        return board.isAlive();
    }

    public String boardToString() {
        return board.toString();
    }
}
