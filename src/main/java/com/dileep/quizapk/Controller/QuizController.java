package com.dileep.quizapk.Controller;

import com.dileep.quizapk.Entity.Question;
import com.dileep.quizapk.Service.quizService;
import com.dileep.quizapk.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    quizService quizService;

    @PostMapping ("/create")
    public QuizDto createQuiz(@RequestParam String language,@RequestParam String title,@RequestParam int numq) {
     QuizDto quizQuestionsDtos =  quizService.createQuiz(language,title,numq);
        return quizQuestionsDtos;
    }

    @PostMapping("/Submit")
    public quizSubmitResponseDto quizSubmit(@RequestBody QuizSubmitDto submitt)  {
    Long quizzid = submitt.getQuizid();
    List<QuestionAnswerDto> answers = submitt.getResponse();

   quizSubmitResponseDto response = quizService.response(quizzid,answers);

   return response;
    }


}
