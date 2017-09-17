package com.myforum.service;

import com.myforum.database.Answer;
import com.myforum.database.Question;
import com.myforum.database.User;

/**
 * Created by Dima on 05.09.2017.
 */
public interface AdminService {

    boolean isAdmin(Integer id);

    boolean isAdmin(User user);

    boolean deleteAnswerByID(String id);

    boolean deleteAnser(Answer answer);

    boolean deleteQuestionByID(String id);

    boolean deleteQuestion(Question question);
}
