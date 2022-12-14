package pieces;

import board.Board;
import board.Spot;
import util.Color;
import util.Type;

/**
 * Abstract Class that represent a Knight piece in chess game.
 *
 * @see Piece
 *
 */

public class Knight extends Piece {

    /**
     * Constructor of the Knight class.
     * @param color
     * @param posX
     * @param posY
     */

    public Knight(Color color, int posX, int posY) {
        super(color, Type.KNIGHT, posX, posY);
    }

    /**
     * Method that calculates the possible moves of the Knight piece.
     * @param x
     * @param y
     * @param board
     */
    @Override
    public void calculatePossiblePositions(int x, int y, Board board) {
        if(moveIsValid(x + 1, y + 2, this, board)){
            possibleMoves.add(new Spot(x + 1, y + 2));
        }
        if(moveIsValid(x + 2, y + 1, this, board)){
            possibleMoves.add(new Spot(x + 2, y + 1));
        }
        if(moveIsValid(x + 2, y - 1, this, board)){
            possibleMoves.add(new Spot(x + 2, y - 1));
        }
        if(moveIsValid(x + 1, y - 2, this, board)){
            possibleMoves.add(new Spot(x + 1, y - 2));
        }
        if(moveIsValid(x - 1, y - 2, this, board)){
            possibleMoves.add(new Spot(x - 1, y - 2));
        }
        if(moveIsValid(x - 2, y - 1, this, board)){
            possibleMoves.add(new Spot(x - 2, y - 1));
        }
        if(moveIsValid(x - 2, y + 1, this, board)){
            possibleMoves.add(new Spot(x - 2, y + 1));
        }
        if(moveIsValid(x - 1, y + 2, this, board)){
            possibleMoves.add(new Spot(x - 1, y + 2));
        }

    }

    /**
     * Method that verify if the knight can move to the position (x, y).
     * @param spotPosX
     * @param spotPosY
     * @param pieceSelected
     * @param boardGame
     * @return
     */
    @Override
    public boolean moveIsValid(int spotPosX, int spotPosY, Piece pieceSelected, Board boardGame) {
        if(spotPosX < 0 || spotPosX > 7 || spotPosY < 0 || spotPosY > 7){
            return false;
        }
        if(knightMoveValidator(spotPosX, spotPosY, pieceSelected)){
            if(!boardGame.isOccupied(spotPosX, spotPosY)){
                return true;
            } else {
                if(boardGame.isEnemy(spotPosX, spotPosY, pieceSelected)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method that verify if the knight can move to the position (x, y).
     * @param spotPosX
     * @param spotPosY
     * @param pieceSelected
     * @return
     */
    private boolean knightMoveValidator(int spotPosX, int spotPosY, Piece pieceSelected) {
        if ((spotPosX == pieceSelected.getPosX() - 1) && (spotPosY == pieceSelected.getPosY() + 2)) {
            possibleMoves.add(new Spot(pieceSelected.getPosX()-1, pieceSelected.getPosY()+2));
            return true;
        } else if ((spotPosX == pieceSelected.getPosX() + 1) && (spotPosY == pieceSelected.getPosY() + 2)) {
            possibleMoves.add(new Spot(pieceSelected.getPosX()+1, pieceSelected.getPosY()+2));
            return true;
        } else if ((spotPosX == pieceSelected.getPosX() - 2) && (spotPosY == pieceSelected.getPosY() + 1)) {
            possibleMoves.add(new Spot(pieceSelected.getPosX()-2, pieceSelected.getPosY()+1));
            return true;
        } else if ((spotPosX == pieceSelected.getPosX() + 2) && (spotPosY == pieceSelected.getPosY() + 1)) {
            possibleMoves.add(new Spot(pieceSelected.getPosX()+2, pieceSelected.getPosY()+1));
            return true;
        } else if ((spotPosX == pieceSelected.getPosX() - 2) && (spotPosY == pieceSelected.getPosY() - 1)) {
            possibleMoves.add(new Spot(pieceSelected.getPosX()-2, pieceSelected.getPosY()-1));
            return true;
        } else if ((spotPosX == pieceSelected.getPosX() + 2) && (spotPosY == pieceSelected.getPosY() - 1)) {
            possibleMoves.add(new Spot(pieceSelected.getPosX()+2, pieceSelected.getPosY()-1));
            return true;
        } else if ((spotPosX == pieceSelected.getPosX() - 1) && (spotPosY == pieceSelected.getPosY() - 2)) {
            possibleMoves.add(new Spot(pieceSelected.getPosX()-1, pieceSelected.getPosY()-2));
            return true;
        } else if ((spotPosX == pieceSelected.getPosX() + 1) && (spotPosY == pieceSelected.getPosY() - 2)) {
            possibleMoves.add(new Spot(pieceSelected.getPosX()+1, pieceSelected.getPosY()-2));
            return true;
        }
        return false;
    }




}