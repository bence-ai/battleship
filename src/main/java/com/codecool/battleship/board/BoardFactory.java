package com.codecool.battleship.board;

import com.codecool.battleship.Player;
import com.codecool.battleship.console.Display;
import com.codecool.battleship.console.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoardFactory {
    public Board randomPlacement(Player player) {
        Random rand = new Random();
        int verticalOrHorizontal = rand.nextInt(2);

        return null; //this is under construction :)
    }

    public static Board manualPlacement(int size) {
        List<ShipType> ships = new ArrayList<>();
        Board board = new Board(size);
        Input input = new Input();
        Display display = new Display();

        if (size == 5) {
            ships.add(ShipType.CARRIER);
            ships.add(ShipType.CRUISER);
        } else if (size == 7) {
            ships.add(ShipType.CRUISER);
            ships.add(ShipType.BATTLESHIP);
            ships.add(ShipType.SUBMARINE);
        } else {
            ships.add(ShipType.CARRIER);
            ships.add(ShipType.CRUISER);
            ships.add(ShipType.BATTLESHIP);
            ships.add(ShipType.SUBMARINE);
            ships.add(ShipType.BATTLESHIP);
        }

        for (ShipType ship: ships) {
            while (true) {
                display.askCoordinate(ship);
                int[] coordinates = input.coordinateInput();
                display.askDirection();
                String direction = input.directionInput();
                if (direction.equals("v")) {
                    if (board.isPlacementOkay(coordinates[0], coordinates[1], coordinates[0] + (ship.getLength() - 1), coordinates[1])) {
                        board.setShip(coordinates[0], coordinates[1], coordinates[0] + (ship.getLength() - 1), coordinates[1]);
                        break;
                    }
                }
                if (board.isPlacementOkay(coordinates[0], coordinates[1], coordinates[0], coordinates[1] + (ship.getLength() - 1))) {
                    board.setShip(coordinates[0], coordinates[1], coordinates[0], coordinates[1] + (ship.getLength() - 1));
                    break;
                }
                display.error("Place already taken!");
            }
        }
        return board;
    }

}
