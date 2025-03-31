package org.skypro.coursework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.coursework.model.exception.RequestedMoreQuestionsThanExistedException;
import org.skypro.coursework.model.question.Question;
import org.skypro.coursework.service.ExaminerServiceImp;
import org.skypro.coursework.service.JavaQuestionService;
import org.skypro.coursework.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImpTest {

    @Mock
    QuestionService javaQuestionService = new JavaQuestionService(new HashSet<>());

    @InjectMocks
    ExaminerServiceImp examinerServiceImp;

    @Test
    public void givenCollectionWithElements_whenGetQuestions_thenReturnCollectionWithSameElements() {
        Question question1 = new Question("question 1", "answer 1");
        Question question2 = new Question("question 2", "answer 2");
        Question question3 = new Question("question 3", "answer 3");
        Mockito.doReturn(new HashSet<>(List.of(question1, question2, question3))).when(javaQuestionService).getAll();
        Mockito.doReturn(question2).when(javaQuestionService).getRandomQuestion();
        Collection<Question> expected = new HashSet<>(List.of(new Question("question 2", "answer 2")));

        Collection<Question> actual = examinerServiceImp.getQuestions(1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void givenEmptyCollection_whenGetQuestions_thenThrowRequestedMoreQuestionsThanExistedException() {
        Question question1 = new Question("question 1", "answer 1");
        Question question2 = new Question("question 2", "answer 2");
        Mockito.doReturn(new HashSet<>(List.of(question1, question2))).when(javaQuestionService).getAll();
        Exception thrownException = null;

        try {
            Collection<Question> collection = examinerServiceImp.getQuestions(3);
        }catch (Exception e){
            thrownException = e;
        }

        Assertions.assertInstanceOf(RequestedMoreQuestionsThanExistedException.class, thrownException);
    }

}
