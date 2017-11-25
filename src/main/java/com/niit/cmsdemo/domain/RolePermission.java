package com.niit.cmsdemo.domain;

import java.io.Serializable;

public class RolePermission implements Serializable{

    private static final long serialVersionUID = -637125409249614197L;

    private Long roleId;
    private Long permId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermId() {
        return permId;
    }

    public void setPermId(Long permId) {
        this.permId = permId;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "roleId=" + roleId +
                ", permId=" + permId +
                '}';
    }
}
