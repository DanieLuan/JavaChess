package board;

import java.util.LinkedList;

import pieces.Piece;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;
import util.Color;
import util.Type;

import game.GameRules;
/**
 * Class that represent the chess board.
 * The pieces are stored in a LinkedList of Pieces and use the
 * ideia of sparse matrix, only storing the pieces that exists
 * in the board.
 */

public class Board {

    public static final int BOARD_SIZE = 8;
    public LinkedList<Piece> piecesInGame;
    public GameRules rules =  new GameRules();

    public Board(){
        piecesInGame = new LinkedList<>();

        //createStartersPieces();
        debugBoard();
    }

    /**
     * Method that create the pieces in the start of the game.
     */
    private void createStartersPieces(){
        Piece wPawn1 = new Pawn(util.Color.WHITE, 0, 1);
        piecesInGame.add(wPawn1);
        Piece wPawn2 = new Pawn(util.Color.WHITE, 1, 1);
        piecesInGame.add(wPawn2);
        Piece wPawn3 = new Pawn(util.Color.WHITE, 2, 1);
        piecesInGame.add(wPawn3);
        Piece wPawn4 = new Pawn(util.Color.WHITE, 3, 1);
        piecesInGame.add(wPawn4);
        Piece wPawn5 = new Pawn(util.Color.WHITE, 4, 1);
        piecesInGame.add(wPawn5);
        Piece wPawn6 = new Pawn(util.Color.WHITE, 5, 1);
        piecesInGame.add(wPawn6);
        Piece wPawn7 = new Pawn(util.Color.WHITE, 6, 1);
        piecesInGame.add(wPawn7);
        Piece wPawn8 = new Pawn(util.Color.WHITE, 7, 1);
        piecesInGame.add(wPawn8);
        Piece wRook1 = new Rook(util.Color.WHITE, 0, 0);
        piecesInGame.add(wRook1);
        Piece wRook2 = new Rook(util.Color.WHITE, 7, 0);
        piecesInGame.add(wRook2);
        Piece wKnight1 = new Knight(util.Color.WHITE, 1, 0);
        piecesInGame.add(wKnight1);
        Piece wKnight2 = new Knight(util.Color.WHITE, 6, 0);
        piecesInGame.add(wKnight2);
        Piece wBishop1 = new Bishop(util.Color.WHITE, 2, 0);
        piecesInGame.add(wBishop1);
        Piece wBishop2 = new Bishop(util.Color.WHITE, 5, 0);
        piecesInGame.add(wBishop2);
        Piece wQueen = new Queen(util.Color.WHITE, 3, 0);
        piecesInGame.add(wQueen);
        Piece wKing = new King(util.Color.WHITE, 4, 0);
        piecesInGame.add(wKing);

        Piece bPawn1 = new Pawn(util.Color.BLACK, 0, 6);
        piecesInGame.add(bPawn1);
        Piece bPawn2 = new Pawn(util.Color.BLACK, 1, 6);
        piecesInGame.add(bPawn2);
        Piece bPawn3 = new Pawn(util.Color.BLACK, 2, 6);
        piecesInGame.add(bPawn3);
        Piece bPawn4 = new Pawn(util.Color.BLACK, 3, 6);
        piecesInGame.add(bPawn4);
        Piece bPawn5 = new Pawn(util.Color.BLACK, 4, 6);
        piecesInGame.add(bPawn5);
        Piece bPawn6 = new Pawn(util.Color.BLACK, 5, 6);
        piecesInGame.add(bPawn6);
        Piece bPawn7 = new Pawn(util.Color.BLACK, 6, 6);
        piecesInGame.add(bPawn7);
        Piece bPawn8 = new Pawn(util.Color.BLACK, 7, 6);
        piecesInGame.add(bPawn8);
        Piece bRook1 = new Rook(util.Color.BLACK, 0, 7);
        piecesInGame.add(bRook1);
        Piece bRook2 = new Rook(util.Color.BLACK, 7, 7);
        piecesInGame.add(bRook2);
        Piece bKnight1 = new Knight(util.Color.BLACK, 1, 7);
        piecesInGame.add(bKnight1);
        Piece bKnight2 = new Knight(util.Color.BLACK, 6, 7);
        piecesInGame.add(bKnight2);
        Piece bBishop1 = new Bishop(util.Color.BLACK, 2, 7);
        piecesInGame.add(bBishop1);
        Piece bBishop2 = new Bishop(util.Color.BLACK, 5, 7);
        piecesInGame.add(bBishop2);
        Piece bQueen = new Queen(util.Color.BLACK, 3, 7);
        piecesInGame.add(bQueen);
        Piece bKing = new King(util.Color.BLACK, 4, 7);
        piecesInGame.add(bKing);
    }

    private void debugBoard(){
        Piece wPawn8 = new Pawn(util.Color.WHITE, 6, 1);
        piecesInGame.add(wPawn8);
        Piece wRook1 = new Rook(util.Color.WHITE, 1, 1);
        piecesInGame.add(wRook1);
        Piece wKnight1 = new Knight(util.Color.WHITE, 2, 1);
        piecesInGame.add(wKnight1);
        Piece wBishop1 = new Bishop(util.Color.WHITE, 3, 1);
        piecesInGame.add(wBishop1);
        Piece wQueen = new Queen(util.Color.WHITE, 4, 1);
        piecesInGame.add(wQueen);
        Piece wKing = new King(util.Color.WHITE, 5, 1);
        piecesInGame.add(wKing);

        Piece bPawn8 = new Pawn(util.Color.BLACK, 6, 6);
        piecesInGame.add(bPawn8);
        Piece bRook1 = new Rook(util.Color.BLACK, 1, 6);
        piecesInGame.add(bRook1);
        Piece bKnight1 = new Knight(util.Color.BLACK, 2, 6);
        piecesInGame.add(bKnight1);
        Piece bBishop1 = new Bishop(util.Color.BLACK, 3, 6);
        piecesInGame.add(bBishop1);
        Piece bQueen = new Queen(util.Color.BLACK, 4, 6);
        piecesInGame.add(bQueen);
        Piece bKing = new King(util.Color.BLACK, 5, 6);
        piecesInGame.add(bKing);
    }

    /**
     * Seach for a piece in the board and return it.
     * @param x
     * @param y
     * @return Piece
     */
    public Piece getPieceInPos(int x, int y){
        for (Piece piece : piecesInGame) {
            if(piece.getPosX() == x && piece.getPosY() == y){
                return piece;
            }
        }
        return null;
    }

    /**
     * Move a piece from a position to another.
     * 2 Movimentos possíveis:
     *  1 - Movimento para casa vazia
     *  2 - Movimento para casa ocupado
     * @param posXStart
     * @param posYStart
     * @param posXEnd
     * @param posYEnd
     * @return
     */
    public boolean movePiece(int posXStart, int posYStart, int posXEnd, int posYEnd){
        for (Piece piece : piecesInGame) {
            if(pieceExistsInPosition(posXStart, posYStart, piece)){
                if(isOccupied(posXEnd, posYEnd)){
                    if(isEnemy(posXEnd, posYEnd, piece)){
                        piecesInGame.remove(getPieceInPos(posXEnd, posYEnd));
                        piece.move(posXEnd, posYEnd);
                        rules.changeTurn();
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    piece.move(posXEnd, posYEnd);
                    removePiece(posXStart, posYStart);
                    rules.changeTurn();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if a piece in certain position is an enemy.
     * @param EnemyPiecePosX
     * @param EnemyPiecePosY
     * @param piece
     * @return
     */
    public boolean isEnemy(int EnemyPiecePosX, int EnemyPiecePosY, Piece piece){
        for (Piece pieceInGame : piecesInGame) {
            if(pieceExistsInPosition(EnemyPiecePosX, EnemyPiecePosY, pieceInGame)){
                if(pieceInGame.getColor() != piece.getColor()){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if the piece really exists in the position.
     * @param posX
     * @param posY
     * @param piece
     * @return
     */
    public boolean pieceExistsInPosition(int posX, int posY, Piece piece) {
        return piece.getPosX() == posX && piece.getPosY() == posY;
    }

    /**
     * Remove a piece from the board in the xPos and yPos.
     * @param posX
     * @param posY
     */
    public void removePiece(int posX, int posY){
        for (Piece piece : piecesInGame) {
            if(pieceExistsInPosition(posX, posY, piece)){
                piecesInGame.remove(piece);
            }
        }
    }

    /**
     * Check if a position is occupied by another piece.
     * @param posX
     * @param posY
     * @return
     */
    public boolean isOccupied(int posX, int posY){
        for (Piece piece : piecesInGame) {
            if(pieceExistsInPosition(posX, posY, piece)){
                return true;
            }
        }
        return false;
    }
}
