package com.dileep.quizapk.dto;

import java.util.List;

public class QuizDto {
    private long id;
    private String title;
    private List<QuizQuestionsDto> questions;

    public QuizDto() {
    super();
    }

    public QuizDto(long id, String title, List<QuizQuestionsDto> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuizQuestionsDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuizQuestionsDto> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "QuizDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", questions=" + questions +
                '}';
    }
}
