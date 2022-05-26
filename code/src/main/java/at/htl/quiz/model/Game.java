package at.htl.quiz.model;

import at.htl.quiz.ui.MainMenuController;
import javafx.stage.Stage;

import java.io.IOException;

public class Game {
    public enum currentstage {
        MAINMENU,
        GAME,
        EDITQUESTIONS
    }

    private MainMenuController controller;
    private Player player;
    Stage mainStage;
    currentstage currentstage = null;



    public Game(Player player) {
        this();
        this.player = player;
    }

    public Game() {
        this.player = null;
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * Starts the UI for the game
     * @param stage
     * @throws IOException fxml file not found
     */
    public void startUI(Stage stage) throws IOException {
        this.mainStage = stage;
        MainMenuController controller = new MainMenuController();
        controller.show(stage);
        this.currentstage = this.currentstage.MAINMENU;
    }
}
