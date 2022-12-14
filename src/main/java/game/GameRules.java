package game;

import board.Board;
import board.Spot;
import pieces.*;
import pieces.Piece;
import ui.PieceUI;
import util.Color;

public class GameRules {

    public static boolean moveIsValid(int spotPosX, int spotPosY, Piece pieceSelected, Board boardGame){
        return pieceSelected.moveIsValid(spotPosX, spotPosY, pieceSelected, boardGame);
    }
    
    public static boolean pawnCaptureIsValid(int spotPosX, int spotPosY, PieceUI pieceSelected){
        Pawn piece = new Pawn(pieceSelected.getColor(), pieceSelected.getPosX(), pieceSelected.getPosY());
        return piece.captureIsValid(spotPosX, spotPosY, pieceSelected);
    }

    public static boolean isKingCheked(Board board, boolean isWhiteTurn){
        if (isWhiteTurn){
            Color color = Color.WHITE;
            Piece king = board.getKingPiece(color);
            return isKingInDanger(board, color, king.getPosX(), king.getPosY());

        } else {
            Color color = Color.BLACK;
            Piece king = board.getKingPiece(color);
            return isKingInDanger(board, color, king.getPosX(), king.getPosY());
        }
    }
    public static boolean isKingInDanger(Board boardGame, Color color, int kingPosX, int kingPosY){
        for (Piece piece : boardGame.piecesInGame) {
            if(piece.getColor() != color){
                for(Spot spot : piece.getPossibleMoves(boardGame)){
                    if(spot.getPosX() == kingPosX && spot.getPosY() == kingPosY){
                        //System.out.println("King " + color + " in danger");
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
