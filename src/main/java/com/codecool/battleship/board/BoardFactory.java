package com.codecool.battleship.board;

import com.codecool.battleship.Player;
import java.util.Random;

public class BoardFactory {
    public Board randomPlacement(Player player) {
        Random rand = new Random();
        int verticalOrHorizontal = rand.nextInt(2);
        if (verticalOrHorizontal == 0) {
            return null;
        }

    return null; //this is under construction :)
    }

    public Board manualPlacement(Player player) {
//        Scanner manualPlacement = new Scanner(System.in);
        return null; //this is under construction :)
    }

}
