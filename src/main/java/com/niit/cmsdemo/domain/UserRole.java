package com.niit.cmsdemo.domain;

import java.io.Serializable;

public class UserRole implements Serializable{

    private static final long serialVersionUID = -269214636460267381L;

    private String userId;
    private Integer roleId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userId='" + userId + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
