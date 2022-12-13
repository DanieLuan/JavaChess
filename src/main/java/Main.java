import game.Player;
import ui.*;
import board.*;
import game.GameRules;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();

        BoardUI boardUI = new BoardUI(board);

        boardUI.spawnPiecesStarter();

        //TODO: Implementar regras de movimento: Torre, Bispo, Rainha (Torre + Bispo), Rei
        //TODO: Mover peças clicando na posição desejada
        //TODO: Cheque e Cheque-Mate
        //TODO: Roque
        //TODO: Promoção do peão
        //TODO: Passante (opcional, não é prioridade)
        //TODO: UI do jogo (Iniciar, game over, etc)
    }

}
