package com.myforum.database;

/**
 * Created by dsvetyshov on 06.03.2017.
 */
public class Answer {

    private int id;
    private Question question;
    private String comment;

    public Answer() {
    }

    public Answer(Question question, String comment) {
        this.question = question;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
