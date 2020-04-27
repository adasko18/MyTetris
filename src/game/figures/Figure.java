package game.figures;

import game.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class Figure extends Pane implements MyFigures {

    private int x, y;
    protected List<Block> blocks = new ArrayList<>();
    private boolean[] rotaryPosition = {false, false, false, false};
    protected int[][] rotaryCoordinates = new int[4][2];
    public static Color color;
    private FigureType figureType;

    public Figure(){}

    public Figure(Color color,FigureType figureType) {
        setFigureType(figureType);
        initBlocks();
    }

    private void initBlocks() {
        attachBlocks(generateListOfBlocks());
        rotaryPosition[0] = true;
    }

    protected Block buildBlock(int x, int y) {
        Block block = new Block(x, y);
        block.generateFigureType(figureType);
        return block;
    }

    public abstract List<Block> generateListOfBlocks();

    private void attachBlocks(List<Block> attachedBlocks) {
        blocks.addAll(attachedBlocks);
        getChildren().addAll(blocks);
    }

    public boolean isDownPosition() {
        for (Block block : blocks) {
            if (block.getLogicalY() == Background.HEIGHT - 1) {
                return true;
            }
        }
        return false;
    }

    public void clearAll() {
        for (Block block : blocks) {
            getChildren().remove(block);
        }
        blocks.clear();
    }

    public boolean isCollisionWith(FallenFigure fallenFigure) {
        for (Block block : blocks) {
            for (Block fallenBlock : fallenFigure.getBlocks()) {
                if (block.getLogicalY() == fallenBlock.getLogicalY() - 1 &&
                        block.getLogicalX() == fallenBlock.getLogicalX()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCollisionWith(Figure figure, Direction direction){
        for (Block block : blocks) {
            for (Block fallenBlock : figure.getBlocks()) {
                if (block.getLogicalX() + direction.getChange() == fallenBlock.getLogicalX() &&
                        block.getLogicalY() == fallenBlock.getLogicalY()    ) {
                    return true;
                }
            }
        }
        return false;
    }



    public boolean isMovementXNotPossible(FallenFigure fallenFigure) {
        for (Block block : blocks) {
            for (Block fallenBlock : fallenFigure.getBlocks()) {
                if (block.getLogicalY() == fallenBlock.getLogicalY() &&
                        block.getLogicalX() == fallenBlock.getLogicalX() + 1) {
                    return true;
                }
            }
        }
        return false;
    }



    public void rotationToNextPosition() {
        switch (getActualRotaryPosition()) {
            case 0: {
                setRotationToSecondPosCoordinates();
                if(!isCollisionWithWallsDuringRotation()) {
                    rotateToSecondPosition();
                    updateBlocksView();
                    updateFigureRotaryPosition();
                    clearRotaryCoordinates();
                }
                break;
            }
            case 1: {
                setRotationToThirdPosCoordinates();
                if (!isCollisionWithWallsDuringRotation()) {
                    rotateToThirdPosition();
                    updateBlocksView();
                    updateFigureRotaryPosition();
                    clearRotaryCoordinates();
                }
                break;
            }
            case 2: {
                setRotationToFourthPosCoordinates();
                if(!isCollisionWithWallsDuringRotation()) {
                    rotateToFourthPosition();
                    updateBlocksView();
                    updateFigureRotaryPosition();
                    clearRotaryCoordinates();
                }
                break;
            }
            case 3: {
                setRotationToFirstPosCoordinates();
                if(!isCollisionWithWallsDuringRotation()) {
                    rotateToFirstPosition();
                    updateBlocksView();
                    updateFigureRotaryPosition();
                    clearRotaryCoordinates();
                }
                break;
            }
        }
    }

    public void updateBlocks() {
        for (Block block : blocks) {
            block.updateFigurePosition(x, y);
        }

    }

    public void updateBlocksView() {
        for (Block block : blocks) {
            block.updateView();
        }
    }


    public boolean isCollisionWithWallX(int changeX) {
        for (Block block : blocks) {
            if (block.getLogicalX() + changeX < 0 || block.getLogicalX() + changeX >= Background.WIDTH) {
                return true;
            }
        }
        return false;
    }

    public boolean isCollisionWithWallsDuringRotation() {
            for (int i = 0; i < 4; i++) {
                if (blocks.get(i).getLogicalX() + rotaryCoordinates[i][0] < 0 ||
                        blocks.get(i).getLogicalX() + rotaryCoordinates[i][0] >= Background.WIDTH ||
                        blocks.get(i).getLogicalY() + rotaryCoordinates[i][1] < 0 ||
                        blocks.get(i).getLogicalY() + rotaryCoordinates[i][1] >= Background.HEIGHT-1) {
                    return true;
                }
            }
        return false;
    }

    public void clearRotaryCoordinates(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                rotaryCoordinates[i][j]=0;
            }
        }
    }

    public boolean isCollisionWithWallY(int changeY) {
        for (Block block : blocks) {
            if (block.getLogicalY() + changeY < 0 || block.getLogicalY() + changeY >= Background.HEIGHT) {
                return true;
            }
        }
        return false;
    }

    public void updateFigureRotaryPosition() {
        for (int i = 0; i < 4; i++) {
            if (rotaryPosition[i] && i < 3) {
                rotaryPosition[i + 1] = true;
                rotaryPosition[i] = false;
                break;
            } else if (rotaryPosition[i] && i == 3) {
                rotaryPosition[0] = true;
                rotaryPosition[i] = false;
                break;
            }
        }
    }

    private int getActualRotaryPosition() {
        for (int i = 0; i < 4; i++) {
            if (rotaryPosition[i]) {
                return i;
            }
        }
        return 99;
    }

    public void mergeWith(Figure figure) {
        blocks.addAll(figure.blocks);
        getChildren().addAll(figure.blocks);
        for (Block block : blocks) {
            block.initMargeState();
        }
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public void setFigureType(FigureType figureType) {
        this.figureType = figureType;
    }

    public int getX() {
        return x;
    }

    public void increaseX(int x) {
        this.x += x;
    }

    public int getY() {
        return y;
    }

    public void increaseY(int y) {
        this.y += y;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

}
