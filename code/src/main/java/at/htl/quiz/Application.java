package at.htl.quiz;

import at.htl.quiz.model.Game;
import at.htl.quiz.ui.MainMenuController;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    public static Game game;

    @Override
    public void start(Stage stage) {
        Application.game = new Game();
        try {
            game.startUI(stage);
        } catch (IOException e) {
            System.err.println("Error while displaying UI!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}