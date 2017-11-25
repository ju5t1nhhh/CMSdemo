package com.niit.cmsdemo.domain;

import java.io.Serializable;

public class Fbanswer implements Serializable{

    private static final long serialVersionUID = -6980022559778792202L;

    private Integer id;
    private Integer questionId;
    private Integer location;
    private String details;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Fbanswer{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", location=" + location +
                ", details='" + details + '\'' +
                '}';
    }
}
