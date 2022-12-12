package board;
import pieces.*;

public class Spot {

    private int xPos;
    private int yPos;

    private Piece currentPiece;

    //Constructor
    public Spot(int xPos, int yPos, Piece currentPiece) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.currentPiece = currentPiece;
    }

    //Getters
    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }
}
