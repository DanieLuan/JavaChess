package pieces;

import board.Board;
import board.Spot;
import ui.PieceUI;
import util.Color;
import util.Type;

import java.util.LinkedList;

/**
 * Abstract Class that represent the idea of a piece.
 */

public abstract class Piece {

    private Color color;
    private Type type;
    private int posX;
    public LinkedList<Spot> possibleMoves = new LinkedList<>();
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

    public LinkedList<Spot> getPossibleMoves(Board board) {
        possibleMoves.clear();
        calculatePossiblePositions(posX, posY, board);
        return possibleMoves;
    }

    public void diagonalPositions(Board board, int x, int y){
        for(int i = x, j = y; i <= 7 && j <= 7; i++, j++){
            if(board.getPieceInPos(i, j) != this){
                if(board.isOccupied(i, j)){
                    if(board.isEnemy(i, j, this)){
                        possibleMoves.add(new Spot(i, j));
                        break;
                    }
                    break;
                } else {
                    possibleMoves.add(new Spot(i, j));
                }
            }
        }

        for(int i = x, j = y; i >= 0 && j <= 7; i--, j++){
            if(board.getPieceInPos(i, j) != this){
                if(board.isOccupied(i, j)){
                    if(board.isEnemy(i, j, this)){
                        possibleMoves.add(new Spot(i, j));
                        break;
                    }
                    break;
                } else {
                    possibleMoves.add(new Spot(i, j));
                }
            }
        }

        for(int i = x, j = y; i >= 0 && j >= 0; i--, j--){
            if(board.getPieceInPos(i, j) != this){
                if(board.isOccupied(i, j)){
                    if(board.isEnemy(i, j, this)){
                        possibleMoves.add(new Spot(i, j));
                        break;
                    }
                    break;
                } else {
                    possibleMoves.add(new Spot(i, j));
                }
            }
        }

        for(int i = x, j = y; i <= 7 && j >= 0; i++, j--){
            if(board.getPieceInPos(i, j) != this){
                if(board.isOccupied(i, j)){
                    if(board.isEnemy(i, j, this)){
                        possibleMoves.add(new Spot(i, j));
                        break;
                    }
                    break;
                } else {
                    possibleMoves.add(new Spot(i, j));
                }
            }
        }


    }

    public void linearPositions(Board board, int x, int y){
        //Itera da posição da peça até a borda inferior, ou até encontrar uma peça (se for inimigo também adiciona o spot)
        for(int i = y; i >= 0; i--){
            if(board.getPieceInPos(x, i) != this){
                if(board.isOccupied(x, i)){
                    if(board.isEnemy(x, i, this)){
                        possibleMoves.add(new Spot(x, i));
                        break;
                    }
                    break;
                } else {
                    possibleMoves.add(new Spot(x, i));
                }
            }
        }

        //Itera da posição da peça até a borda superior, ou até encontrar uma peça (se for inimigo também adiciona o spot)
        for(int i = y; i <= 7; i++){
            if(board.getPieceInPos(x, i) != this){
                if(board.isOccupied(x, i)){
                    if(board.isEnemy(x, i, this)){
                        possibleMoves.add(new Spot(x, i));
                        break;
                    }
                    break;
                } else {
                    possibleMoves.add(new Spot(x, i));
                }
            }
        }

        for(int i = x; i >= 0; i--){
            if(board.getPieceInPos(i, y) != this){
                if(board.isOccupied(i, y)){
                    if(board.isEnemy(i, y, this)){
                        possibleMoves.add(new Spot(i, y));
                        break;
                    }
                    break;
                } else {
                    possibleMoves.add(new Spot(i, y));
                }
            }
        }

        for(int i = x; i <= 7; i++){
            if(board.getPieceInPos(i, y) != this) {
                if(board.isOccupied(i, y)){
                    if(board.isEnemy(i, y, this)){
                        possibleMoves.add(new Spot(i, y));
                        break;
                    }
                    break;
                } else {
                    possibleMoves.add(new Spot(i, y));
                }
            }
        }

    }

    public abstract void calculatePossiblePositions(int x, int y, Board board);

    public abstract boolean moveIsValid(int spotPosX, int spotPosY, Piece pieceSelected, Board boardGame);

    @Override
    public String toString() {
        return color + " " + type + " (" + posX + ", " + posY + ")";
    }
}
