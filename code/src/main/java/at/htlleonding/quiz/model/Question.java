package at.htlleonding.quiz.model;

public class Question {
    private final String text;
    private final int difficulty;

    public Question(String text, int difficulty) {
        this.text = text;
        this.difficulty = difficulty;
    }

    public String getText() {
        return text;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
