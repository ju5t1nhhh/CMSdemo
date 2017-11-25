package com.niit.cmsdemo.domain;

import java.io.Serializable;
import java.util.Date;

public class FollowUp implements Serializable{

    private static final long serialVersionUID = 7739080562736951912L;

    private Long id;
    private Long stuId;
    private String note;
    private Character classification;
    private Date createTime;
    private Date updateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Character getClassification() {
        return classification;
    }

    public void setClassification(Character classification) {
        this.classification = classification;
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
        return "FollowUp{" +
                "id=" + id +
                ", stuId=" + stuId +
                ", note='" + note + '\'' +
                ", classification=" + classification +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
