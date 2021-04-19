package java.com.codecool.battleship;
import java.com.codecool.battleship.board.Ship;
import java.com.codecool.battleship.board.Square;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Ship> ships = new ArrayList<Ship>();

    public void shoot(Square[][] ocean) {  //get this shoot method the board or the list of ships from the other player??
        //input from here or from input class??
        int inputX = 2;
        int inputY = 4;
        for (Square[] row: ocean) {
            for (Square cell: row) {
                if (cell.getX() == inputX && cell.getY() == inputY) {
                    if (cell.squareStatus == "empty") {
                        System.out.println("It's an empty square");
                        cell.squareStatus = "miss";
                    }
                    else if (cell.SquareStatus == "ship") {
                        System.out.println("It's a HIT");
                        cell.squareStatus = "hit";
                    }
                }
            }
        }
    }

    public boolean isAlive() {
        for (Ship ship: ships) {
            for (Square cell: ship.cells) {  //need List name
                if (cell.squareStatus == "ship") return true;
            }
        }
        return false;
    }
}
