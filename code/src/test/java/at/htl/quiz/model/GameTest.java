package at.htl.quiz.model;

import at.htl.quiz.db.Repo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    Game game;
    Player player;
    @BeforeEach
    void setUp() throws SQLException {
        player = new Player("Max");
        Repo repo= new Repo();
        game = new Game(player,repo);
    }

    @Test
    void getQuestionTest() {
        assertThat(game.getQuestion()).isNotNull();
    }

    @Test
    void addAnswerOptionTest() {
        Question question = new Question("Wie heißt der Hauptstadt von Deutschland?" ,1 );
        AskedQuestion askedQuestion = new AskedQuestion(question, new Answer("Berlin",true,2,question));
        game.addAnswerOption(askedQuestion);
        assertThat(game.getQuestionsAnswered()).contains(askedQuestion);
    }

    @Test
    void incrementScoreTest() {
        int oldScore=game.getScore();
        game.incrementScore(1);
        assertThat(game.getScore()).isEqualTo(oldScore+1);
    }

    @Test
    void endTest() {
        assertThat(game.end()).isTrue();
    }
}