package pieces;

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
}
