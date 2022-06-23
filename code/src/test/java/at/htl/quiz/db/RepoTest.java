package at.htl.quiz.db;

import at.htl.quiz.model.Game;
import at.htl.quiz.model.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

class RepoTest {
    Repo repo;
    @BeforeEach
    void setUpTest()  {
        try {
            repo=new Repo();
        } catch (SQLException e) {
            Assertions.fail("Could not connect to Database: "+e);
        }
    }
    Player player=new Player("Max");
    Game game=new Game(player);

    @Test
    void savePlayerTest() throws SQLException {
        repo.savePlayer(player);

    }
    @Test
    void saveGame() throws SQLException {
       repo.savePlayer(player);
    }

    @Test
    void getQuestions() throws SQLException {
        assertThat(repo.getQuestions(5).size()).isGreaterThan(0);
    }


}