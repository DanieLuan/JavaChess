package pieces;

import board.Board;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean moveIsValid(int spotPosX, int spotPosY, Piece pieceSelected, Board boardGame) {
        if (boardGame.isOccupied(spotPosX, spotPosY) && boardGame.isEnemy(spotPosX, spotPosY, pieceSelected) && kingValidate(spotPosX, spotPosY, pieceSelected, boardGame)){
            return true;
        } else if (!boardGame.isOccupied(spotPosX, spotPosY) && kingValidate(spotPosX, spotPosY, pieceSelected, boardGame)){
            return true;
        }
        
        return false;
    }
}
