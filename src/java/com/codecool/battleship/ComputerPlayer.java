package java.com.codecool.battleship;

import java.com.codecool.battleship.board.Board;
import java.com.codecool.battleship.board.Ship;
import java.com.codecool.battleship.board.Square;
import java.util.ArrayList;

public abstract class ComputerPlayer extends Player{
    protected ArrayList<Ship> ships = new ArrayList<>();
    protected boolean isAlive = true;
    protected String name;
    protected Board ocean;
    protected String[] nameList = {"Dreadnought",
            "Falling Star",
            "Frontier",
            "Midway",
            "Agamemnon",
            "HMS Frontier",
            "BS Last Hope",
            "ISS Avius",
            "BS Warrior",
            "BC Destructor",
            "Noe Bark"};

    // generates a name form nameList above.
    public void generateName() {
        int index = (int)(Math.random() * nameList.length);
        for (int i = 0; i < nameList.length; i++) {
            if(i == index) {
                this.name = nameList[index];
            }
        }
    }

    public boolean isAlive() {
        if (ships.isEmpty()) {
            isAlive = false;
        }
        return isAlive;
    }

    // Need to check if the ships are sunk, and then pop the sunk ones from the list

    public abstract int[] easyComputerRandomShot(Square[][] ocean); // this method will inherit the player move method and so it's subclasses


}
