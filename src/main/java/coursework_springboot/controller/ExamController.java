package coursework_springboot.controller;

import coursework_springboot.model.Question;
import coursework_springboot.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }


    @GetMapping("/get/{amount}")
    public Collection<Question> getRandomQuestion(@PathVariable("amount") int amount) {
        return this.service.getRandomQuestions(amount);
    }
}
