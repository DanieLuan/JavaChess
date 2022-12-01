package board;

import pieces.*;

public class Spot {

    private int xCoord;
    private int yCoord;

    private Piece currentPiece;

    public Spot(){
        currentPiece = null;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }
}
