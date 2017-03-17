package com.myforum.controller;

import com.myforum.database.Answer;
import com.myforum.database.Question;
import com.myforum.service.AnswerService;
import com.myforum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ModelAndView showAnswers(@PathVariable String questinId) {
        Question question = questionService.getQuestionByID(Integer.valueOf(questinId));
        List<Answer> list = answerService.getAnswers(question);
        Map<String, Object> map = new HashMap<>();
        map.put("question", question);
        map.put("answers", list);
        return new ModelAndView("addAnswerOnQuestion", map);
    }

    @PostMapping("/question/{questinId:[0-9]+}")
    public String addComment(@PathVariable String questinId, @RequestParam("answer") String answer) {
        Answer myAnswer = new Answer();
        myAnswer.setComment(answer);
        myAnswer.setQuestion(questionService.getQuestionByID(Integer.valueOf(questinId)));
        answerService.addAnswer(myAnswer);
        return "redirect:/question/"+questinId;
    }
}
