package at.htl.quiz;

import at.htl.quiz.db.Repo;
import at.htl.quiz.model.Game;
import at.htl.quiz.model.Player;
import at.htl.quiz.util.CommandLineUtil;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("STARTING COMMAND LINE VERSION FOR QUIZ");

        Repo db = null;

        try {
            //connect to db:
            db = new Repo();

            //ask Player for name:
            System.out.print("Player name: ");
            String name = CommandLineUtil.getLine();
            var player = new Player(name);

            //save Player to db;
            db.savePlayer(player);

            //welcome player and start game:
            System.out.println("Welcome " + name + "!");
            var game = new Game(player, db);
            game.startCommandLineGame();

            //close database (since the game will be finished by then)
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong during the database connection");
            try {
                db.close();
            } catch (SQLException ignored) {}
            System.exit(0);
        }
    }
}
