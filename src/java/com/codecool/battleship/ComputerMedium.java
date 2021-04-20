package java.com.codecool.battleship;

import java.com.codecool.battleship.board.Board;
import java.com.codecool.battleship.board.Square;

public class ComputerMedium extends ComputerPlayer  {

    public ComputerMedium(int size){
        super.ocean = new Board(size);
        generateName();
    }

    @Override
    public int[] easyComputerRandomShot(Square[][] ocean) {
        return new int[0];
    }

    @Override
    public void generateName() {
        super.generateName();
    }
}
