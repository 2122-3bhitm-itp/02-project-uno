package at.htlleonding.quiz.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void createGame() {
        //arrange
        Player p = new Player("test");
        Game game = new Game(p);

        //act

        //assert
        assertThat(game.getPlayer()).isEqualTo(p);
    }
}