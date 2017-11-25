package com.niit.cmsdemo.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class Feedback implements Serializable {

    private static final long serialVersionUID = 6810521376372709123L;

    private Long stuId;
    private String[] answers;
    private Date createTime;
    private Date updateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
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
        return "Feedback{" +
                "stuId=" + stuId +
                ", answers=" + Arrays.toString(answers) +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
