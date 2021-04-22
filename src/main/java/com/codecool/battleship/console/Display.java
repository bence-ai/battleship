package com.codecool.battleship.console;

import com.codecool.battleship.Player;
import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.ShipType;
import com.codecool.battleship.board.Square;
import com.codecool.battleship.board.SquareStatus;

import java.util.concurrent.TimeUnit;

public class Display {
    public void printLogo() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("         o-o                   o                  o---o      o      ");
        System.out.println("        |                      |                     /       |      ");
        System.out.println("         o-o   o-o o  o  oo  o-O o-o o-o o-o       -O-  o  o | o  o ");
        System.out.println("            | |  | |  | | | |  | |   | | |  |      /    |  | | |  | ");
        System.out.println("        o--o   o-O o--o o-o- o-o o   o-o o  o     o---o o--o o o--o ");
        System.out.println("                |                                                  ");
        System.out.println("                o                                                  ");
        System.out.println();
    }

    /**
     * prints the main menu to the terminal window
     */
    public void printMenu() {
        clearScreen();
        printLogo();
        System.out.printf("%48s%n", "[1]   Player vs. Player");
        System.out.printf("%48s%n", "[2] Player vs. Computer");
        System.out.printf("%48s%n", "[0]                Exit");
    }

    /**
     * prints the main menu to the terminal window
     */
    public void printSize() {
        clearScreen();
        printLogo();
        System.out.printf("%40s%n", "[1]   Small");
        System.out.printf("%40s%n", "[2]  Medium");
        System.out.printf("%40s%n", "[3]   Large");
        System.out.printf("%40s%n", "[0]    Back");
    }

    public void setName() {
        clearScreen();
        System.out.printf("%40s%n", "NAME CREATION");
        System.out.println("");
        System.out.printf("%40s%n", "Choose your name [max 15 characters]:");
    }

    public void printBoard(Player player) {
        clearScreen();
        System.out.println();
        System.out.println();
        System.out.println(player.boardToString());
    }

    public void boardPreview(Board board) {
        clearScreen();
        int spaces = 30 - board.getOcean().length;
        StringBuilder builder = new StringBuilder("  ").append(" ".repeat(spaces));
        String[] letters = {"1️⃣", "2️⃣", "3️⃣", "4️⃣", "5️⃣", "6️⃣", "7️⃣", "8️⃣", "9️⃣"};
        String[] numbers = {"🅰", "🅱", "🅲", "🅳", "🅴", "🅵", "🅶", "🅷", "🅸"};

        for (int i = 0; i < board.getOcean().length; i++) {
            builder.append(" ").append(letters[i]).append(" ");
        }

        int numberIndex = 0;
        for (Square[] col: board.getOcean()) {
            builder.append("\n").append(" ".repeat(spaces)).append(numbers[numberIndex++]).append(" ");
            for (Square cell: col) {
                if (cell.GetSquareStatus() == SquareStatus.SHIP || cell.GetSquareStatus() == SquareStatus.EMPTY)
                    builder.append(cell.GetSquareStatus().getCharacter());
            }
        }
        System.out.println();
        System.out.println();
        System.out.println(builder);
    }

    public void printRound(Player player) {
        System.out.println(player.getName() + ", it's your turn!");
        System.out.println("Place your shot: ");
    }

    public void getReady(Player player) {
        System.out.println(player.getName()+ " Get ready for your turn!");
    }

    public void printWinner(Player player) {
        clearScreen();
        System.out.print("o--o  oo o-O-o o-o     o-o o   o o-o o-o \n");
        System.out.print("|  | | | | | | |-'     | |  \\ /  |-' |   \n");
        System.out.print("o--O o-o-o o o o-o     o-o   o   o-o o   \n");
        System.out.print("   |                                     \n");
        System.out.print("o--o   " + player.getName() + " wins!");
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public void error(String message) {
        System.out.println(message);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e){
            error(e.toString());
        }
    }

    public void askCoordinate(ShipType ship) {
        System.out.println();
        System.out.println("Please provide your " + ship.getLength() + " long ship (" + ship.name() + ") start coordinate");
    }

    public void askDirection() {
        System.out.println("Vertical or horizontal? [v/h] ");
    }

    public void exit() {
        clearScreen();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.print("             o-o             o     o--o           o \n");
        System.out.print("            o                |     |   |          | \n");
        System.out.print("            |  -o o-o o-o  o-O     O--o  o  o o-o o \n");
        System.out.print("            o   | | | | | |  |     |   | |  | |-'   \n");
        System.out.print("             o-o  o-o o-o  o-o     o--o  o--O o-o O \n");
        System.out.print("                                            |       \n");
        System.out.print("                                         o--o       \n");
    }
}
