
import ui.*;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        BoardUI BoardGui = new BoardUI();
        BoardGui.PrintBoard();

        PiecesUI PieceGui = new PiecesUI();

        JLabel pawnWhite = PieceGui.Pawn(false);
        JLabel pawnBlack = PieceGui.Pawn(true);

        BoardGui.SpawnPiece(pawnBlack,0,6);
        BoardGui.SpawnPiece(pawnWhite,0,1);

    }

}
