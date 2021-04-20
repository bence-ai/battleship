package java.com.codecool.battleship;
import java.com.codecool.battleship.board.Ship;
import java.com.codecool.battleship.board.Square;
import java.com.codecool.battleship.board.SquareStatus;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Player class has Square[][] board, String name, List<Ship> ships.
 */
public class Player {
    private Board board;
    public final String name;
    List<Ship> ships = new ArrayList<Ship>();

    public Player(int size) {
        this.board = new Board(size);
    }
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    /**
     * Player shoots, and change the shooted Square status.
     */
    public void shoot(Square[][] ocean, List<Ship> enemyShips) {
        Scanner shooting = new Scanner(System.in);
        while (true) {
            System.out.println("Give the coordinate:");
            String coordinate = shooting.nextLine();
            String XCoordinate = coordinate.substring(0,1);
            String YCoordinate = coordinate.substring(1);
            if (validInput(firstCoordinate, secondCoordinate)) break;       // Input validator!!!
        }
        // Maybe doesn't need loop
        for (Square[] row: ocean) {
            for (Square cell: row) {
                if (cell.getX() == XCoordinate && cell.getY() == YCoordinate) {
                    if (cell.squareStatus == SquareStatus.EMPTY) {              // EMPTY ('.')
                        System.out.println("It's an empty square");
                        cell.SetSquareStatus('X');                              // MISS ('X')
                    }
                    else if (cell.SquareStatus == SquareStatus.SHIP) {          // SHIP ('O')
                        System.out.println("It's a HIT");
                        cell.SetSquareStatus('#');                              // HIT ('#');
                        for (Ship ship: enemyShips) {
                            for (Square shipCell: ship.tiles) {
                                if (shipCell.getX() == XCoordinate && shipCell.getY() == YCoordinate) {
                                    shipCell.SetSquareStatus('#');
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Return List<Ship> ships.
     */
    public List<Ship> getShips() { return ships; }

    /**
     * Check that player still have at least one Square ship.
     */
    public boolean isAlive() {
        for (Ship ship: ships) {
            for (Square cell: ship.tiles) {
                if (cell.GetSquareStatus() == 'O') return true;
            }
        }
        return false;
    }
}
