package pieces;

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
    public boolean moveIsValid(int spotPosx, int spotPosy, PieceUI pieceSelected){
        if (pieceSelected.getColor() == Color.WHITE){
            if ((pieceSelected.getPosY() == 1 && spotPosy == pieceSelected.getPosY() + 2 && spotPosx == pieceSelected.getPosX()) || (spotPosy == pieceSelected.getPosY() + 1) && spotPosx == pieceSelected.getPosX()){
                return true;
            }    
        } else {
            if ((pieceSelected.getPosY() == 6 && spotPosy == pieceSelected.getPosY() - 2 && spotPosx == pieceSelected.getPosX()) || (spotPosy == pieceSelected.getPosY() - 1) && spotPosx == pieceSelected.getPosX()){
                return true;
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
