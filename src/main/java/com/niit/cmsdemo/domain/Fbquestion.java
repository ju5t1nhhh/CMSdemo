package com.niit.cmsdemo.domain;

import java.io.Serializable;

public class Fbquestion implements Serializable{

    private static final long serialVersionUID = 3052638213290222589L;

    private Integer id;
    private Integer location;
    private String details;
    private String type;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Fbquestion{" +
                "id=" + id +
                ", location=" + location +
                ", details='" + details + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
