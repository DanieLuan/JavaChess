import game.Player;
import ui.*;
import board.*;
import game.GameRules;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();

        BoardUI boardUI = new BoardUI(board);

        boardUI.spawnPiecesStarter();

    }

}
