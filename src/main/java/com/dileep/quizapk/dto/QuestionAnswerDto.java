package com.dileep.quizapk.dto;

public class QuestionAnswerDto {
    private Long questionId;
    private String response;  // what the user selected/typed

    public QuestionAnswerDto(Long questionId, String response) {
        this.questionId = questionId;
        this.response = response;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
