package pieces;

import board.Board;
import board.Spot;
import util.Color;
import util.Type;

/**
 * Abstract Class that represent a Bishop piece in chess game.
 *
 * @see Piece
 *
 */

public class Bishop extends Piece {

    /**
     * Constructor of the Bishop class.
     * @param color
     * @param posX
     * @param posY
     */
    public Bishop(Color color, int posX, int posY) {
        super(color, Type.BISHOP, posX, posY);
    }

    /**
     * Method that calculates the possible moves of the Bishop piece.
     * @param x
     * @param y
     * @param board
     */
    @Override
    public void calculatePossiblePositions(int x, int y, Board board) {
        diagonalPositions(board, this.getPosX(), this.getPosY());
    }

    /**
     * Method that verify if the bishop can move to the position (x, y).
     * @param spotPosX
     * @param spotPosY
     * @param pieceSelected
     * @param boardGame
     * @return boolean
     */
    @Override
    public boolean moveIsValid(int spotPosX, int spotPosY, Piece pieceSelected, Board boardGame) {
        for(Spot spot : pieceSelected.getPossibleMoves(boardGame)){
            if(spot.getPosX() == spotPosX && spot.getPosY() == spotPosY){
                return true;
            }
        }
        return false;
    }
}
