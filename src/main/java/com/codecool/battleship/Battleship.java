package com.codecool.battleship;

import com.codecool.battleship.console.Display;
import com.codecool.battleship.console.Input;

public class Battleship {
    Display display = new Display();
    Input input = new Input();
    Player playerOne;
    Player playerTwo;

    /**
     * method starts the application and keeps it runs till the user do not exit
     */
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
                case 1:
                    size = 5;
                    break;
                case 2:
                    size = 7;
                    break;
                case 3:
                    size = 9;
                    break;
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
                    playerTwo = ComputerEasy.withBoardSize(ComputerPlayer.generateName(), size);
                } else if (size == 7) {
                    playerTwo = ComputerMedium.withBoardSize(ComputerPlayer.generateName(), size);
                } else if (size == 9) {
                    playerTwo = ComputerHard.withBoardSize(ComputerPlayer.generateName(), size);
                }
            }

            Game game = new Game(playerOne, playerTwo);
            game.play();
        }
    }
}
