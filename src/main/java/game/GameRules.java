package game;

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

    public boolean moveIsValid(){
        //TODO: implementar regras de movimento
        return true;
    }


    //TODO: Implementar regras do jogo
}
