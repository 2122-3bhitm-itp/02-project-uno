package at.htl.quiz;

import at.htl.quiz.db.Repo;
import at.htl.quiz.model.Game;
import at.htl.quiz.ui.GameController;
import at.htl.quiz.ui.MainMenuController;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Application extends javafx.application.Application {
    public static Game game;
    public static Stage mainStage;

    @Override
    public void start(Stage stage) {
        Application.mainStage = stage;
        Repo db;
        try {
            db = new Repo();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Application.game = new Game(db);
        try {
            game.startUI(stage);
        } catch (IOException e) {
            System.err.println("Error while displaying UI!");
            e.printStackTrace();
        }
    }

    public static void startGame() {
        Application.mainStage.close();
        var gameController = new GameController(Application.game);
        try {
            gameController.show(mainStage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}