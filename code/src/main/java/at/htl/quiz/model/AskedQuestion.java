package at.htl.quiz.model;

public class AskedQuestion {
    private final Question question;
    private final Answer answer;

    public AskedQuestion(Question question, Answer answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public Answer getAnswer() {
        return answer;
    }
}
