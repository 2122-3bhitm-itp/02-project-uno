package at.htlleonding.quiz.model;

public class Game_Question {
    private Game game;
    private Question question;
    private Player player;

    public Game_Question(){}

    public Game_Question(Game game, Question question, Player player) {
        this.game = game;
        this.question = question;
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
