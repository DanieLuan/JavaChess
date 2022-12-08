import ui.*;
import board.*;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();

        BoardUI boardUI = new BoardUI(board);

        boardUI.spawnPiecesStarter();

    }

}
