package com.myforum.controller;

import com.myforum.database.Answer;
import com.myforum.database.Question;
import com.myforum.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

/**
 * Created by dsvetyshov on 07.03.2017.
 */
@Controller
public class ControllerAnswer {

    @Autowired
    private AnswerService answerService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String firstTry(HttpServletRequest request) {
        System.out.println(request.getContextPath());
        System.out.println(request.getSession());
        Question question = new Question();
        question.setId(1);
        //answerService.addAnswer(new Answer(question, "Privetk"));
        return "index";
    }
}
