
import ui.*;
import board.*;
import pieces.*;
import util.*;

import util.Color;
import pieces.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        BoardUI BoardGui = new BoardUI(board);
        PieceUI PieceGui = new PieceUI();

        BoardGui.PrintBoard();
        BoardGui.spawnPiecesStarter();


        //JLabel pawnWhite = PieceGui.Pawn(Color.WHITE);
        //JLabel pawnBlack = PieceGui.Pawn(Color.BLACK);



    }

}
