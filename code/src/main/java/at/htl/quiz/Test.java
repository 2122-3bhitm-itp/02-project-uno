package at.htl.quiz;

import at.htl.quiz.db.Repo;
import at.htl.quiz.model.Game;
import at.htl.quiz.model.Player;
import at.htl.quiz.ui.GameController;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Test extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        try {
            Repo db = new Repo();
            Player p = new Player("test");

            stage.setOnCloseRequest((Event) -> {
                try {
                    db.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

            Game game = new Game(p, db);
            GameController gameController = new GameController(game);
            gameController.show(stage);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
