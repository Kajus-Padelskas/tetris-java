package vgtu.game;

public class Score {
    private static Score instance = null;

    private int score;

    private Score() {
        this.score = score;
    }

    synchronized static Score getInstance() {
        if (instance == null) {
            instance = new Score();
        }
        return instance;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Top score:" + score;
    }
}
