package pieces;

import board.Board;
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

    @Override
    public boolean moveIsValid(int spotPosX, int spotPosY, Piece pieceSelected, Board boardGame) {
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

    private boolean knightMoveValidator(int spotPosX, int spotPosY, Piece pieceSelected) {
        if ((spotPosX == pieceSelected.getPosX() - 1) && (spotPosY == pieceSelected.getPosY() + 2)) {
            return true;
        } else if ((spotPosX == pieceSelected.getPosX() + 1) && (spotPosY == pieceSelected.getPosY() + 2)) {
            return true;
        } else if ((spotPosX == pieceSelected.getPosX() - 2) && (spotPosY == pieceSelected.getPosY() + 1)) {
            return true;
        } else if ((spotPosX == pieceSelected.getPosX() + 2) && (spotPosY == pieceSelected.getPosY() + 1)) {
            return true;
        } else if ((spotPosX == pieceSelected.getPosX() - 2) && (spotPosY == pieceSelected.getPosY() - 1)) {
            return true;
        } else if ((spotPosX == pieceSelected.getPosX() + 2) && (spotPosY == pieceSelected.getPosY() - 1)) {
            return true;
        } else if ((spotPosX == pieceSelected.getPosX() - 1) && (spotPosY == pieceSelected.getPosY() - 2)) {
            return true;
        } else if ((spotPosX == pieceSelected.getPosX() + 1) && (spotPosY == pieceSelected.getPosY() - 2)) {
            return true;
        }
        return false;
    }




}