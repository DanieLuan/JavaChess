package pieces;

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
}
