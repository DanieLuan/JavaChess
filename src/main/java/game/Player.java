package game;

public class Player {
    private int score;

    public Player() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }
}
