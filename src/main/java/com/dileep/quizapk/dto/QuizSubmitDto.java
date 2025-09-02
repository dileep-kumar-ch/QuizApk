package com.dileep.quizapk.dto;

import java.util.List;

public class QuizSubmitDto {
    private Long quizid;
    private List<QuestionAnswerDto> response;

    public QuizSubmitDto(Long quizid, List<QuestionAnswerDto> response) {
        this.quizid = quizid;
        this.response = response;
    }

    public Long getQuizid() {
        return quizid;
    }

    public void setQuizid(Long quizid) {
        this.quizid = quizid;
    }

    public List<QuestionAnswerDto> getResponse() {
        return response;
    }

    public void setResponse(List<QuestionAnswerDto> response) {
        this.response = response;
    }
}
