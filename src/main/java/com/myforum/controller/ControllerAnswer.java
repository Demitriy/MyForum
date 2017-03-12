package com.myforum.controller;

import com.myforum.service.AnswerService;
import com.myforum.service.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by dsvetyshov on 07.03.2017.
 */
@Controller
public class ControllerAnswer {

    @Autowired
    private AnswerServiceImpl answerService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String firstTry() {
        System.out.println("answerService " + answerService);
        System.out.println("AnserDAO " + answerService.getAnswerDAO());
        System.out.println("DataSource " + answerService.getAnswerDAO().getDataSource());
        try {
            Context initContext = new InitialContext();
            System.out.println((DataSource) initContext.lookup("java:comp/env/jdbc/myforum"));
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return "/index";
    }
}
