package game;

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
    public boolean moveIsValid(int spotPosX, int spotPosY, PieceUI pieceSelected){
        if (pieceSelected.getType() == Type.PAWN){
            Pawn piece = new Pawn(pieceSelected.getColor(), pieceSelected.getPosX(), pieceSelected.getPosY());
            if (piece.moveIsValid(spotPosX, spotPosY, pieceSelected)){
                return true;
            }
        } else if (pieceSelected.getType() == Type.KNIGHT){
            Knight piece = new Knight(pieceSelected.getColor(), pieceSelected.getPosX(), pieceSelected.getPosY());
            
        }
        
        return false;
    }
    
    public boolean pawnCaptureIsValid(int spotPosX, int spotPosY, PieceUI pieceSelected){
        Pawn piece = new Pawn(pieceSelected.getColor(), pieceSelected.getPosX(), pieceSelected.getPosY());
        if (piece.captureIsValid(spotPosX, spotPosY, pieceSelected)){
            return true;
        }
        
        return false;
    }


    //TODO: Implementar regras do jogo
}
