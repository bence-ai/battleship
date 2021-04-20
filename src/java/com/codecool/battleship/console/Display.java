package java.com.codecool.battleship.console;

import java.com.codecool.battleship.Player;
import java.com.codecool.battleship.board.Square;

public class Display {
    public void printMenu() {
        clearScreen();
        System.out.println("BATTLESHIP DESTROYER\n\n 1. Player vs. Player\n 2. Player vs. Computer");
    }

    public void printSize() {
        clearScreen();
        System.out.println("BOARD SIZE\n\n 1. Small\n 2. Medium\n 3. Large");
    }

    public void setName(int player) {
        clearScreen();
        System.out.println("NAME CREATION\n\nPlayer " + player + " choose your name: ");
    }

    public void printBoard(Square[][] ocean) {
        clearScreen();
        StringBuilder board = new StringBuilder("  ");
        String[] letters = {" A ", " B ", " C ", " D ", " E ", " F ", " G ", " H ", " I "};
        String[] numbers = {" 1", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9"};

        for (int i = 0; i < ocean.length; i++) {
            board.append(letters[i]);
        }
        int numberIndex = 0;
        for (Square[] col: ocean) {
            board.append("\n").append(numbers[numberIndex++]);
            for (Square cell: col) {
                board.append(" ").append(cell.GetSquareStatus()).append(" ");
            }
        }

        System.out.println(board);
    }

    public void printRound(Player player) {
        System.out.println(player.getName() + " it's your turn!");
        System.out.println("Set your move: ");
    }

    public void printWinner(Player player) {
        clearScreen();
        System.out.println(player.getName() + " wins!");
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
}
