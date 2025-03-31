package org.skypro.coursework.controller;

import org.skypro.coursework.model.exception.RequestedMoreQuestionsThanExistedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExaminerQuestionControllerAdvice {

    @ExceptionHandler(RequestedMoreQuestionsThanExistedException.class)
    public ResponseEntity<String> getQuestionsHandler( RequestedMoreQuestionsThanExistedException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
