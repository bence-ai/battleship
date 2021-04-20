package java.com.codecool.battleship;

import java.com.codecool.battleship.board.Board;
import java.com.codecool.battleship.board.Square;
import java.util.ArrayList;

public class ComputerEasy extends ComputerPlayer {


    public ComputerEasy(int size){
        super.ocean = new Board(size);
        generateName();

    }

    // chooses a random square which is empty or a ship and returns its coordinates in an int[] array.
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
        int [] shootCoordinate = new int[2];
        shootCoordinate[0] = easyShoot.getX();
        shootCoordinate[1] = easyShoot.getY();
        return shootCoordinate; // or Square instance depends on what we need...;
        }

    @Override
    public void generateName() {
        super.generateName();
    }
}
