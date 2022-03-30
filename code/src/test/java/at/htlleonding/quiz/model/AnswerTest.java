package at.htlleonding.quiz.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    private Question question;

    @BeforeEach
    void init() {
        String text = "What programming language am I written in?";
        this.question = new Question(text, 5);
    }

    @Test
    void createAnswer() {
        //arrange
        Answer answer = new Answer("Java", false, 10, this.question);

        //act

        //assert
        assertThat(answer.getPoints()).isEqualTo(10);
        assertThat(answer.getQuestion()).isEqualTo(this.question);
        assertThat(answer.getText()).isEqualTo("Java");
        assertThat(answer.isCorrect()).isEqualTo(false);
    }

}