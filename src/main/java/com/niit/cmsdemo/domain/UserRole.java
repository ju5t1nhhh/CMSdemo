package com.niit.cmsdemo.domain;

<<<<<<< HEAD
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
=======
import java.io.Serializable;
import java.util.Date;

public class UserRole implements Serializable{

    private static final long serialVersionUID = -269214636460267381L;

    private String userId;
    private Long roleId;
    private Date createTime;
    private Date updateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
        return "UserRole{" +
                "userId='" + userId + '\'' +
                ", roleId=" + roleId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
>>>>>>> 51b4b38c087f7457ff0210accdab3d730613d78f
    }
}
