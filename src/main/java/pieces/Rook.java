package pieces;

import board.Board;
import board.Spot;
import util.Color;
import util.Type;

/**
 * Abstract Class that represent a Rook piece in chess game.
 *
 * @see Piece
 *
 */

public class Rook extends Piece{
    /**
     * Constructor of the Rook class.
     * @param color
     * @param posX
     * @param posY
     */
    public Rook(Color color, int posX, int posY) {
        super(color, Type.ROOK, posX, posY);
    }

    @Override
    public void calculatePossiblePositions(int x, int y, Board board){
        linearPositions(board, this.getPosX(), this.getPosY());
    }

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
