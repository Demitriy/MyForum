package com.myforum.service;

import com.myforum.dao.AdminDAO;
import com.myforum.database.Admin;
import com.myforum.database.Answer;
import com.myforum.database.Question;
import com.myforum.database.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Created by Dima on 05.09.2017.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    public boolean isAdmin(Integer id) {
        return adminDAO.getAdminByID(id) != null ? true : false;
    }

    public boolean isAdmin(User user) {
        return adminDAO.getAdminByUser(user) != null ? true : false;
    }

    public boolean deleteAnswerByID(String id) {
        return false;
    }

    public boolean deleteAnser(Answer answer) {
        return false;
    }

    public boolean deleteQuestionByID(String id) {
        return false;
    }

    public boolean deleteQuestion(Question question) {
        return false;
    }
}
