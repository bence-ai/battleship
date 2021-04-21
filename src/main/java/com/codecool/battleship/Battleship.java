package com.codecool.battleship;

import com.codecool.battleship.console.Display;
import com.codecool.battleship.console.Input;

public class Battleship {
    Display display = new Display();
    Input input = new Input();
    Player playerOne;
    Player playerTwo;

    public void start() {
        while (true) {
            display.printMenu();
            int mode = input.modeSelect();
            if (mode == 0) {
                return;
            }

            display.printSize();
            int size = input.sizeSelect();
            if (size == 0) {
                continue;
            }

            switch (size) {
                case 1 -> size = 5;
                case 2 -> size = 7;
                case 3 -> size = 9;
            }

            display.setName();
            String name = input.isValidName();
            playerOne = Player.withBoardSize(name, size);

            if (mode == 1) {
                display.setName();
                String nameTwo = input.isValidName();
                playerTwo = Player.withBoardSize(nameTwo, size);
            } else {
                if (size == 5) {
                    playerTwo = new ComputerEasy(size);
                } else if (size == 7) {
                    playerTwo = new ComputerMedium(size);
                } else if (size == 9) {
                    playerTwo = new ComputerHard(size);
                }
            }
        }
    }
}