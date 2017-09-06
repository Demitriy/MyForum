package com.myforum.controller;

import com.myforum.constants.Role;
import com.myforum.database.Answer;
import com.myforum.database.Question;
import com.myforum.database.User;
import com.myforum.service.AnswerService;
import com.myforum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dsvetyshov on 07.03.2017.
 */
@Controller
public class ControllerAnswer extends BaseController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/**/question/{questinId:[0-9]+}")
    public ModelAndView showAnswers(@PathVariable int questinId, ModelMap modelMap) {
        Question question = questionService.getQuestionByID(questinId);
        List<Answer> list = answerService.getAnswers(question);
        modelMap.addAttribute("question", question);
        modelMap.addAttribute("answers", list);
        return new ModelAndView("addionAnswerOnQuestion", modelMap);
    }

/*    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User showAnswers2() {
        User user = new User();
        user.setName("djf");
        return user;
    }*/

    @PostMapping("/**/question/{questinId:[0-9]+}")
    public ModelAndView addComment(@PathVariable int questinId, @RequestParam("answer") String answer, ModelMap modelMap) {
        if (modelMap.get("role") == Role.GUEST) {
            RedirectView redirectView = new RedirectView("/MyForum/login");
            redirectView.setExposeModelAttributes(false);
            return new ModelAndView(redirectView);
        }
        Answer myAnswer = new Answer();
        myAnswer.setComment(answer);
        myAnswer.setQuestion(questionService.getQuestionByID(questinId));
        myAnswer.setUser((User) modelMap.get("authUser"));
        answerService.addAnswer(myAnswer);
        return showAnswers(questinId, modelMap);
    }
}
