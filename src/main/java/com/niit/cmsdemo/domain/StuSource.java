package com.niit.cmsdemo.domain;

import java.io.Serializable;

public class StuSource implements Serializable{

    private static final long serialVersionUID = 2065837602933923908L;

    private Integer id;
    private String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StuSource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
