package board;
import pieces.*;

/**
 * Class that represents a spot in the chess board.
 */

public class Spot {
    private int posX;
    private int posY;
    private Piece currentPiece;

    /**
     * Constructor of the spot.
     * @param xPos
     * @param yPos
     */
    public Spot(int xPos, int yPos) {
        this.posX = xPos;
        this.posY = yPos;
        this.currentPiece = null;
    }

    /**
     * Method that returns the x position of the spot.
     * @return x position of the spot.
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Method that returns the y position of the spot.
     * @return y position of the spot.
     */
    public int getPosY() {
        return posY;
    }

    @Override
    public String toString() {
        return "(" + posX + ", " + posY + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(obj instanceof Spot) {
            Spot spot = (Spot) obj;
            return spot.getPosX() == this.getPosX() && spot.getPosY() == this.getPosY();
        }
        return false;
    }

}
