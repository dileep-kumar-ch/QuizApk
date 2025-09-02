package com.dileep.quizapk.Controller;

import com.dileep.quizapk.Entity.Question;
import com.dileep.quizapk.Service.questionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    questionServices services;
    @PostMapping("/AddQuestion")
    public Question addQuestions(@RequestBody Question q) {
        services.add(q);
        return q;
    }

    @GetMapping("/getAllQuestions")
    public List<Question> getAllQuestions() {
        return services.getAllQuestions();
    }

    @PostMapping("/questionsbulk")
    public ResponseEntity<List<Question>> addQuestions(@RequestBody List<Question> qlist) {
        List<Question> savedQuestions = services.addQuestionList(qlist);

        return ResponseEntity
                .status(HttpStatus.CREATED)  // returns 201 Created
                .body(savedQuestions);       // body contains all saved questions
    }
    @GetMapping("QuestionsByCategory")
    public ResponseEntity<List<Question>> QuestionByCategory(@RequestParam String language) {
       List<Question> categoryQuestions =  services.QuestionByCategory(language);
        return ResponseEntity
                .status(HttpStatus.CREATED)  // returns 201 Created
                .body(categoryQuestions);
    }

}
