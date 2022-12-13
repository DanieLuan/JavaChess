package game;

import board.Board;
import ui.BoardUI;

public class Game {

    private Board board = new Board();
    private BoardUI boardUI = new BoardUI(board);
    public Game(){
        boardUI.spawnPiecesStarter();
    }


}
