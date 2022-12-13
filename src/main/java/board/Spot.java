package board;
import pieces.*;

public class Spot {
    private int posX;
    private int posY;
    private Piece currentPiece;

    public Spot(int xPos, int yPos) {
        this.posX = xPos;
        this.posY = yPos;
        this.currentPiece = null;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    //toString method
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

    public boolean equals(Spot spot) {
        return spot.getPosX() == this.getPosX() && spot.getPosY() == this.getPosY();
    }


}
