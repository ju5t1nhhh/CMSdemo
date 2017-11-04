package com.niit.cmsdemo.domain;

import java.util.Date;

public class Student {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String phone;
    private String qq_wechat;
    private String email;
    private String college;
    private String major;
    private Date walkin_date;
    private String interview_note;
    private Integer marks;
    private String intention;
    private String student_source;
    private String follow_up;
    private String classification;
    private Date create_time;
    private Date update_time;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", qq_wechat='" + qq_wechat + '\'' +
                ", email='" + email + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", walkin_date=" + walkin_date +
                ", interview_note='" + interview_note + '\'' +
                ", marks=" + marks +
                ", intention='" + intention + '\'' +
                ", student_source='" + student_source + '\'' +
                ", follow_up='" + follow_up + '\'' +
                ", classification='" + classification + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    public String getQq_wechat() {
        return qq_wechat;
    }

    public void setQq_wechat(String qq_wechat) {
        this.qq_wechat = qq_wechat;
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

    public Date getWalkin_date() {
        return walkin_date;
    }

    public void setWalkin_date(Date walkin_date) {
        this.walkin_date = walkin_date;
    }

    public String getInterview_note() {
        return interview_note;
    }

    public void setInterview_note(String interview_note) {
        this.interview_note = interview_note;
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

    public String getStudent_source() {
        return student_source;
    }

    public void setStudent_source(String student_source) {
        this.student_source = student_source;
    }

    public String getFollow_up() {
        return follow_up;
    }

    public void setFollow_up(String follow_up) {
        this.follow_up = follow_up;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
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
