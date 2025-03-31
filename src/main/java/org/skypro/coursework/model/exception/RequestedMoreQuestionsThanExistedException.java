package org.skypro.coursework.model.exception;

public class RequestedMoreQuestionsThanExistedException extends RuntimeException{

    public RequestedMoreQuestionsThanExistedException() { super("Запрошено больше вопросов, чем существовало");}
}
