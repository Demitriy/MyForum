package com.myforum.service;

import com.myforum.dao.AnswerDAO;
import com.myforum.database.Answer;
import com.myforum.database.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dsvetyshov on 07.03.2017.
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerDAO answerDAO;

    public boolean addAnswer(Answer answer) {
        answer.setComment(answer.getComment().trim());
        return answerDAO.addAnswer(answer);
    }

    public List<Answer> getAnswers(Question question) {
        return answerDAO.getAnswers(question);
    }

}