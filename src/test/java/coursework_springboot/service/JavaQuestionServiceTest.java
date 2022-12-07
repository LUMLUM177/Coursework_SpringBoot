package coursework_springboot.service;

import coursework_springboot.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    public static final  Question question1 = new Question("Что?", "Встреча");
    public static final  Question question2 = new Question("Где?", "Дома");
    public static final  Question question3 = new Question("Когда?", "Сегодня");


    private final JavaQuestionService out = new JavaQuestionService();

    private Set<Question> actualQuestion;

    @BeforeEach
    public void setUp() {
        out.add(question1);
        out.add(question2);
        out.add(question3);

        actualQuestion = new HashSet<>(Set.of(question1, question2, question3));
    }

    @Test
    public void shouldReturnAddQuestionCorrectlyDataQuestion() {
        Question question = new Question("Как дела?", "Хорошо");
        Question result = out.add(question);
        assertEquals(question, result);
        actualQuestion.add(question);
        assertArrayEquals(actualQuestion.toArray(), out.getAll().toArray());
    }

    @Test
    public void shouldReturnRemoveQuestionCorrectlyDataQuestion() {
        Question result = out.remove(question1);
        assertEquals(question1, result);
        actualQuestion = new HashSet<>(Set.of(question2, question3));
        assertArrayEquals(actualQuestion.toArray(), out.getAll().toArray());
    }

    @Test
    public void shouldReturnAllQuestions() {
        Collection<Question> result = out.getAll();
        actualQuestion = new HashSet<>(Set.of(question1, question2, question3));
        assertArrayEquals(actualQuestion.toArray(), result.toArray());
    }

    @Test
    public void shouldReturnRandomQuestions() {
        Question result = out.getRandomQuestion();
        assertEquals(result, question1);
    }
}