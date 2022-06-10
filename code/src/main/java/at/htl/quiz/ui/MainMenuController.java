package at.htl.quiz.ui;

import at.htl.quiz.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    //<editor-fold desc="FXML vars">
    @FXML
    private VBox root;

    @FXML
    private Button btStartGame;

    @FXML
    private Button btEditQuestions;
    //</editor-fold>

    //<editor-fold desc="FXML Functions">
    @FXML
    void EditQuestionsHandler(ActionEvent event) {

    }

    @FXML
    void startGameHandler(ActionEvent event) {
        Application.startGame();
        System.out.println("test");
    }
    //</editor-fold>

    public void show(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuController.class.getResource("MainMenu.fxml"));
        fxmlLoader.setController(this);
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Quiz");
        stage.setScene(scene);
        stage.show();
    }
}