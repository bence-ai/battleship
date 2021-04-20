package java.com.codecool.battleship.board;

import java.com.codecool.battleship.Player;
import java.util.Random;
import java.util.Scanner;

public class BoardFactory {
    public Board randomPlacement(Player player) {
        Random rand = new Random();
        int verticalOrHorizontal = rand.nextInt(2);
        if (verticalOrHorizontal == 0) {

        }



    return null; //this is under construction :)
    }

    public Board manualPlacement(Player player) {
//        Scanner manualPlacement = new Scanner(System.in);
        return null; //this is under construction :)
    }

}
