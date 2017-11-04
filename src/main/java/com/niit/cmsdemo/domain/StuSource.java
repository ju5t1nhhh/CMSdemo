package com.niit.cmsdemo.domain;

import java.util.Date;

public class StuSource {
    private Integer id;
    private String name;
    private Integer type;
    private Integer parent_id;
    private Date create_time;
    private Date update_time;

    @Override
    public String toString() {
        return "StuSource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", parent_id=" + parent_id +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
