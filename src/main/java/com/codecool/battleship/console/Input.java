package com.codecool.battleship.console;

import java.lang.reflect.Type;
import java.util.Scanner;

public class Input {
    Scanner input = new Scanner(System.in);
    Display display = new Display();

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

    public boolean isValidInteger(String input) {
        if (input == null) { return false; }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            display.error("Integer expected");
            return false;
        }
        return true;
    }
}
