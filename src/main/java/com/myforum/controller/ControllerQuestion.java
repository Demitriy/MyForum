package com.myforum.controller;

import com.myforum.database.Question;
import com.myforum.service.AnswerService;
import com.myforum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Generated;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dsvetyshov on 07.03.2017.
 */
@Controller
public class ControllerQuestion {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public ModelAndView main(@RequestParam(value = "search", required = false) String search)  {
        System.out.println("break");
        List<Question> list;
        if (search == null || search.trim().equals("")) list = questionService.getAllQuestions();
        else {
            System.out.println("SEARCH");
            list = questionService.searchByTitle(search);
            //System.out.println(search);
        }
        return new ModelAndView("main", "listTitle", list);
    }

    @PostMapping("/")
    public ModelAndView addQuestion(@RequestParam("title") String title, @RequestParam("content") String content) {
        Question question = new Question();
        question.setTitle(title.toLowerCase());
        question.setContent(content);
        if (questionService.addQuestion(question)) return main("");
        else {
            Map<String, Object> map = new HashMap<>();
            map.put("flag", true);
            map.put("value", title);
            return new ModelAndView("addionQuestion", map);
        }
    }

    @GetMapping(value = "/**/NewQuestion")
    public String openAddionQuestion() {
        return "addionQuestion";
    }

}
