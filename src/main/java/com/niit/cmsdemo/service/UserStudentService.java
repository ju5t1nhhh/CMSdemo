package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.Student;
import com.niit.cmsdemo.domain.UserStudent;

import java.util.List;
import java.util.Map;

public interface UserStudentService {

    void addUserStudent(UserStudent userStudent);

    void delUserStudent(List<UserStudent> userStudents);

    List<Student> findConditions(Map<String,Object> map);

}
