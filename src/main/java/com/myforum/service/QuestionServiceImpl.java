package com.myforum.service;

import com.myforum.dao.QuestionDAO;
import com.myforum.database.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dsvetyshov on 07.03.2017.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDAO questionDAO;

    public boolean addQuestion(Question question) {
        question.setTitle(question.getTitle().trim());
        return questionDAO.addQuestion(question);
    }

    public List<Question> getAllQuestions() {
        return questionDAO.getAllQuestions();
    }

    public Question getQuestionByID(Integer id) {
        return questionDAO.getQuestionByID(id);
    }

    public List<Question> searchByTitle(String title) {
        return questionDAO.getQuestionsByTitle(title);
    }
}
