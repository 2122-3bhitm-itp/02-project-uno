package at.htl.quiz.ui;

import at.htl.quiz.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class GameController {
    private static final Color CORRECT_COLOR = Color.color(0, 0.5, 0);
    private static final String PICK_ANSWER_TEXT = "Answer";
    private static final String ANSWERED_TEXT = "Selected";

    Game game;

    @FXML
    private Button btEndGame;

    @FXML
    private Button btSubmit;

    @FXML
    private GridPane gpAnswers;

    @FXML
    private Label lbQuestionText;

    @FXML
    private ProgressBar pbMain;

    @FXML
    void endGame(ActionEvent event) {

    }

    @FXML
    void submitQuestion(ActionEvent event) {
        Answer selected = getSelectedAnswer();
        this.game.addAnswerOption(new AskedQuestion(this.currentQuestion, selected));
    }

    @FXML
    void initialize() {
        lbQuestionText.setWrapText(true);
        lbQuestionText.setTextAlignment(TextAlignment.LEFT);
        loadNewQuestion();
    }

    public GameController(Game game) {
        this.game = game;
    }

    private Question currentQuestion;

     public void show(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameController.class.getResource("game.fxml"));
        fxmlLoader.setController(this);
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Quiz");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Loads a new question from the database and places it in the UserInterface
     */
    public void loadNewQuestion() {
        pbMain.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);

        //start new Thread for async loading of question:
        new Thread(() -> {
            //Get question from db:
            var question = this.game.getQuestion();
            if(question == null) {
                //TODO: Display Error
                return;
            }
            this.currentQuestion = question;

            //modify user Interace:
            Platform.runLater(() -> {
                lbQuestionText.setText(question.getText());

                //add answer options to gridPane:
                var counter = new AtomicInteger(0);
                gpAnswers.getChildren().clear();
                question.getAnswers().forEach(answer -> {
                    var lb = new Label(answer.getText());
                    lb.setWrapText(true);

                    var bt = new Button(PICK_ANSWER_TEXT);
                    bt.setOnAction((ActionEvent) -> {
                        clearAnswerOptions();
                        lb.setTextFill(Color.color(0, 0.5, 0));
                        bt.setText(ANSWERED_TEXT);
                        bt.setDisable(true);
                    });
                    gpAnswers.add(lb, 0, counter.get());
                    gpAnswers.add(bt, 1, counter.getAndIncrement());
                });

                //done:
                pbMain.setProgress(0);
            });
        }).start();
    }

    public void clearAnswerOptions() {
        gpAnswers.getChildren().forEach(node -> {
            if(node instanceof Label lb) {
                lb.setTextFill(Color.color(0, 0, 0));
            }
            if(node instanceof Button bt) {
                bt.setDisable(false);
                bt.setText(PICK_ANSWER_TEXT);
            }
        });
    }

    private Answer getSelectedAnswer() {
         AtomicReference<Answer> correct = new AtomicReference<>(null);
         var answers = this.currentQuestion.getAnswers();
         gpAnswers.getChildren().forEach(node -> {
             if(node instanceof Label lb) {
                 if(lb.getTextFill().equals(CORRECT_COLOR)) {
                     answers.forEach(answer -> {
                         if(lb.getText().equals(answer.getText())) {
                             correct.set(answer);
                         }
                     });
                 }
             }
         });
         return correct.get();
    }
}
