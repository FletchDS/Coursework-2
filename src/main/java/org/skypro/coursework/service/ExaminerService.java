package org.skypro.coursework.service;

import org.skypro.coursework.model.question.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
