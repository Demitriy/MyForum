package com.myforum.service;

import com.myforum.database.Question;

import java.util.List;

/**
 * Created by dsvetyshov on 07.03.2017.
 */
public interface QuestionService {

    boolean addQuestion(Question question);

    List<Question> getAllQuestions();

    Question getQuestionByID(Integer id);

    List<Question> searchByTitle(String title);
}