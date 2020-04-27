package game;

import game.figures.*;
import game.menu.*;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class Game extends Stage implements EventHandler<KeyEvent> {

    private Pane appRoot = new Pane();;
    private Pane gameRoot = new Pane();;
    private Player player = new Player();
    private FallenFigure fallenFigure;
    private Figure actualFigure;
    private long movementUpdate = 0;
    private long speed = 999_999_999;
    private ResultBoard resultBoard;
    private FigureType figureType;
    private Figure nextFigure;
    private RecordManager recordManager;
    private ViewFactory factory;
    private boolean running = true;

    public Game(RecordManager recordManager, ViewFactory factory) {
        ImageView backGround = new ImageView("/resources/background.jpg");
        backGround.setX(400);
        this.recordManager = recordManager;
        this.factory = factory;
        initContent();
        appRoot.getChildren().addAll(backGround, gameRoot);
        Scene scene = new Scene(appRoot, Background.SIZE*Background.WIDTH+400, Background.SIZE*Background.HEIGHT);
        setTitle("MyTetris");
        setScene(scene);
        scene.getStylesheets().add("/resources/button.css");
        scene.getStylesheets().add("/resources/block.css");
        setActualAndNextFigure();
        scene.setOnKeyPressed(this);
        startGameLoop();
    }


    private void increaseMovementUpdate() {
        movementUpdate -= 999_999_999;
    }

    private void increaseSpeed(){
        speed -=50_000_000;
        resultBoard.setSpeed();
    }

    public void startGameLoop() {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(running) {
                    if (now - movementUpdate >= speed) {
                        update();
                        movementUpdate = now;
                    }
                }
            }
        };
        animationTimer.start();
    }

    private void checkAndExecuteWinCondition() {
        fallenFigure.findHorizontalLine();
        if (fallenFigure.isWin()) {
            Music music = new Music("spell.mp3");
            fallenFigure.remove();
            fallenFigure.moveBlocksDown();
            resultBoard.setScore(fallenFigure.getLines().size());
            player.addScore(fallenFigure.getLines().size());
            fallenFigure.getLines().clear();
            increaseSpeed();
        }
    }
    private void update(){
        updateMovementY();
        checkAndExecuteWinCondition();
        endGame();
    }

    private void updateMovementY() {
        moveY(Direction.DOWN);
    }

    private void initContent() {
        Background background = new Background();
        gameRoot.getChildren().add(background);
        fallenFigure = new FallenFigure();
        gameRoot.getChildren().add(fallenFigure);
        resultBoard = new ResultBoard();
        gameRoot.getChildren().addAll(resultBoard.getScoreLabel(),
                resultBoard.getNextBlockLabel(), resultBoard.getSpeedLabel());
        setFigureType();
        nextFigure = getFigureFromFigureType(figureType);
    }

    private void setFigureType(){
        figureType = generateRandomFigureType();
    }


    private void setActualAndNextFigure() {
        if(!fallenFigure.isTooHigh()) {
            actualFigure = getFigureFromFigureType(figureType);
            gameRoot.getChildren().add(actualFigure);
            setFigureType();
            nextFigure.clearAll();
            nextFigure = getFigureFromFigureType(figureType);
            gameRoot.getChildren().add(nextFigure);
            setNextFigureView();
        }
    }

    private void setNextFigureView() {
        nextFigure.increaseX(9);
        nextFigure.increaseY(5);
        nextFigure.updateBlocks();
        nextFigure.updateBlocksView();
    }

    private FigureType generateRandomFigureType() {
        Random random = new Random();
        FigureType[] figureTypes = FigureType.values();
        return figureType = figureTypes[random.nextInt(figureTypes.length - 1)];
    }

    private Figure getFigureFromFigureType(FigureType figureType) {
        switch (figureType) {
            case FIGURE_I:
                return new FigureI();
            case FIGURE_L:
                return new FigureL();
            case FIGURE_SQR:
                return new FigureSqr();
            case FIGURE_PLUS:
                return new FigureHalfPlus();
            case FIGURE_STEP:
                return new FigureStep();
        }
        return new FigureI();
    }

    public void mergeAndUpdateFallenFigure() {
        mergeFigures();
        setActualAndNextFigure();
    }

    public void mergeFigures() {
        fallenFigure.mergeWith(actualFigure);
        gameRoot.getChildren().remove(actualFigure);
    }

    public FallenFigure getFallenFigure() {
        return fallenFigure;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case LEFT:
                moveX(Direction.LEFT);
                break;
            case RIGHT:
                moveX(Direction.RIGHT);
                break;
            case UP:
                moveY(Direction.UP);
                break;
            case DOWN:
                increaseMovementUpdate();
                break;
            case SPACE:
                actualFigure.rotationToNextPosition();
                break;
            case ESCAPE:
                Platform.exit();
                break;
            default:
        }
    }

    public void moveX(Direction direction) {
        int change = direction.getChange();
        if (actualFigure.isCollisionWithWallX(change) || actualFigure.isMovementXNotPossible(getFallenFigure())) {
            return;
        }
        if (actualFigure.isCollisionWith(fallenFigure, direction)) {
            return;
        }
        actualFigure.increaseX(change);
        actualFigure.updateBlocks();
        actualFigure.updateBlocksView();
    }

    public void moveY(Direction direction) {
        int change = direction.getChange();
        if (actualFigure.isCollisionWithWallY(change)) {
            return;
        }
        if (hasFallen()) {
            mergeAndUpdateFallenFigure();
        }
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(actualFigure);
        fadeTransition.setDuration(Duration.seconds(0.5));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.0);
        actualFigure.increaseY(change);
        actualFigure.updateBlocks();
        actualFigure.updateBlocksView();
        if (hasFallen()) {
            mergeAndUpdateFallenFigure();
        }
    }

    private boolean hasFallen() {
        return actualFigure.isDownPosition() ||actualFigure.isCollisionWith(fallenFigure);
    }

    private void endGame() {
        if (fallenFigure.isTooHigh()) {
            Music music = new Music("jingle.mp3");
            backToMenu();
            readNameAndSave();
        }
    }

    private void backToMenu() {
        running = false;
        factory.closeStage(this);
        factory.initializeStage(WindowType.MENU);
    }

    private void readNameAndSave() {
        TextInputDialog window = new TextInputDialog();
        window.setTitle("Game ended!");
        window.setHeaderText("Game ended! You got: " + resultBoard.getScore() + " points!");
        window.setContentText("Enter your name:");
        Platform.runLater(() -> window.show());
        window.setOnHidden(e -> savePlayer(window));

    }

    private void savePlayer(TextInputDialog window) {
        String name = window.resultProperty().get();
        if (name.isEmpty()) return;
        player.setName(name);
        recordManager.saveRecord(player);
    }

}
