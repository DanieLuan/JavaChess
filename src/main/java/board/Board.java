package board;

import pieces.Pawn;
import pieces.Piece;
import util.Color;

import java.util.LinkedList;

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
    }


}
