package com.niit.cmsdemo.domain;

import java.io.Serializable;

public class Feedback implements Serializable {

    private static final long serialVersionUID = 6810521376372709123L;

    private Long stuId;
    private String answer;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                ", stuId=" + stuId +
                ", answer='" + answer + '\'' +
                '}';
    }
}
