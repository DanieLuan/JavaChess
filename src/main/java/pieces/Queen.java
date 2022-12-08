package pieces;

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

    //todo: implementar o movimento da rainha
}
