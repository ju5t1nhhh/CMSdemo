package com.niit.cmsdemo.domain;

import java.util.Date;

public class RolePermission {
    private Integer role_id;
    private Integer perm_id;
    private Date create_time;
    private Date update_time;

    @Override
    public String toString() {
        return "RolePermission{" +
                "role_id=" + role_id +
                ", perm_id=" + perm_id +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getPerm_id() {
        return perm_id;
    }

    public void setPerm_id(Integer perm_id) {
        this.perm_id = perm_id;
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
