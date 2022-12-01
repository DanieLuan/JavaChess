
import ui.*;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Projeto iniciando, primeiros commits. :D");
        BoardUI BoardGui = new BoardUI();
        BoardGui.PrintBoard();

        PiecesUI PieceGui = new PiecesUI();

        JLabel pieceToSpawn = PieceGui.Pawn(false);

        BoardGui.SpawnPiece(pieceToSpawn,0,0);
    }

}
