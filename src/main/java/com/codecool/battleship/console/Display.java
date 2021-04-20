package com.codecool.battleship.console;

import com.codecool.battleship.Player;
import com.codecool.battleship.board.Square;

public class Display {
    public void printMenu() {
        clearScreen();
        System.out.println("BATTLESHIP DESTROYER\n\n 1. Player vs. Player\n 2. Player vs. Computer\n 0. Exit");
    }

    public void printSize() {
        clearScreen();
        System.out.println("BOARD SIZE\n\n 1. Small\n 2. Medium\n 3. Large\n 0. Back");
    }

    public void setName() {
        clearScreen();
        System.out.println("NAME CREATION\n\nChoose your name [max 15 characters]: ");
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
                board.append(" ").append(cell.getSquareStatus()).append(" ");
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

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public void error(String message) {
        System.out.println(message);
        System.out.println("Try again: ");
    }
}
