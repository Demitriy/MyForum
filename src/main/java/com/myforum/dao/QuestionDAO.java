package com.myforum.dao;

import com.myforum.database.Question;

import java.util.List;

/**
 * Created by dsvetyshov on 06.03.2017.
 */
public interface QuestionDAO {

    boolean addQuestion(Question question);

    boolean deleteQuestion(Question question);

    boolean deleteQuestionByID(String id);

    List<Question> getAllQuestions();

    Question getQuestionByID(Integer id);

    List<Question> getQuestionsByTitle(String title);
}
