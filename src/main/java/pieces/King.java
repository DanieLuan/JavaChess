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

    public boolean kingValidate(int spotPosX, int spotPosY, Piece pieceSelected, Board boardGame){
        if (spotPosX == pieceSelected.getPosX() - 1 && spotPosY == pieceSelected.getPosY() + 1){
            return true;
        } else if (spotPosX == pieceSelected.getPosX() && spotPosY == pieceSelected.getPosY() + 1){
            return true;
        } else if (spotPosX == pieceSelected.getPosX() + 1 && spotPosY == pieceSelected.getPosY() + 1){
            return true;
        } else if (spotPosX == pieceSelected.getPosX() - 1 && spotPosY == pieceSelected.getPosY()){
            return true;
        } else if (spotPosX == pieceSelected.getPosX() + 1 && spotPosY == pieceSelected.getPosY()){
            return true;
        } else if (spotPosX == pieceSelected.getPosX() - 1 && spotPosY == pieceSelected.getPosY() - 1){
            return true;
        } else if (spotPosX == pieceSelected.getPosX() && spotPosY == pieceSelected.getPosY() - 1){
            return true;
        } else if (spotPosX == pieceSelected.getPosX() + 1 && spotPosY == pieceSelected.getPosY() - 1){
            return true;
        }
        return false;
    }

    @Override
    public void calculatePossiblePositions(int x, int y, Board board) {
        kingValidate(x, y, this, board);


    }

    @Override
    public boolean moveIsValid(int spotPosX, int spotPosY, Piece pieceSelected, Board boardGame) {
        for (Spot spot : this.getPossibleMoves(boardGame)) {
            if (spotPosX == spot.getPosX() && spotPosY == spot.getPosY()){
                return true;
            }
        }
        return false;
    }
}
