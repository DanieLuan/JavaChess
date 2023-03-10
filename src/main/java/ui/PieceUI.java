package ui;

import board.Board;
import javax.swing.*;

import board.Spot;
import util.Color;
import util.Type;
import util.ImageThreatment;
import pieces.*;

import java.util.LinkedList;

import static ui.BoardUI.JPANEL_HEIGHT;
import static ui.BoardUI.JPANEL_WIDTH;

/**
 * Class that represents a piece in the UI.
 * Has methods to create images and transform it, in addition to having the coords X and Y in the frame.
 */

public class PieceUI extends Piece{

    private ImageIcon pieceImage;
    private int coordUIX;
    private int coordUIY;
    private char posXchar;

    public PieceUI(Color color, Type type, int posX, int posY, int coordUIX, int coordUIY) {
        super(color, type, posX, posY);
        this.pieceImage = new ImageIcon(this.getImagePath());
        this.coordUIX = coordUIX;
        this.coordUIY = coordUIY;
    }

    public PieceUI(Piece piece, int coordUIX, int coordUIY){
        super(piece.getColor(), piece.getType(), piece.getPosX(), piece.getPosY());
        this.pieceImage = new ImageIcon(piece.getImagePath());
        this.coordUIX = coordUIX;
        this.coordUIY = coordUIY;
    }

    /**
     * Method that returns the ImageIcon of the piece.
     * @return pieceImage
     */
    public ImageIcon getPieceImage(){
        this.pieceImage = ImageThreatment.pieceImageResize(pieceImage, JPANEL_WIDTH, JPANEL_HEIGHT);
        return pieceImage;
    }

    /**
     * Method that returns the ready Jlabel of a piece to use.
     * @return
     */
    public JLabel getPieceLabel(){
        JLabel pieceLabel = new JLabel(this.getPieceImage());
        return pieceLabel;
    }

    /**
     * Method that converts the X coordinate of the piece in the board to the X coordinate in the UI.
     * @return char
     */
    public char convertCoordXToChar() {
        posXchar = (char) (97 + this.getPosX());
        return posXchar;
    }
    @Override
    public String toString() {
        return this.getColor() + " " + this.getType() + " (" + convertCoordXToChar() + ", " + (this.getPosY()+1) + ")";
    }

    @Override
    public boolean moveIsValid(int spotPosX, int spotPosY, Piece pieceSelected, Board boardGame) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void calculatePossiblePositions(int x, int y, Board board){
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
