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
            db = new Repo();
        } catch (SQLException e) {
            System.out.println("Could not connect to Database, try again");
            System.exit(0);
        }

        System.out.print("Player name: ");
        String name = CommandLineUtil.getLine();
        System.out.println("Welcome " + name + "!");

        var game = new Game(new Player(name), db);
        game.startCommandLineGame();

        try {
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
