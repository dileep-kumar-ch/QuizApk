package com.dileep.quizapk.Service;

import com.dileep.quizapk.Entity.Question;
import com.dileep.quizapk.Entity.Quiz;
import com.dileep.quizapk.Repository.QuestionRepo;
import com.dileep.quizapk.Repository.quizRepo;
import com.dileep.quizapk.dto.QuestionAnswerDto;
import com.dileep.quizapk.dto.QuizDto;
import com.dileep.quizapk.dto.QuizQuestionsDto;
import com.dileep.quizapk.dto.quizSubmitResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class quizServiceImplementation implements quizService{
    @Autowired
    quizRepo quizRepo;

    @Autowired
    QuestionRepo questionRepo;

    @Override
    public QuizDto createQuiz(String language, String title, int numq) {
       List<Question> questions = questionRepo.findRandomQuestionsByLanguage( language, numq);

        // creating quiz
       Quiz quiz = new Quiz();
       quiz.setTitle(title);
       quiz.setLanguage(language);
       quiz.setQuestions(questions);

        // Save Quiz first to generate ID
        Quiz savedQuiz = quizRepo.save(quiz);

        // convert entity to dto
        QuizDto quizDto = new QuizDto();
        quizDto.setId(quiz.getId());
        quizDto.setTitle(quiz.getTitle());
        // add the db questions to dto questions class
        List<QuizQuestionsDto> dtoQuestionList = new ArrayList<>();
        for(Question q : questions) {
            QuizQuestionsDto questionsDto = new QuizQuestionsDto();
            questionsDto.setId(q.getId());
            questionsDto.setQuestionTitle(q.getQuestionTitle());
            questionsDto.setOptionA(q.getOptionA());
            questionsDto.setOptionB(q.getOptionB());
            questionsDto.setOptionC(q.getOptionC());
            questionsDto.setOptionD(q.getOptionD());

            dtoQuestionList.add(questionsDto);
        }
        quizDto.setQuestions(dtoQuestionList);
        return quizDto;
    }

    @Override
    public quizSubmitResponseDto response(long quizid, List<QuestionAnswerDto> response) {

        // Fetch quiz from DB
        Quiz quiz = quizRepo.findById(quizid)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        long score = 0;

        List<QuestionAnswerDto> results = new ArrayList<>();
        for(QuestionAnswerDto questionAnswerDto : response) {

            Optional<Question> question = questionRepo.findById(questionAnswerDto.getQuestionId());
            if (question.isPresent()) {
                Question question1 = question.get();
                if (question1.getCorrectAnswer().equalsIgnoreCase(questionAnswerDto.getResponse())) {
                    score++;
                }
            }

        }
        // Prepare response
        quizSubmitResponseDto  submitresponse = new quizSubmitResponseDto();
        submitresponse .setQuizid(quiz.getId());
        submitresponse.setScore(score);

        return submitresponse;

    }
}
