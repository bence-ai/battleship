package java.com.codecool.battleship;

import java.com.codecool.battleship.console.Display;
import java.com.codecool.battleship.console.Input;

public class Battleship {
    Display display = new Display();
    Input input = new Input();
    Player playerOne;
    Player playerTwo;

    public void play() {

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
            playerOne = new Player(size);
            playerOne.setName(name);


            if (mode == 1) {
                display.setName();
                String nameTwo = input.isValidName();
                playerTwo = new Player(size);
                playerTwo.setName(nameTwo);
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
