package pieces;

import util.Color;
import util.Type;

public class Queen extends Piece{
    public Queen(Color color, int posX, int posY) {
        super(color, Type.QUEEN, posX, posY);
    }
}
