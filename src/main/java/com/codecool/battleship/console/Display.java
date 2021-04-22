package com.codecool.battleship.console;

import com.codecool.battleship.Player;
import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.ShipType;
import com.codecool.battleship.board.Square;
import com.codecool.battleship.board.SquareStatus;

public class Display {
    /**
     * prints the main menu to the terminal window
     */
    public void printMenu() {
        clearScreen();
        System.out.println("Squadron Zulu\n\n [1] Player vs. Player\n [2] Player vs. Computer\n [0] Exit");
    }

    /**
     * prints the main menu to the terminal window
     */
    public void printSize() {
        clearScreen();
        System.out.println("BOARD SIZE\n\n [1] Small\n [2] Medium\n [3] Large\n [0] Back");
    }

    public void setName() {
        clearScreen();
        System.out.println("NAME CREATION\n\nChoose your name [max 15 characters]: ");
    }

    public void printBoard(Player player) {
        clearScreen();
        System.out.println(player.boardToString());
    }

    public void boardPreview(Board board) {
        clearScreen();
        StringBuilder builder = new StringBuilder("   ");
        String[] letters = {"1️⃣", "2️⃣", "3️⃣", "4️⃣", "5️⃣", "6️⃣", "7️⃣", "8️⃣", "9️⃣"};
        String[] numbers = {"🅰", "🅱", "🅲", "🅳", "🅴", "🅵", "🅶", "🅷", "🅸"};

        for (int i = 0; i < board.getOcean().length; i++) {
            builder.append(" ").append(letters[i]).append(" ");
        }

        int numberIndex = 0;
        for (Square[] col: board.getOcean()) {
            builder.append("\n").append(numbers[numberIndex++]).append(" ");
            for (Square cell: col) {
                if (cell.GetSquareStatus() == SquareStatus.SHIP || cell.GetSquareStatus() == SquareStatus.EMPTY)
                    builder.append(cell.GetSquareStatus().getCharacter());
            }
        }

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
        System.out.println(player.getName() + " wins!");
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public void error(String message) {
        System.out.println(message);
        System.out.println("Try again: ");
    }

    public void askCoordinate(ShipType ship) {
        System.out.println("Please provide your " + ship.getLength() + " long ship (" + ship.name() + ") start coordinate");
    }

    public void askDirection() {
        System.out.println("Vertical or horizontal? [v/h] ");
    }
}
