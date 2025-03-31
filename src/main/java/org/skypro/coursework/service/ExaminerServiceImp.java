package org.skypro.coursework.service;

import org.skypro.coursework.model.exception.RequestedMoreQuestionsThanExistedException;
import org.skypro.coursework.model.question.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImp implements ExaminerService {

    private QuestionService questionService;

    public ExaminerServiceImp(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> questions = new HashSet<>();
        int count = amount;

        if (amount > questionService.getAll().size()) {
            throw new RequestedMoreQuestionsThanExistedException();
        }

        while (count > 0) {
            Question question = questionService.getRandomQuestion();
            if (!questions.contains(question)){
                questions.add(question);
                count--;
            }
        }

        return questions;
    }
}
