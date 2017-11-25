package com.niit.cmsdemo.domain;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable{

    private static final long serialVersionUID = 2633064455554920110L;

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
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
