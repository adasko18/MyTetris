package game;

import javafx.scene.control.Label;

public class ResultBoard {
    private Label scoreLabel;
    private Label nextBlockLabel;
    private Label speedLabel;
    private int score = 0;
    private int speed = 0;



    public ResultBoard() {
        initNextBlockLabel();
        initScoreLabel();
        initSpeedLabel();
    }

    private void initNextBlockLabel() {
        nextBlockLabel = new Label("Next Figure:");
        nextBlockLabel.getStylesheets().add(getClass().getResource("/resources/style.css").toExternalForm());
        nextBlockLabel.getStyleClass().add("featureOne");
        nextBlockLabel.setTranslateX(480);
        nextBlockLabel.setTranslateY(50);
    }

    private void initScoreLabel() {
        scoreLabel = new Label("SCORE:\n"+score);
        scoreLabel.getStylesheets().add(getClass().getResource("/resources/style.css").toExternalForm());
        scoreLabel.getStyleClass().add("featureTwo");
        scoreLabel.setTranslateX(500);
        scoreLabel.setTranslateY(400);
    }

    private void initSpeedLabel() {
        speedLabel = new Label("SPEED:\n"+speed);
        speedLabel.getStylesheets().add(getClass().getResource("/resources/style.css").toExternalForm());
        speedLabel.getStyleClass().add("featureThree");
        speedLabel.setTranslateX(500);
        speedLabel.setTranslateY(600);
    }

    public void setScore(int numberOfLines) {
        score += 100 * numberOfLines;
        scoreLabel.setText("SCORE:\n"+score);
    }

    public void setSpeed(){
        speed +=1;
        speedLabel.setText("SPEED:\n"+speed);
    }

    public Label getNextBlockLabel() {
        return nextBlockLabel;
    }

    public Label getScoreLabel() {
        return scoreLabel;
    }

    public Label getSpeedLabel() {
        return speedLabel;
    }

    public int getScore() {
        return score;
    }
}
