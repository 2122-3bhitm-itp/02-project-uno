package at.htl.quiz.db;

import at.htl.quiz.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repo {
    Connection conn;

    public Repo() throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db", "app", "app");
        this.conn.setAutoCommit(false);
    }

    public void close() throws SQLException {
        this.conn.close();
    }

    /**
     * Saves a player to the database. If the player already exists, it will be ignored
     * @param player player to insert
     * @return updated rows
     * @throws SQLException on failed request
     */
    public int savePlayer(Player player) throws SQLException {
        var pstmt = this.conn.prepareStatement("insert into player (name) values (?) on conflict do nothing");
        pstmt.setString(1, player.getName());
        int result = pstmt.executeUpdate();
        pstmt.close();
        this.conn.commit();
        return result;
    }

    public List<Question> getQuestions(int amount) throws SQLException {
        var questions = getEmptyRandomQuestion(amount);

        PreparedStatement preparedStatement = this.conn.prepareStatement("select * from answer inner join question q using (questionid) where q.question = ?");

        questions.forEach(question -> {
            try {
                preparedStatement.setString(1, question.getText());
                preparedStatement.execute();
                ResultSet rs = preparedStatement.getResultSet();

                List<Answer> answers = new ArrayList<>();

                while(rs.next()) {
                    String text = rs.getString("answer");
                    boolean isCorrect = rs.getBoolean("iscorrect");
                    int worth = rs.getInt("worth");
                    answers.add(new Answer(text, isCorrect, worth, question));
                }
                rs.close();
                question.setAnswers(answers);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        preparedStatement.close();
        return questions;
    }

    /**
     * Gets a List of Questions that have no answers connected to them. The int value defines the length of the List.
     * @param amount number of questions
     * @return List of Questions with no answers
     * @throws SQLException if something went wrong
     */
    private List<Question> getEmptyRandomQuestion(int amount) throws SQLException {
        List<Question> questions = new ArrayList<>();

        PreparedStatement pstmt = this.conn.prepareStatement("select * from question order by random() limit ?");
        pstmt.setInt(1, amount);
        pstmt.execute();
        ResultSet rs = pstmt.getResultSet();

        while(rs.next()) {
            String text = rs.getString("question");
            int difficulty = rs.getInt("difficulty");
            questions.add(new Question(text, difficulty));
        }

        rs.close();
        pstmt.close();
        return questions;
    }

    public void saveGame(Game game) throws SQLException {
        //TODO: save game to Database
    }

    /**
     * Saves the raw game, so no values are being saved. THIS DOES NOT COMMIT!
     * @param game game to save
     * @return updated rows
     * @throws SQLException on failed request
     */
    private int saveGameRaw(Game game) throws SQLException {
        var pstmt = this.conn.prepareStatement("insert into game (playerid)\n values ((select playerid from player where name = ?))");
        pstmt.setString(1, game.getPlayer().getName());
        int result = pstmt.executeUpdate();
        pstmt.close();
        return result;
    }
}
