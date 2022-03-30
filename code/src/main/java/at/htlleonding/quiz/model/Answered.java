package at.htlleonding.quiz.model;

public class Answered {
    private Answer answer;
    private Game_Question game_question;

    public Answered() {
    }

    public Answered(Answer answer, Game_Question game_question) {
        this.answer = answer;
        this.game_question = game_question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Game_Question getGame_question() {
        return game_question;
    }

    public void setGame_question(Game_Question game_question) {
        this.game_question = game_question;
    }
}
