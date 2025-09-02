package com.dileep.quizapk.Service;

import com.dileep.quizapk.Entity.Question;
import com.dileep.quizapk.dto.QuestionAnswerDto;
import com.dileep.quizapk.dto.QuizDto;
import com.dileep.quizapk.dto.quizSubmitResponseDto;

import java.util.List;

public interface quizService {
    QuizDto createQuiz(String language, String title, int numq);
    quizSubmitResponseDto response(long quizid, List<QuestionAnswerDto> response);
}
