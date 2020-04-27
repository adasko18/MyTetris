package game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import game.menu.ViewFactory;

import static game.menu.WindowType.MENU;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.initializeStage(MENU);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
