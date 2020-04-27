package game;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Background extends Pane {

    public static final int WIDTH = 10;
    public static final int HEIGHT = 20;
    public static final int SIZE = 40;
    private Rectangle boardBackground;

    public Background() {
        fillBoard();
    }

    private void fillBoard() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                boardBackground = buildSegment();
                boardBackground.setX(i*SIZE);
                boardBackground.setY(j*SIZE);
                getChildren().add(boardBackground);
            }
        }
    }

    private Rectangle buildSegment() {
        Rectangle rectangle = new Rectangle(SIZE, SIZE);
        rectangle.setFill(Color.WHITESMOKE);
        rectangle.setStroke(Color.BLACK);
        return rectangle;
    }
}
