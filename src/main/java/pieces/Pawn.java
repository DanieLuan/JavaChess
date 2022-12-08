package pieces;

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

    //todo: implementar o movimento do peão
}
