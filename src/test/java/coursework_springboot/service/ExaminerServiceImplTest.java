package coursework_springboot.service;

import coursework_springboot.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private Set<Question> actualQuestion;

    @BeforeEach
    public void setUp() {
        Question question1 = new Question("Что?", "Встреча");
        Question question2 = new Question("Когда?", "Сегодня");
        Question question3 = new Question("Где?", "Дома");
        actualQuestion = new HashSet<>(Set.of(question3, question2, question1));
        when(questionService.getRandomQuestion()).thenReturn(question3, question2, question1);
    }

    @Test
    public void shouldReturnRandomQuestions() {

        final int amount = 3;

        Collection<Question> result = examinerService.getRandomQuestions(amount);

        assertArrayEquals(actualQuestion.toArray(), result.toArray());
    }

    @Test
    public void shouldThrowExceptionWhenAmountQuestionsMoreSizeCollectionThrowsExceptions() {
        when(questionService.getRandomQuestion())
                .thenThrow(ResponseStatusException.class);

        assertThrows(ResponseStatusException.class, () -> questionService.getRandomQuestion());
    }
}