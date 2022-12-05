package ui;

import javax.swing.*;
import java.awt.*;
import util.Color;
import pieces.*;

public class PieceUI {

    private ImageIcon pieceImage;
    public Piece piece;

    private int indexX;
    private int indexY;
    private int coordX;
    private int coordY;

    public PieceUI(Piece piece, int indexX, int indexY, int coordX, int coordY) {

        this.piece = piece;
        this.indexX = indexX;
        this.indexY = indexY;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    /*
    public JLabel putPiece(Piece piece) {


        return jPiece;

    }*/
}
