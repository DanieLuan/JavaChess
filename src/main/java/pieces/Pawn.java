package pieces;

import board.Board;
import board.Spot;
import ui.PieceUI;
import util.Color;
import util.Type;

/**
 * Abstract Class that represent a Pawn piece in chess game.
 *
 * @see Piece
 *
 */

public class Pawn extends Piece{

    private static final int START_WHITE_PAWN_SPOT = 1;
    private static final int START_BLACK_PAWN_SPOT = 6;

    /**
     * Constructor of the Pawn class.
     * @param color
     * @param posX
     * @param posY
     */
    public Pawn(Color color, int posX, int posY) {
        super(color, Type.PAWN, posX, posY);
    }

    /**
     * Method that verify the possible moves of the Pawn piece.
     * @param spotPosX
     * @param spotPosY
     * @param pieceSelected
     * @param boardGame
     * @return
     */

    @Override
    public boolean moveIsValid(int spotPosX, int spotPosY, Piece pieceSelected, Board boardGame){
        if (pieceSelected.getColor() == Color.WHITE){
            if (!boardGame.isOccupied(pieceSelected.getPosX(), pieceSelected.getPosY() + 1)){
                if ((pieceSelected.getPosY() == 1 && spotPosY == pieceSelected.getPosY() + 2 && spotPosX == pieceSelected.getPosX() && !boardGame.isOccupied(pieceSelected.getPosX(), pieceSelected.getPosY() + 1)) || (spotPosY == pieceSelected.getPosY() + 1) && spotPosX == pieceSelected.getPosX()){
                    return true;
                }
            }
        } else {
            if (!boardGame.isOccupied(pieceSelected.getPosX(), pieceSelected.getPosY() - 1)){
                if ((pieceSelected.getPosY() == 6 && spotPosY == pieceSelected.getPosY() - 2 && spotPosX == pieceSelected.getPosX()) || (spotPosY == pieceSelected.getPosY() - 1) && spotPosX == pieceSelected.getPosX()){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method that calculates the possible moves of the Pawn piece.
     * @param x
     * @param y
     * @param board
     */
    @Override
    public void calculatePossiblePositions(int x, int y, Board board) {
        if(this.getColor() == Color.WHITE){
            if(this.getPosY() == START_WHITE_PAWN_SPOT){
                if(!board.isOccupied(this.getPosX(), this.getPosY()+1)){
                    possibleMoves.add(new Spot(x, y+1));
                }
                if(!board.isOccupied(this.getPosX(), this.getPosY()+2)){
                    possibleMoves.add(new Spot(x, y+2));
                }
            } else {
                if(!board.isOccupied(x, y+1)){
                    possibleMoves.add(new Spot(x, y+1));
                }
                if(board.isEnemy(x+1, y+1, this)){
                    possibleMoves.add(new Spot(x+1, y+1));
                }
                if(board.isEnemy(x-1, y+1, this)){
                    possibleMoves.add(new Spot(x-1, y+1));
                }
            }
        } else {
            if(this.getPosY() == START_BLACK_PAWN_SPOT){
                if(!board.isOccupied(this.getPosX(), this.getPosY()-1)){
                    possibleMoves.add(new Spot(x, y-1));
                }
                if(!board.isOccupied(this.getPosX(), this.getPosY()-2)){
                    possibleMoves.add(new Spot(x, y-2));
                }
            } else {
                if(!board.isOccupied(x, y-1)){
                    possibleMoves.add(new Spot(x, y-1));
                }
                if(board.isEnemy(x+1, y-1, this)){
                    possibleMoves.add(new Spot(x+1, y-1));
                }
                if(board.isEnemy(x-1, y-1, this)){
                    possibleMoves.add(new Spot(x-1, y-1));
                }
            }
        }

    }

    /**
     * Method that verify if the Pawn piece can kill another piece.
     * @param spotPosx
     * @param spotposy
     * @param pieceSelected
     * @return
     */
    public boolean captureIsValid(int spotPosx, int spotposy, PieceUI pieceSelected){
        if (pieceSelected.getColor() == Color.WHITE){
            if ((spotposy == pieceSelected.getPosY() + 1 && spotPosx == pieceSelected.getPosX() - 1) || (spotposy == pieceSelected.getPosY() + 1 && spotPosx == pieceSelected.getPosX() + 1)){
                return true;
            }
        } else {
            if ((spotposy == pieceSelected.getPosY() - 1 && spotPosx == pieceSelected.getPosX() -1) || spotposy == pieceSelected.getPosY() - 1 && spotPosx == pieceSelected.getPosX() + 1){
                return true;
            }
        }
        
        return false;
    }
}
