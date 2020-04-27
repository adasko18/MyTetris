package game.menu;

public class MainMenuController {

    private MainMenu mainMenu;
    private ViewFactory viewFactory;
    private Music music;


    public MainMenuController(MainMenu mainMenu, ViewFactory viewFactory) {
        this.mainMenu = mainMenu;
        this.viewFactory = viewFactory;
        init();
    }

    private void init() {
        mainMenu.addStartAction(e -> startAction());
        mainMenu.addScoresAction(e -> scoresAction());
        mainMenu.addMusicAction(event -> musicAction());
        mainMenu.addExitAction(e -> exitAction());
        music = new Music("soundtrack.mp3");
    }

    private void startAction() {
        viewFactory.initializeStage(WindowType.GAME);
        viewFactory.closeStage(mainMenu);
    }

    private void scoresAction() {
        viewFactory.initializeStage(WindowType.SCORES);
    }

    private void musicAction(){
        music.turnOnOff();
    }

    private void exitAction() {
        System.exit(0);
    }
}
