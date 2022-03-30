package at.htlleonding.quiz.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Game_QuestionTest {

    private Game game;
    private Question question;
    private Player player;

    @BeforeEach
    void init() {
        this.player = new Player("test");
        this.game = new Game(this.player);
        this.question = new Question("test?", 1);
    }

    @Test
    void createAnswer() {
        //arrange
        Game_Question game_question = new Game_Question();
        //act
        game_question.setQuestion(this.question);
        game_question.setGame(this.game);
        game_question.setPlayer(this.player);
        //assert
        assertThat(game_question.getGame()).isEqualTo(this.game);
        assertThat(game_question.getPlayer()).isEqualTo(this.player);
        assertThat(game_question.getQuestion()).isEqualTo(this.question);
    }

}