package pieces;

import board.Board;
import board.Spot;
import util.Color;
import util.Type;

/**
 * Abstract Class that represent a Queen piece in chess game.
 *
 * @see Piece
 *
 */

public class Queen extends Piece{
    /**
     * Constructor of Queen class.
     * @param color
     * @param posX
     * @param posY
     */
    public Queen(Color color, int posX, int posY) {
        super(color, Type.QUEEN, posX, posY);
    }

    //TODO: implementar o movimento da rainha

    @Override
    public void calculatePossiblePositions(int x, int y, Board board) {
        linearPositions(board, this.getPosX(), this.getPosY());
        diagonalPositions(board, this.getPosX(), this.getPosY());

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
