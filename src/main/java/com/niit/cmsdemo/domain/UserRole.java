package com.niit.cmsdemo.domain;

import java.util.Date;

public class UserRole {
    private String user_id;
    private Integer role_id;
    private Date create_time;
    private Date update_time;

    @Override
    public String toString() {
        return "Advertise{" +
                "user_id='" + user_id + '\'' +
                ", role_id=" + role_id +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
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
