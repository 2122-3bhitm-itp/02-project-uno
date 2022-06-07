package at.htl.quiz.model;

import java.util.List;

public class Question {
    private final String text;
    private final int difficulty;

    private List<Answer> answers;

    public Question(String text, int difficulty, List<Answer> answers) {
        this.text = text;
        this.difficulty = difficulty;
        this.answers = answers;
    }

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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getCorrectAnswers() {
        return this.answers.stream()
                .filter(Answer::isCorrect)
                .toList();
    }

    public boolean isCorrect(Answer answer) {
        List<Answer> correct = getCorrectAnswers();
        return correct.contains(answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", difficulty=" + difficulty +
                ", answers=" + answers +
                '}';
    }
}
