package com.myforum.dao;

import com.myforum.database.Question;

import java.util.List;

/**
 * Created by dsvetyshov on 06.03.2017.
 */
public interface QuestionDAO {

    void addQuestion(Question question);

    List<Question> getAllQuestions();

}