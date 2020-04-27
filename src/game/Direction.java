package game;

public enum Direction {
    LEFT(-1),RIGHT(+1),UP(-1),DOWN(+1);

    private int change;

    Direction(int change) {
        this.change = change;
    }

    public int getChange() {
        return change;
    }
}
