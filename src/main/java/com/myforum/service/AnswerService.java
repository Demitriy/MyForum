package com.myforum.service;

import com.myforum.database.Answer;
import com.myforum.database.Question;

import java.util.List;

/**
 * Created by dsvetyshov on 07.03.2017.
 */
public interface AnswerService {

    boolean addAnswer(Answer answer);

    List<Answer> getAnswers(Question question);



}
