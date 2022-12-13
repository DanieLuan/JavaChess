package pieces;

import board.Board;
import board.Spot;
import util.Color;
import util.Type;

/**
 * Abstract Class that represent a King piece in chess game.
 *
 * @see Piece
 */

public class King extends Piece{

    /**
     * Constructor of the King class.
     * @param color
     * @param posX
     * @param posY
     */
    public King(Color color, int posX, int posY) {
        super(color, Type.KING, posX, posY);
    }

    //TODO: implementar o movimento do rei



    @Override
    public void calculatePossiblePositions(int x, int y, Board board) {
        kingValidate(x,y,this,board);
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
