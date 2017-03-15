package com.myforum.controller;

import com.myforum.database.Question;
import com.myforum.service.AnswerService;
import com.myforum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dsvetyshov on 07.03.2017.
 */
@Controller
public class ControllerQuestion {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public ModelAndView main() {
        List<Question> list = questionService.getAllQuestions();
        return new ModelAndView("main", "listTitle", list);
    }

    @PostMapping("/")
    public String main(@RequestParam("title") String title, @RequestParam("content") String content) {
        Question question = new Question();
        question.setTitle(title);
        question.setContent(content);
        questionService.addQuestion(question);
        return "redirect:/";
    }

    @GetMapping("/NewQuestion")
    public String addQuestion() {
        return "/addQuestion";
    }

}
