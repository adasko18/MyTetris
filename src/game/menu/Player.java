package game.menu;

import java.io.Serializable;

public class Player implements Serializable, Comparable<Player> {

    private String name = "";
    private int score = 0;

    public void addScore(int numberOfLines) {
        score += 100 * numberOfLines;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", name, score);
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(o.score,score);
    }
}
