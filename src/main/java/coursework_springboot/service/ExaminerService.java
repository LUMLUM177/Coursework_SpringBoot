package coursework_springboot.service;

import coursework_springboot.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getRandomQuestions(int amount);
}
