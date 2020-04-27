package game.figures;

import game.Block;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;


public class FigureI extends Figure {

    public FigureI() {
        super(Color.DARKRED,FigureType.FIGURE_I);
    }
    @Override
    public List<Block> generateListOfBlocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(buildBlock(4,0));
        blocks.add(buildBlock(5,0));
        blocks.add(buildBlock(6,0));
        blocks.add(buildBlock(7,0));
        return blocks;
    }

    @Override
    public void rotateToFirstPosition() {
            getBlocks().get(0).updateRotaryPosition(-2, -2);
            getBlocks().get(1).updateRotaryPosition(-1, -1);
            getBlocks().get(2).updateRotaryPosition(0, 0);
            getBlocks().get(3).updateRotaryPosition(1, 1);
    }

    @Override
    public void rotateToSecondPosition() {
            getBlocks().get(0).updateRotaryPosition(1, -1);
            getBlocks().get(1).updateRotaryPosition(0, 0);
            getBlocks().get(2).updateRotaryPosition(-1, 1);
            getBlocks().get(3).updateRotaryPosition(-2, 2);
    }

    @Override
    public void rotateToThirdPosition() {
            getBlocks().get(0).updateRotaryPosition(-1, 1);
            getBlocks().get(1).updateRotaryPosition(0, 0);
            getBlocks().get(2).updateRotaryPosition(1, -1);
            getBlocks().get(3).updateRotaryPosition(2, -2);
    }

    @Override
    public void rotateToFourthPosition() {
            getBlocks().get(0).updateRotaryPosition(2, 2);
            getBlocks().get(1).updateRotaryPosition(1, 1);
            getBlocks().get(2).updateRotaryPosition(0, 0);
            getBlocks().get(3).updateRotaryPosition(-1, -1);
    }

    @Override
    public void setRotationToFirstPosCoordinates() {
        rotaryCoordinates[0][0] = -2;
        rotaryCoordinates[0][1] = -2;
        rotaryCoordinates[1][0] = -1;
        rotaryCoordinates[1][1] = -1;
        rotaryCoordinates[2][0] = 0;
        rotaryCoordinates[2][1] = 0;
        rotaryCoordinates[3][0] = 1;
        rotaryCoordinates[3][1] = 1;
    }

    @Override
    public void setRotationToSecondPosCoordinates() {
        rotaryCoordinates[0][0] = 1;
        rotaryCoordinates[0][1] = -1;
        rotaryCoordinates[1][0] = 0;
        rotaryCoordinates[1][1] = 0;
        rotaryCoordinates[2][0] = -1;
        rotaryCoordinates[2][1] = 1;
        rotaryCoordinates[3][0] = -2;
        rotaryCoordinates[3][1] = 2;
    }

    @Override
    public void setRotationToThirdPosCoordinates() {
        rotaryCoordinates[0][0] = -1;
        rotaryCoordinates[0][1] = 1;
        rotaryCoordinates[1][0] = 0;
        rotaryCoordinates[1][1] = 0;
        rotaryCoordinates[2][0] = 1;
        rotaryCoordinates[2][1] = -1;
        rotaryCoordinates[3][0] = 2;
        rotaryCoordinates[3][1] = -2;
    }

    @Override
    public void setRotationToFourthPosCoordinates() {
        rotaryCoordinates[0][0] = 2;
        rotaryCoordinates[0][1] = 2;
        rotaryCoordinates[1][0] = 1;
        rotaryCoordinates[1][1] = 1;
        rotaryCoordinates[2][0] = 0;
        rotaryCoordinates[2][1] = 0;
        rotaryCoordinates[3][0] = -1;
        rotaryCoordinates[3][1] = -1;
    }

}
