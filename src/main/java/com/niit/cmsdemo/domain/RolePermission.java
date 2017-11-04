package com.niit.cmsdemo.domain;

<<<<<<< HEAD
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
=======
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
>>>>>>> 51b4b38c087f7457ff0210accdab3d730613d78f
    }
}
