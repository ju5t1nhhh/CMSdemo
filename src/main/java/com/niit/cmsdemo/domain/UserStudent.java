package com.niit.cmsdemo.domain;

import java.io.Serializable;
import java.util.Date;

public class UserStudent implements Serializable{

    private static final long serialVersionUID = 89113038154222118L;

    private String userId;
    private Long stuId;
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

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
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
        return "UserStudent{" +
                "userId='" + userId + '\'' +
                ", stuId=" + stuId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
