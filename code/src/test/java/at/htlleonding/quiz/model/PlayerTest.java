package at.htlleonding.quiz.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void createPlayer() {
        //arrange
        Player player = new Player("test");

        //act

        //assert
        assertThat(player.getName()).isEqualTo("test");
    }

    @Test
    void actPlayer() {
        //arrange
        Player player = new Player("noname");

        //act
        player.setName("test");

        //assert
        assertThat(player.getName()).isEqualTo("test");
    }
}