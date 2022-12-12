package pieces;

import board.Board;
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

    //TODO: implementar o movimento da torre

    @Override
    public boolean moveIsValid(int spotPosX, int spotPosY, Piece pieceSelected, Board boardGame) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
