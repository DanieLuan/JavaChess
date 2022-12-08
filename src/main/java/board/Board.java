package board;

import pieces.*;
import util.Color;

import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.RecursiveTask;

public class Board {

    public static final int BOARD_SIZE = 8;

    public LinkedList<Piece> piecesInGame;

    public Board(){
        piecesInGame = new LinkedList<>();

        createStartersPieces();
    }

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

    public Piece getPieceInPos(int x, int y){
        for (Piece piece : piecesInGame) {
            if(piece.getPosX() == x && piece.getPosY() == y){
                return piece;
            }
        }
        return null;
    }

    public boolean movePiece(int posXStart, int posYStart, int posXEnd, int posYEnd){
        for (Piece piece : piecesInGame) {
            if(pieceExistsInPosition(posXStart, posYStart, piece)){
                if(isOccupied(posXEnd, posYEnd)){
                    if(isEnemy(posXEnd, posYEnd, piece)){
                        piecesInGame.remove(getPieceInPos(posXEnd, posYEnd));
                        piece.move(posXEnd, posYEnd);
                        return true;
                    } else {
                        System.out.println("Você não pode se mover para uma posição ocupada por uma peça sua!");
                        return false;
                    }
                } else {
                    piece.move(posXEnd, posYEnd);
                    return true;
                }
            }
        }
        return false;
    }

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

    public boolean pieceExistsInPosition(int posX, int posY, Piece piece) {
        return piece.getPosX() == posX && piece.getPosY() == posY;
    }

    public void removePiece(int posXEnd, int posYEnd){
        for (Piece piece : piecesInGame) {
            if(pieceExistsInPosition(posXEnd, posYEnd, piece)){
                piecesInGame.remove(piece);
            }
        }
    }

    public boolean isOccupied(int posX, int posY){
        for (Piece piece : piecesInGame) {
            if(pieceExistsInPosition(posX, posY, piece)){
                return true;
            }
        }
        return false;
    }



}
