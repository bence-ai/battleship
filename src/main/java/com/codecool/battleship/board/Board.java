package com.codecool.battleship.board;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that encapsulates a player board
 * and houses the functions necessary to
 * operate it.
 * All coordinates are [x][y] order!
 */
public class Board {
    // attributes
    private Square[][] ocean;

    // constructor
    public Board(int sideLength) {
        ocean = new Square[sideLength][sideLength];

        // fill board with "empty"-status tiles
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                ocean[i][j] = new Square(i, j);
            }
        }
    }

    /**
     * Function that checks if placement of ship is acceptable.
     * @param startX: Leftmost X coordinate of ship
     * @param startY: Topmost Y coordinate of ship
     * @param endX: Rightmost X coordinate of ship
     * @param endY: Bottom Y coordinate of ship
     * @return false if ship cannot be legally placed at given coordinates, otherwise true
     */
    public boolean isPlacementOkay(int startX, int startY, int endX, int endY) {
        //TODO: Placement logic
        List<Square> tiles = collectShipTiles(startX, startY, endX, endY);
        //TODO: don't allow ship placement next to another ship
        for (Square tile : tiles) {
            if (tile.getSquareStatus() != SquareStatus.EMPTY) {
                return false;
            }
        }
        return true;
    }

    public List<Square> collectShipTiles(int startX, int startY, int endX, int endY) {
        List<Square> tiles = new ArrayList<>();
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                tiles.add(this.ocean[i][j]);
            }
        }
        return tiles;
    }

    public void setShip(int startX, int startY, int endX, int endY) {
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                this.ocean[i][j].SetSquareStatus(SquareStatus.SHIP);
            }
        }
    }



    public boolean isShootOkay(int x, int y) {
        return true;
    }

    public void markShoot(int x, int y) {

    }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder("  ");
        String[] letters = {" A ", " B ", " C ", " D ", " E ", " F ", " G ", " H ", " I "};
        String[] numbers = {" 1", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9"};

        for (int i = 0; i < ocean.length; i++) {
            board.append(letters[i]);
        }
        int numberIndex = 0;
        for (Square[] col: ocean) {
            board.append("\n").append(numbers[numberIndex++]);
            for (Square cell: col) {
                board.append(" ").append(cell.getSquareStatus()).append(" ");
            }
        }

        return board.toString();
    }
}
