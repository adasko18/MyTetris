package game.figures;

import game.Background;
import game.Block;
import java.util.ArrayList;
import java.util.List;

public class FallenFigure extends Figure {
    private ArrayList<Integer> lines = new ArrayList<>();

    public FallenFigure() {

    }

    @Override
    public List<Block> generateListOfBlocks() {
        return new ArrayList<>();
    }

    public boolean isWin(){
        return !lines.isEmpty();
    }


    public void remove(){
        for (int j = 0; j < lines.size(); j++) {
        for (int i = 0; i < blocks.size(); i++) {
            Block block = blocks.get(i);
            if (block.getLogicalY() == lines.get(j)) {
                blocks.remove(block);
                getChildren().remove(block);
                i--;
            }
        }
        }
    }

    public ArrayList<Integer> findHorizontalLine() {
        int counter;
        int i;
        for (i = 1; i < Background.HEIGHT; i++) {
            counter = 0;
            for (Block block : blocks) {
                if(block.getLogicalY()==i){
                    counter++;
                    if(counter==10){
                        lines.add(i);
                    }
                }
            }
        }
        return lines;
    }

    public void moveBlocksDown(){
            for (Block block : blocks) {
                if (block.getLogicalY() < lines.get(lines.size()-1)) {
                    block.updateFigurePosition(0, lines.size());
                    block.updateView();
                }
            }
        }

    public boolean isTooHigh(){
        for (Block block : this.getBlocks()) {
            if(block.getLogicalY()==2){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> getLines() {
        return lines;
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
}
