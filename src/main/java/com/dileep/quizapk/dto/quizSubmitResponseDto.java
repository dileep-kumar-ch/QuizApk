package com.dileep.quizapk.dto;

import java.security.PrivateKey;

public class quizSubmitResponseDto {
    private Long quizid;
    private Long score;

    public quizSubmitResponseDto(Long quizid, Long score) {
        this.quizid = quizid;
        this.score = score;
    }

    public quizSubmitResponseDto() {
        super();
    }

    public Long getQuizid() {
        return quizid;
    }

    public void setQuizid(Long quizid) {
        this.quizid = quizid;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "quizSubmitResponseDto{" +
                "quizid=" + quizid +
                ", score=" + score +
                '}';
    }
}
