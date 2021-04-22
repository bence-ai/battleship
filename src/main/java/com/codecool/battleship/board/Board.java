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
    private final Square[][] ocean;

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
     * Checks if placement of ship is acceptable.
     * @param startX: Leftmost X coordinate of ship
     * @param startY: Topmost Y coordinate of ship
     * @param endX: Rightmost X coordinate of ship
     * @param endY: Bottom Y coordinate of ship
     * @return false if ship cannot be legally placed at given coordinates, otherwise true
     */
    public boolean isPlacementOkay(int startX, int startY, int endX, int endY) {
        int minX = Math.max(startX - 1, 0);
        int minY = Math.max(startY - 1, 0);
        int maxX = Math.min(endX + 1, this.ocean.length - 1);
        int maxY = Math.min(endY + 1, this.ocean.length - 1);
        for (int i = minX; i <= maxX + 1; i++) {
            for (int j = minY; j <= maxY; j++) {
                if (ocean[i][j].GetSquareStatus() != SquareStatus.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Collects all tiles a ship will occupy.
     * @param startX: Leftmost X coordinate of ship
     * @param startY: Topmost coordinate of ship
     * @param endX: Rightmost coordinate of ship
     * @param endY: Bottom coordinate of ship
     * @return List<Square> containing tiles ship overlaps
     */
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
        return ocean[x][y].GetSquareStatus() == SquareStatus.EMPTY || ocean[x][y].GetSquareStatus() == SquareStatus.SHIP;
    }

    public void markShoot(int x, int y) {
        if (ocean[x][y].GetSquareStatus() == SquareStatus.EMPTY) {
            ocean[x][y].SetSquareStatus(SquareStatus.MISS);
        } else if (ocean[x][y].GetSquareStatus() == SquareStatus.SHIP) {
            ocean[x][y].SetSquareStatus(SquareStatus.HIT);
        }
    }

    public Square[][] getOcean() {
        return ocean;
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
                if (cell.GetSquareStatus() == SquareStatus.HIT || cell.GetSquareStatus() == SquareStatus.MISS)
                board.append(" ").append(cell.GetSquareStatus().getCharacter()).append(" ");
            }
        }

        return board.toString();
    }
}
