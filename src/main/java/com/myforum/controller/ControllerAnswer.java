package com.myforum.controller;

import com.myforum.constants.Role;
import com.myforum.database.Answer;
import com.myforum.database.Question;
import com.myforum.service.AnswerService;
import com.myforum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

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
    public String showAnswers(@PathVariable int questinId, ModelMap modelMap) {
        Question question = questionService.getQuestionByID(questinId);
        List<Answer> list = answerService.getAnswers(question);
        modelMap.addAttribute("question", question);
        modelMap.addAttribute("answers", list);
/*        System.out.println((Role)modelMap.get("role"));*/
        return "addionAnswerOnQuestion";
    }

    @PostMapping("/**/question/{questinId:[0-9]+}")
    public String addComment(@PathVariable int questinId, @RequestParam("answer") String answer, ModelMap modelMap) {
        Answer myAnswer = new Answer();
        myAnswer.setComment(answer);
        myAnswer.setQuestion(questionService.getQuestionByID(questinId));
        answerService.addAnswer(myAnswer);
        return showAnswers(questinId, modelMap);
    }
}
