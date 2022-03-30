package at.htlleonding.quiz.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnsweredTest {

    private Answer answer;
    private Game_Question game_question;

    @BeforeEach
    void init() {
        Player player = new Player("test");
        Game game = new Game(player);
        Question question = new Question("test?", 1);
        this.game_question = new Game_Question(game, question, player);
        this.answer = new Answer("Java", true, 1, question);
    }

    @Test
    void createAnswered() {
        //arrange:
        Answered answered = new Answered(this.answer, this.game_question);
        //act

        //assert:
        assertThat(answered.getAnswer()).isEqualTo(this.answer);
        assertThat(answered.getGame_question()).isEqualTo(this.game_question);
    }

    @Test
    void actAnswered() {
        //arrange:
        Answered answered = new Answered();
        //act
        answered.setAnswer(this.answer);
        answered.setGame_question(game_question);

        //assert:
        assertThat(answered.getAnswer()).isEqualTo(this.answer);
        assertThat(answered.getGame_question()).isEqualTo(this.game_question);
    }
}