package com.myforum.controller;

import com.myforum.database.Question;
import com.myforum.service.AnswerService;
import com.myforum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dsvetyshov on 07.03.2017.
 */
@Controller
public class ControllerAnswer {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{questinId}")
    public ModelAndView firstTry(@PathVariable String questinId) {
        Question question = questionService.getQuestionByID(Integer.valueOf(questinId));
        System.out.println(question.getId());
        System.out.println(question.getTitle());
        System.out.println(question.getContent());
        return new ModelAndView("addAnswerOnQuestion", "question", question);
    }

    @PostMapping("/answer")
    public String firstTry2(HttpServletRequest request) {
        System.out.println(request.getContextPath());
        System.out.println(request.getSession());
        Question question = new Question();
        question.setId(1);
        //answerService.addAnswer(new Answer(question, "Privetk"));
        System.out.println("firsttry2");
        return "main";
    }
}
