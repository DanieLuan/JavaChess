package pieces;

import util.Color;
import util.Type;

/**
 * Abstract Class that represent the idea of a piece.
 */

public abstract class Piece {

    private Color color;
    private Type type;
    private int posX;

    private int posY;

    /**
     * Constructor of the Piece class.
     * @param color
     * @param type
     * @param posX
     * @param posY
     */
    public Piece(Color color, Type type, int posX, int posY) {
        this.color = color;
        this.type = type;
        this.posX = posX;
        this.posY = posY;

    }

    public String getImagePath() {
        String filepath = "resources/";
        switch (type) {
            case PAWN:
                filepath += "pawn_";
                break;
            case KING:
                filepath += "king_";
                break;
            case QUEEN:
                filepath += "queen_";
                break;
            case BISHOP:
                filepath += "bishop_";
                break;
            case ROOK:
                filepath += "rook_";
                break;
            case KNIGHT:
                filepath += "knight_";
                break;
        }

        switch (color) {
            case BLACK:
                filepath += "black";
                break;
            case WHITE:
                filepath += "white";
                break;
        }
        filepath += ".png";
        return filepath;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public int getPosX() { return posX; }

    public int getPosY() { return posY; }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Method that checks if the piece can move to a given position.
     * @param posX
     * @param posY
     */
    public void move(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public String toString() {
        return color + " " + type + " (" + posX + ", " + posY + ")";
    }
}
