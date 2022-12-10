package pieces;

import util.Color;
import util.Type;

/**
 * Abstract Class that represent a Knight piece in chess game.
 *
 * @see Piece
 *
 */

public class Knight extends Piece {

    /**
     * Constructor of the Knight class.
     * @param color
     * @param posX
     * @param posY
     */

    public Knight(Color color, int posX, int posY) {
        super(color, Type.KNIGHT, posX, posY);
    }

    //TODO: implementar o movimento do cavalo
}
