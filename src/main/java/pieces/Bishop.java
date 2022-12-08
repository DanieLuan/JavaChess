package pieces;

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

    //todo: implementar o movimento do bispo
}
