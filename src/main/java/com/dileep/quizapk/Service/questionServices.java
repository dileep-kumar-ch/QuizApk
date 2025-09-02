package com.dileep.quizapk.Service;

import com.dileep.quizapk.Entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface questionServices {
    Question add(Question q);
    List<Question> getAllQuestions();
    List<Question> addQuestionList(List<Question> qlist);
    List<Question> QuestionByCategory(String language);
//    List<Question> CreateQuiz(String language, int numq);
}
