package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * Player class has Square[][] board, String name, List<Ship> ships.
 */
public class Player {
    protected Board board;
    protected String name;
    List<Ship> ships = new ArrayList<>();

    public Player(Board board, String name) {
        this.board = board;
        this.name = name;
    }

    public static Player withBoardSize(String name, int size) {
        Board board = new Board(size);
        return new Player(board, name);
    }

    public String getName() {
        return name;
    }
    /**
     * Player shoots, and change the shot Square status.
     * TODO: Validation should be in the Board object, here just the shoot itself!
     */
    public void shoot(Board board) {
//        while (true)
        // input
//        if (board.isShootOkay()) {
//            board.markShoot();
//            break;



    }

    /**
     * Return List<Ship> ships.
     */
    public List<Ship> getShips() { return ships; }

    /**
     * Check that player still have at least one Square ship.
     */
    public boolean isAlive() {

        return false;
    }
}
