package coursework_springboot.service;

import coursework_springboot.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Question randomQuestion = new Question("test", "test");
        Random random = new Random();
        int number = random.nextInt(questions.size());
        int i = 0;
        for (Question question : questions) {
            if (i == number) {
                randomQuestion = question;
            }
            i++;
        }
        return randomQuestion;
    }
}
