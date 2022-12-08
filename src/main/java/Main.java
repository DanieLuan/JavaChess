import ui.*;
import board.*;
import pieces.*;
import util.*;

import util.Color;
import pieces.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Board board = new Board();

        BoardUI boardUI = new BoardUI(board);

        boardUI.CreateBoard();
        boardUI.spawnPiecesStarter();



    }

}
