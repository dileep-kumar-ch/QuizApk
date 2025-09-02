package com.dileep.quizapk.Service;

import com.dileep.quizapk.Entity.Question;
import com.dileep.quizapk.Repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class questionServiceImplementation implements questionServices {
    @Autowired
    QuestionRepo questionRepo;

    @Override
    public Question add(Question q) {
        questionRepo.save(q);
        return q;
    }

    @Override
    public List<Question> getAllQuestions() {
       return questionRepo.findAll(); // gives a list {findall}
    }

    @Override
    public List<Question> addQuestionList(List<Question> qlist) {
       return questionRepo.saveAll(qlist);
    }

    @Override
    public List<Question> QuestionByCategory(String language) {
        return questionRepo.getQuestionsByLanguage(language);
    }

//    @Override
//    public List<Question> CreateQuiz(String language, int numq) {
//        return questionRepo.findByLanguage(language,numq);
//    }


}
