package com.myforum.dao;

import com.myforum.database.Answer;
import com.myforum.database.Question;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by dsvetyshov on 06.03.2017.
 */
public interface AnswerDAO {

    void addAnswer(Answer answer);

    List<Answer> getAnswersByQuestion(Question question);

}
