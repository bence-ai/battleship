package java.com.codecool.battleship;

import java.com.codecool.battleship.console.Display;
import java.com.codecool.battleship.console.Input;

public class Battleship {
    private static void main(String[] args) {
        Display display = new Display();
        Input validateInput = new Input();
        Player playerOne;
        Player playerTwo;

        while (true) {
            display.printMenu();
            int mode = validateInput.modeSelect();
            if (mode == 0) {
                System.exit(0);
            }

            display.printSize();
            int size = validateInput.sizeSelect();
            if (size == 0) {
                continue;
            }

            switch (size) {
                case 1 -> size = 5;
                case 2 -> size = 7;
                case 3 -> size = 9;
            }

            display.setName();
            String name = validateInput.isValidName();
            playerOne = new Player(size);
            playerOne.setName(name);


            if (mode == 1) {
                display.setName();
                String nameTwo = validateInput.isValidName();
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
