package com.myforum.controller;

import com.myforum.constants.Role;
import com.myforum.database.Admin;
import com.myforum.database.Question;
import com.myforum.database.User;
import com.myforum.service.AnswerService;
import com.myforum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
public class ControllerQuestion extends BaseController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String main(@RequestParam(value = "search", required = false) String search, ModelMap modelMap)  {
        List<Question> list;
        if (search == null || search.trim().equals("")) list = questionService.getAllQuestions();
        else {
            list = questionService.searchByTitle(search);
        }
        modelMap.addAttribute("listTitle", list);
        Role role = (Role) modelMap.get("role");
        System.out.println(role.name());
        if (Role.GUEST != role) {
            //modelMap.addAttribute("", "");
        }
        return "main";
    }

    @PostMapping("/")
    public String addQuestion(@RequestParam("title") String title, @RequestParam("content") String content, ModelMap modelMap) {
        Question question = new Question();
        question.setTitle(title);
        question.setContent(content);
        if (questionService.addQuestion(question)) return main(null, modelMap);
        else {
            modelMap.addAttribute("flag", true);
            modelMap.addAttribute("value", title);
            return "addionQuestion";
        }
    }

    @GetMapping(value = "/**/NewQuestion")
    public String openAddionQuestion() {
        return "addionQuestion";
    }

}
