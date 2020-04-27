package game;

import game.figures.Figure;
import game.figures.FigureType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {
    private static final int SIZE = 40;
    private int initX, initY;
    private int logicalX, logicalY;


    public Block(int startPosX, int startPosY) {
        initX = startPosX;
        initY = startPosY;
        buildSegment();
    }

    private void buildSegment() {
        setWidth(SIZE);
        setHeight(SIZE);
        updateFigurePosition(0, 0);
        updateView();
    }

    public void generateFigureType(FigureType figureType){
        switch (figureType){
            case FIGURE_PLUS:
                this.getStyleClass().add("figure-plus");
                break;
            case FIGURE_I:
                this.getStyleClass().add("figure-I");
                break;
            case FIGURE_L:
                this.getStyleClass().add("figure-L");
                break;
            case FIGURE_SQR:
                this.getStyleClass().add("figure-Sqr");
                break;
            case FIGURE_STEP:
                this.getStyleClass().add("figure-Step");
                break;
            default:
        }
    }

    public void updateRotaryPosition(int figureX, int figureY){
        initY += figureY;
        initX += figureX;
    }

    public void updateFigurePosition(int figureX, int figureY) {
        logicalX = figureX + initX;
        logicalY = figureY + initY;
    }


    public void updateView() {
        setX(logicalX * SIZE);
        setY(logicalY * SIZE);
    }

    public void initMargeState() {
        initX = logicalX;
        initY = logicalY;
    }

    public int getLogicalX() {
        return logicalX;
    }

    public int getLogicalY() {
        return logicalY;
    }

    @Override
    public String toString() {
        return "Block{" +
                "initX=" + initX +
                ", initY=" + initY +
                ", logicalX=" + logicalX +
                ", logicalY=" + logicalY +
                '}';
    }
}
