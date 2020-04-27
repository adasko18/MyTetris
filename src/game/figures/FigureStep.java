package game.figures;

import game.Block;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;


public class FigureStep extends Figure {

    public FigureStep() {
        super(Color.ORANGERED,FigureType.FIGURE_STEP);
    }

    @Override
    public List<Block> generateListOfBlocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(buildBlock(4,0));
        blocks.add(buildBlock(5,0));
        blocks.add(buildBlock(5,1));
        blocks.add(buildBlock(6,1));
        return blocks;
    }

    @Override
    public void rotateToFirstPosition() {
        setRotationToFirstPosCoordinates();
        if (!isCollisionWithWallsDuringRotation()) {
            getBlocks().get(0).updateRotaryPosition(0, 1);
            getBlocks().get(1).updateRotaryPosition(0, 0);
            getBlocks().get(2).updateRotaryPosition(1, 1);
            getBlocks().get(3).updateRotaryPosition(1, 0);
        }
    }

    @Override
    public void rotateToSecondPosition() {
        setRotationToSecondPosCoordinates();
        if (!isCollisionWithWallsDuringRotation()) {
            getBlocks().get(0).updateRotaryPosition(1, -1);
            getBlocks().get(1).updateRotaryPosition(0, 0);
            getBlocks().get(2).updateRotaryPosition(-1, -1);
            getBlocks().get(3).updateRotaryPosition(-2, 0);
        }
    }

    @Override
    public void rotateToThirdPosition() {
        setRotationToThirdPosCoordinates();
        if (!isCollisionWithWallsDuringRotation()) {
            getBlocks().get(0).updateRotaryPosition(-1, 1);
            getBlocks().get(1).updateRotaryPosition(0, 0);
            getBlocks().get(2).updateRotaryPosition(1, 1);
            getBlocks().get(3).updateRotaryPosition(2, 0);
        }
    }

    @Override
    public void rotateToFourthPosition() {
        setRotationToFourthPosCoordinates();
        if (!isCollisionWithWallsDuringRotation()) {
            getBlocks().get(0).updateRotaryPosition(0, -1);
            getBlocks().get(1).updateRotaryPosition(0, 0);
            getBlocks().get(2).updateRotaryPosition(-1, -1);
            getBlocks().get(3).updateRotaryPosition(-1, 0);
        }
    }

    @Override
    public void setRotationToFirstPosCoordinates() {
        rotaryCoordinates[0][0] = 0;
        rotaryCoordinates[0][1] = 1;
        rotaryCoordinates[1][0] = 0;
        rotaryCoordinates[1][1] = 0;
        rotaryCoordinates[2][0] = 1;
        rotaryCoordinates[2][1] = 1;
        rotaryCoordinates[3][0] = 1;
        rotaryCoordinates[3][1] = 0;
    }

    @Override
    public void setRotationToSecondPosCoordinates() {
        rotaryCoordinates[0][0] = 1;
        rotaryCoordinates[0][1] = -1;
        rotaryCoordinates[1][0] = 0;
        rotaryCoordinates[1][1] = 0;
        rotaryCoordinates[2][0] = -1;
        rotaryCoordinates[2][1] = -1;
        rotaryCoordinates[3][0] = -2;
        rotaryCoordinates[3][1] = 0;
    }

    @Override
    public void setRotationToThirdPosCoordinates() {
        rotaryCoordinates[0][0] = -1;
        rotaryCoordinates[0][1] = 1;
        rotaryCoordinates[1][0] = 0;
        rotaryCoordinates[1][1] = 0;
        rotaryCoordinates[2][0] = 1;
        rotaryCoordinates[2][1] = 1;
        rotaryCoordinates[3][0] = 2;
        rotaryCoordinates[3][1] = 0;
    }

    @Override
    public void setRotationToFourthPosCoordinates() {
        rotaryCoordinates[0][0] = 0;
        rotaryCoordinates[0][1] = -1;
        rotaryCoordinates[1][0] = 0;
        rotaryCoordinates[1][1] = 0;
        rotaryCoordinates[2][0] = -1;
        rotaryCoordinates[2][1] = -1;
        rotaryCoordinates[3][0] = -1;
        rotaryCoordinates[3][1] = 0;
    }
}
