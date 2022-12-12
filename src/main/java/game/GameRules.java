package game;

import board.Board;
import pieces.*;
import pieces.Piece;
import ui.PieceUI;
import util.Color;
import util.Type;

public class GameRules {
    private boolean isWhiteTurn;

    public static final int BOARD_SIZE = 8;

    public GameRules(){
        isWhiteTurn = true;
    }

    public void changeTurn(){
        isWhiteTurn = !isWhiteTurn;
    }
    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }

    //TODO: trocar PieceUI por Piece pegado em getPieceInPos
    public boolean moveIsValid(int spotPosX, int spotPosY, Piece pieceSelected, Board boardGame){
        return pieceSelected.moveIsValid(spotPosX, spotPosY, pieceSelected, boardGame);
    }
    
    public boolean pawnCaptureIsValid(int spotPosX, int spotPosY, PieceUI pieceSelected){
        Pawn piece = new Pawn(pieceSelected.getColor(), pieceSelected.getPosX(), pieceSelected.getPosY());
        return piece.captureIsValid(spotPosX, spotPosY, pieceSelected);
    }


    //TODO: Implementar regras do jogo
}
