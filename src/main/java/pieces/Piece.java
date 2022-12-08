package pieces;

import util.Color;
import util.Type;

public abstract class Piece {

    private Color color;
    private Type type;
    private int posX;

    private int posY;

    //abstract public void move();
    //ver como fazer o movimento da peça seguindo as regras do jogo

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

    public void move(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public String toString() {
        return color + " " + type + " (" + posX + ", " + posY + ")";
    }

    public Piece getPiece() {
        return this;
    }

    public char getSymbol(){
        char symbol = ' ';
        switch (type) {
            case PAWN:
                symbol = 'P';
                break;
            case KING:
                symbol = 'K';
                break;
            case QUEEN:
                symbol = 'Q';
                break;
            case BISHOP:
                symbol = 'B';
                break;
            case ROOK:
                symbol = 'R';
                break;
            case KNIGHT:
                symbol = 'N';
                break;
        }
        return symbol;
    }
}
