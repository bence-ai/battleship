package java.com.codecool.battleship.console;

import java.com.codecool.battleship.board.Square;
import java.util.Scanner;

public class Input {
    Scanner input = new Scanner(System.in);

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }
}
