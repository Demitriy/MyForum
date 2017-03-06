package com.myForum.DAO;

import com.myForum.DatabaseEntity.Answer;
import com.myForum.DatabaseEntity.Question;

import java.util.List;

/**
 * Created by dsvetyshov on 06.03.2017.
 */
public interface AnswerDAO {

    void addAnswer(Answer answer);

    List<Answer> getAnswers(Question question);

}
