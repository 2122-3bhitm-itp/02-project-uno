package at.htlleonding.quiz.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    void createQuestion() {
        String text = "What programming language am I written in?";
        //arrange
        Question question = new Question(text, 5);

        //act

        //assert
        assertThat(question.getText()).isEqualTo(text);
        assertThat(question.getDifficulty()).isEqualTo(5);
    }

}