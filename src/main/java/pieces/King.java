package pieces;

import board.Board;
import board.Spot;
import util.Color;
import util.Type;

import java.util.LinkedList;

/**
 * Abstract Class that represent a King piece in chess game.
 *
 * @see Piece
 */

public class King extends Piece{

    /**
     * Constructor of the King class.
     * @param color
     * @param posX
     * @param posY
     */
    public King(Color color, int posX, int posY) {
        super(color, Type.KING, posX, posY);
    }

    /**
     * Method that calculates the possible moves of the King piece.
     * @param x
     * @param y
     * @param board
     */
    @Override
    public void calculatePossiblePositions(int x, int y, Board board) {
        kingValidate(x,y,this,board);

        LinkedList<Spot> allKingEnemiesMovements = new LinkedList<>();
        for (Piece piece : board.piecesInGame) {
            if(piece.getColor() != this.getColor() && piece.getType() != Type.KING){
                allKingEnemiesMovements.addAll(piece.getPossibleMoves(board));
            }
        }

        LinkedList<Spot> toRemove = new LinkedList<>();
        for(Spot spot : possibleMoves){
            for(Spot spot1 : allKingEnemiesMovements){
                if(spot.getPosX() == spot1.getPosX() && spot.getPosY() == spot1.getPosY()){
                    toRemove.add(spot);
                }
            }
        }

        possibleMoves.removeAll(toRemove);

    }

    /**
     * Method that verify if the king can move to the position (x, y).
     * @param spotPosX
     * @param spotPosY
     * @param pieceSelected
     * @param boardGame
     * @return
     */
    @Override
    public boolean moveIsValid(int spotPosX, int spotPosY, Piece pieceSelected, Board boardGame) {
        for(Spot spot : pieceSelected.getPossibleMoves(boardGame)){
            if(spot.getPosX() == spotPosX && spot.getPosY() == spotPosY){
                return true;
            }
        }
        return false;
    }

    /**
     * Method that verify the possible moves of the King piece and adds to possibleMoves.
     * @param x
     * @param y
     * @param pieceSelected
     * @param board
     */
    private void kingValidate(int x, int y, Piece pieceSelected, Board board){
        int i = x;
        int j = y;
        if(board.getPieceInPos(i+1, j+1) != this){
            if(board.isOccupied(i+1, j+1)){
                if(board.isEnemy(i+1, j+1, this)){
                    possibleMoves.add(new Spot(i+1, j+1));
                }
            } else {
                possibleMoves.add(new Spot(i+1, j+1));
            }
        }
        if(board.getPieceInPos(i-1, j+1) != this){
            if(board.isOccupied(i-1, j+1)){
                if(board.isEnemy(i-1, j+1, this)){
                    possibleMoves.add(new Spot(i-1, j+1));

                }

            } else {
                possibleMoves.add(new Spot(i-1, j+1));
            }
        }
        if(board.getPieceInPos(i-1, j-1) != this){
            if(board.isOccupied(i-1, j-1)){
                if(board.isEnemy(i-1, j-1, this)){
                    possibleMoves.add(new Spot(i-1, j-1));

                }

            } else {
                possibleMoves.add(new Spot(i-1, j-1));
            }
        }
        if(board.getPieceInPos(i+1, j-1) != this){
            if(board.isOccupied(i+1, j-1)){
                if(board.isEnemy(i+1,j-1, this)){
                    possibleMoves.add(new Spot(i+1, j-1));

                }
            } else {
                possibleMoves.add(new Spot(i+1,j-1));
            }
        }

        i = x;
        j = y;
        if(board.getPieceInPos(i, j-1) != this){
            if(board.isOccupied(i, j-1)){
                if(board.isEnemy(i, j-1, this)){
                    possibleMoves.add(new Spot(i, j-1));

                }

            } else {
                possibleMoves.add(new Spot(i, j-1));
            }
        }

        if(board.getPieceInPos(i, j+1) != this){
            if(board.isOccupied(i, j+1)){
                if(board.isEnemy(i, j+1, this)){
                    possibleMoves.add(new Spot(i, j+1));

                }

            } else {
                possibleMoves.add(new Spot(i, j+1));
            }
        }

        if(board.getPieceInPos(i-1, j) != this){
            if(board.isOccupied(i-1, j)){
                if(board.isEnemy(i-1, j, this)){
                    possibleMoves.add(new Spot(i-1, j));

                }

            } else {
                possibleMoves.add(new Spot(i-1, j));
            }
        }

        if(board.getPieceInPos(i+1, j) != this){
            if(board.isOccupied(i+1, j)){
                if(board.isEnemy(i+1, j, this)){
                    possibleMoves.add(new Spot(i+1, j));

                }

            } else {
                possibleMoves.add(new Spot(i+1, j));
            }
        }
    }
}
