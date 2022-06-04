package at.htl.quiz.model;

public class Answer {
    private final String text;
    private final boolean isCorrect;
    private final int points;
    private final Question question;

    public Answer(String text, boolean isCorrect, int points, Question question) {
        this.text = text;
        this.isCorrect = isCorrect;
        this.points = points;
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public int getPoints() {
        return points;
    }

    public Question getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "text='" + text + '\'' +
                ", isCorrect=" + isCorrect +
                ", points=" + points;
    }
}
