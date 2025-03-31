package org.skypro.coursework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.coursework.model.question.Question;
import org.skypro.coursework.service.JavaQuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @InjectMocks
    JavaQuestionService javaQuestionService = new JavaQuestionService(new HashSet<>());

    @Test
    public void givenQuestionStringAndAnswerString_whenAddQuestion_thenReturnCollectionWithPreviouslyAddedQuestion(){
        String question = "some question";
        String answer = "some answer";
        Collection<Question> expected = new HashSet<>(List.of(new Question(question, answer)));

        javaQuestionService.add(question, answer);
        Collection<Question> actual = javaQuestionService.getAll();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void givenQuestion_whenAddQuestion_thenReturnCollectionWithPreviouslyAddedQuestion(){
        Question question = new Question("some question", "some answer");
        Collection<Question> expected = new HashSet<>(List.of(question));

        javaQuestionService.add(question);
        Collection<Question> actual = javaQuestionService.getAll();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void givenCollectionWithElements_whenRemoveQuestion_thenReturnCollectionWithoutPreviouslyRemovedQuestion(){
        javaQuestionService.add(new Question("question 1", "answer 1"));
        javaQuestionService.add(new Question("question 2", "answer 2"));
        Collection<Question> expected = new HashSet<>(
                List.of(new Question("question 2", "answer 2")));


        javaQuestionService.remove(new Question("question 1", "answer 1"));
        Collection<Question> actual = javaQuestionService.getAll();

        Assertions.assertEquals(expected, actual);
    }
}
