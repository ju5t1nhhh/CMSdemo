package com.niit.cmsdemo.domain;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{

    private static final long serialVersionUID = 303796631910021406L;

    private Long id;
    private String name;
    private Character gender;
    private Integer age;
    private String phone;
    private String qqWechat;
    private String email;
    private String college;
    private String major;
    private Date walkinDate;
    private String interviewNote;
    private Integer marks;
    private String intention;
    private String studentSource;
    private String classification;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQqWechat() {
        return qqWechat;
    }

    public void setQqWechat(String qqWechat) {
        this.qqWechat = qqWechat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getWalkinDate() {
        return walkinDate;
    }

    public void setWalkinDate(Date walkinDate) {
        this.walkinDate = walkinDate;
    }

    public String getInterviewNote() {
        return interviewNote;
    }

    public void setInterviewNote(String interviewNote) {
        this.interviewNote = interviewNote;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public String getStudentSource() {
        return studentSource;
    }

    public void setStudentSource(String studentSource) {
        this.studentSource = studentSource;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", qqWechat='" + qqWechat + '\'' +
                ", email='" + email + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", walkinDate=" + walkinDate +
                ", interviewNote='" + interviewNote + '\'' +
                ", marks=" + marks +
                ", intention='" + intention + '\'' +
                ", studentSource='" + studentSource + '\'' +
                ", classification='" + classification + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
