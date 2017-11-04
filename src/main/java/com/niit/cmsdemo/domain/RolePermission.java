package com.niit.cmsdemo.domain;

import java.io.Serializable;
import java.util.Date;

public class RolePermission implements Serializable{

    private static final long serialVersionUID = -637125409249614197L;

    private Long roleId;
    private Long permId;
    private Date createTime;
    private Date updateTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "roleId=" + roleId +
                ", permId=" + permId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
