package com.codecool.battleship.board;

import com.codecool.battleship.console.Display;
import com.codecool.battleship.console.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoardFactory {
    public static Board randomPlacement(int size) {
        Random rand = new Random();
        int verticalOrHorizontal = rand.nextInt(2);
        List<ShipType> ships = new ArrayList<>();
        Board board = new Board(size);

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
                int[] coordinates = {rand.nextInt(size), rand.nextInt(size)};
                if (verticalOrHorizontal == 0) {
                    if (board.isPlacementOkay(coordinates[0], coordinates[1], coordinates[0] + (ship.getLength() - 1), coordinates[1])) {
                        board.setShip(coordinates[0], coordinates[1], coordinates[0] + (ship.getLength() - 1), coordinates[1]);
                        Ship currentShip = createShip(board, ship, coordinates);
                        board.addShip(currentShip);
                        break;
                    }
                }
                if (board.isPlacementOkay(coordinates[0], coordinates[1], coordinates[0], coordinates[1] + (ship.getLength() - 1))) {
                    board.setShip(coordinates[0], coordinates[1], coordinates[0], coordinates[1] + (ship.getLength() - 1));
                    Ship currentShip = createShip(board, ship, coordinates);
                    board.addShip(currentShip);
                    break;
                }
            }
        }
        return board;
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
                display.boardPreview(board);
                display.askCoordinate(ship);
                int[] coordinates = input.coordinateInput();
                display.askDirection();
                String direction = input.directionInput();
                if (direction.equals("v")) {
                    if (board.isPlacementOkay(coordinates[0], coordinates[1], coordinates[0] + (ship.getLength() - 1), coordinates[1])) {
                        board.setShip(coordinates[0], coordinates[1], coordinates[0] + (ship.getLength() - 1), coordinates[1]);
                        Ship currentShip = new Ship();
                        int j = coordinates[1];
                        for (int i = coordinates[0]; i <= coordinates[0] + (ship.getLength() - 1); i++) {
                            currentShip.addSquare(board.getOcean()[i][j]);
                        }
                        board.addShip(currentShip);
                        break;
                    }
                    display.error("Place already taken!");
                    continue;
                }
                if (board.isPlacementOkay(coordinates[0], coordinates[1], coordinates[0], coordinates[1] + (ship.getLength() - 1))) {
                    board.setShip(coordinates[0], coordinates[1], coordinates[0], coordinates[1] + (ship.getLength() - 1));
                    Ship currentShip = new Ship();
                    int j = coordinates[0];
                    for (int i = coordinates[1]; i <= coordinates[1] + (ship.getLength() - 1); i++) {
                        currentShip.addSquare(board.getOcean()[i][j]);
                    }
                    board.addShip(currentShip);
                    break;
                }
                display.error("Place already taken!");
            }
        }
        return board;
    }

    private static Ship createShip(Board board, ShipType ship, int[] coordinates) {
        Ship createShip = new Ship();
        for (int i = coordinates[0]; i <= coordinates[1]; i++) {
            for (int j = coordinates[0] + (ship.getLength() - 1); j <= coordinates[1]; j++) {
                createShip.addSquare(board.getOcean()[i][j]);
            }
        }
        return createShip;
    }

}
