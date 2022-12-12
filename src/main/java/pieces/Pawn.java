package pieces;

import board.Board;
import ui.PieceUI;
import util.Color;
import util.Type;

/**
 * Abstract Class that represent a Pawn piece in chess game.
 *
 * @see Piece
 *
 */

public class Pawn extends Piece{

    /**
     * Constructor of the Pawn class.
     * @param color
     * @param posX
     * @param posY
     */
    public Pawn(Color color, int posX, int posY) {
        super(color, Type.PAWN, posX, posY);
    }

    //TODO: implementar o movimento do peão

    /**
     *
     * @param spotPosX
     * @param spotPosY
     * @param pieceSelected
     * @param boardGame
     * @return
     */
    @Override
    public boolean moveIsValid(int spotPosX, int spotPosY, Piece pieceSelected, Board boardGame){
        if (pieceSelected.getColor() == Color.WHITE){
            if (!boardGame.isOccupied(pieceSelected.getPosX(), pieceSelected.getPosY() + 1)){
                if ((pieceSelected.getPosY() == 1 && spotPosY == pieceSelected.getPosY() + 2 && spotPosX == pieceSelected.getPosX() && !boardGame.isOccupied(pieceSelected.getPosX(), pieceSelected.getPosY() + 1)) || (spotPosY == pieceSelected.getPosY() + 1) && spotPosX == pieceSelected.getPosX()){
                    return true;
                }
            }
        } else {
            if (!boardGame.isOccupied(pieceSelected.getPosX(), pieceSelected.getPosY() - 1)){
                if ((pieceSelected.getPosY() == 6 && spotPosY == pieceSelected.getPosY() - 2 && spotPosX == pieceSelected.getPosX()) || (spotPosY == pieceSelected.getPosY() - 1) && spotPosX == pieceSelected.getPosX()){
                    return true;
                }
            }
        }
        
        
        return false;
    }
    
    public boolean captureIsValid(int spotPosx, int spotposy, PieceUI pieceSelected){
        if (pieceSelected.getColor() == Color.WHITE){
            if ((spotposy == pieceSelected.getPosY() + 1 && spotPosx == pieceSelected.getPosX() - 1) || (spotposy == pieceSelected.getPosY() + 1 && spotPosx == pieceSelected.getPosX() + 1)){
                return true;
            }
        } else {
            if ((spotposy == pieceSelected.getPosY() - 1 && spotPosx == pieceSelected.getPosX() -1) || spotposy == pieceSelected.getPosY() - 1 && spotPosx == pieceSelected.getPosX() + 1){
                return true;
            }
        }
        
        return false;
    }
}
