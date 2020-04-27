package game.figures;

import game.Block;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;


public class FigureSqr extends Figure {

    public FigureSqr() {
        super(Color.DARKSLATEBLUE,FigureType.FIGURE_SQR);
    }

    @Override
    public List<Block> generateListOfBlocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(buildBlock(4,0));
        blocks.add(buildBlock(5,0));
        blocks.add(buildBlock(4,1));
        blocks.add(buildBlock(5,1));
        return blocks;
    }

    @Override
    public void rotateToFirstPosition() {
    }

    @Override
    public void rotateToSecondPosition() {
    }

    @Override
    public void rotateToThirdPosition() {
    }

    @Override
    public void rotateToFourthPosition() {
    }

    @Override
    public void setRotationToFirstPosCoordinates() {

    }

    @Override
    public void setRotationToSecondPosCoordinates() {

    }

    @Override
    public void setRotationToThirdPosCoordinates() {

    }

    @Override
    public void setRotationToFourthPosCoordinates() {

    }
}
