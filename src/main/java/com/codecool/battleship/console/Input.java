package com.codecool.battleship.console;

import java.lang.reflect.Type;
import java.util.Scanner;

public class Input {
    private Scanner input = new Scanner(System.in);
    private final Display display = new Display();

    // public int[] selectTarget(Player enemy) {} // TODO

    public int modeSelect() {
        while (true) {
            String mode = input.nextLine();
            if (isValidInteger(mode)) {
                int validInt = Integer.parseInt(mode);
                if (validInt < 3 && validInt >= 0) {
                    return validInt;
                }
            }
            display.error("[Must be an integer between 0-2]");
        }
    }

    public int sizeSelect() {
        while (true) {
            String mode = input.nextLine();
            if (isValidInteger(mode)) {
                int validInt = Integer.parseInt(mode);
                if (validInt < 4 && validInt >= 0) {
                    return validInt;
                }
            } else {
                display.error("[Must be an integer between 0-3]");
            }
        }
    }

    public String isValidName() {
        while (true) {
            String name = input.nextLine();
            if (name.length() < 16 && name.length() > 1) {
                return name;
            } else {
                display.error("[Name cannot be longer than 15 characters!]");
            }
        }
    }

    private boolean isValidInteger(String input) {
        if (input == null) { return false; }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            display.error("Integer expected");
            return false;
        }
        return true;
    }

    public int[] coordinateInput() {
        while (true) {
            String coordinate = input.nextLine();
            char letter = coordinate.charAt(0);
            String c2 = coordinate.substring(1);
            int row = letter - 65;
            int col;
            try {
                col = Integer.parseInt(c2) - 1;
            } catch (NumberFormatException e) {
                display.error("Not a valid coordinate!");
                col = -1;
            }
            if (0 <= row && 0 <= col) {
                return new int[]{row, col};
            }
        }
    }

    public String directionInput() {
        while (true) {
            String direction = input.nextLine();
            if ("v".equals(direction) || "V".equals(direction)) return "v";
            if ("h".equals(direction) || "H".equals(direction)) return "h";
            display.error("Not a valid direction! [v(vertical) or h(horizontal)]");
        }
    }
}
