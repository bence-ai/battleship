package java.com.codecool.battleship;

import java.com.codecool.battleship.board.Square;
import java.util.ArrayList;

public class ComputerEasy extends ComputerPlayer {

    public int[] easyComputerRandomShot(Square[][] ocean) {
    ArrayList<Square> nonShotSquares = new ArrayList<>();
        for (Square[] squaresRow: ocean) {
            for (Square squares: squaresRow) {
                if(squares.GetSquareStatus() == '.' || squares.GetSquareStatus() == 'O') {
                    nonShotSquares.add(squares);
                }
            }
        }
        int index = (int) (Math.random() * nonShotSquares.size());
        Square easyShoot = nonShotSquares.get(index);
        int [] shootCoord = new int[2];
        shootCoord[0] = easyShoot.getX();
        shootCoord[1] = easyShoot.getY();
        return shootCoord; // or Square instance depends on what we need...;
        }



}
