package ui;

import javax.swing.*;

import util.Color;
import util.Type;
import util.ImageThreatment;
import pieces.*;

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

    public JLabel getPieceLabel(){
        JLabel pieceLabel = new JLabel(this.getPieceImage());
        return pieceLabel;
    }

    public int getCoordUIX() {
        return coordUIX;
    }

    public void setCoordUIX(int coordUIX) {
        this.coordUIX = coordUIX;
    }

    public int getCoordUIY() {
        return coordUIY;
    }

    public void setCoordUIY(int coordUIY) {
        this.coordUIY = coordUIY;
    }

    public char convertCoordXToChar() {
        posXchar = (char) (97 + this.getPosX());
        return posXchar;
    }
    @Override
    public String toString() {
        return this.getColor() + " " + this.getType() + " (" + convertCoordXToChar() + ", " + (this.getPosY()+1) + ")";
    }


}
