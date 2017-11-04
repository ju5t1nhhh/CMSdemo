package com.niit.cmsdemo.domain;

import java.util.Date;

public class UserStudent {
    private Integer user_id;
    private Integer stu_id;
    private Date create_time;
    private Date update_time;

    @Override
    public String toString() {
        return "UserStudent{" +
                "user_id=" + user_id +
                ", stu_id=" + stu_id +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getStu_id() {
        return stu_id;
    }

    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
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
