package at.htl.quiz.model;

public class AskedQuestions {
    private final Question question;
    private final Answer answer;

    public AskedQuestions(Question question, Answer answer) {
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
