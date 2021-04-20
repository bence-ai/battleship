package java.com.codecool.battleship;

import java.com.codecool.battleship.board.Board;
import java.com.codecool.battleship.board.Square;

public class ComputerHard extends ComputerPlayer  {

    public ComputerHard(int size){
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
