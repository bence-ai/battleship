package java.com.codecool.battleship;

import java.com.codecool.battleship.board.Board;
import java.com.codecool.battleship.board.Ship;
import java.com.codecool.battleship.board.Square;
import java.util.ArrayList;

public abstract class ComputerPlayer {
    protected ArrayList<Ship> ships = new ArrayList<>();
    protected boolean isAlive = true;

    public boolean isAlive() {
        if (ships.isEmpty()) {
            isAlive = false;
        }
        return isAlive;
    }

    // Need to check if the ships are sunk, and then pop the sunk ones from the list

    public abstract int[] easyComputerRandomShot(Square[][] ocean);


}
