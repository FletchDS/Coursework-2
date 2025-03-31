package org.skypro.coursework.controller;

import org.skypro.coursework.model.question.Question;
import org.skypro.coursework.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("/exam/java")
@RestController
public class JavaQuestionController {
    private final QuestionService javaQuestionService;

    public JavaQuestionController(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer){
        return javaQuestionService.add(question, answer);
    }

    @GetMapping
    public Collection<Question> getQuestions(){
        return javaQuestionService.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer){
        Question questionForRemove = new Question(question, answer);
        return javaQuestionService.remove(questionForRemove);
    }
}
