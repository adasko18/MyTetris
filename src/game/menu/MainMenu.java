package game.menu;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainMenu extends Stage {

    private VBox root;
    private Scene scene;
    private Label mainLabel;
    private Button start;
    private Button scores;
    private Button music;
    private Button exit;

    public MainMenu() {
        root = new VBox(5);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(25));
        scene = new Scene(root,250,250);
        setTitle("MyTetris");
        setScene(scene);
        scene.getStylesheets().add("/resources/button.css");
        initComponents();
        setResizable(false);
    }

    private void initComponents() {

        start = new Button("Start");
        start.getStyleClass().add("button1");
        scores = new Button("Scores");
        scores.getStyleClass().add("button1");
        music = new Button("Music");
        music.getStyleClass().add("button1");
        exit = new Button("Exit");
        exit.getStyleClass().add("button1");
        mainLabel = new Label("Tetris");
        mainLabel.getStyleClass().add("title1");
        BackgroundImage myBI= new BackgroundImage(new Image("/resources/menu.jpg",250,300,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        start.setMaxWidth(100);
        scores.setMaxWidth(100);
        music.setMaxWidth(100);
        exit.setMaxWidth(100);
        root.setBackground(new Background(myBI));
        root.getChildren().addAll(mainLabel, start, scores,music, exit);
    }

    public void addStartAction(EventHandler eventHandler) {
        start.setOnAction(eventHandler);
    }

    public void addScoresAction(EventHandler eventHandler) {
        scores.setOnAction(eventHandler);
    }

    public void addMusicAction(EventHandler eventHandler) {
        music.setOnAction(eventHandler);
    }

    public void addExitAction(EventHandler eventHandler) {
        exit.setOnAction(eventHandler);
    }
}
