package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.Student;

import java.util.List;
import java.util.Map;

public interface UserStudentService {

    void addUserStudent(String userId,Long stuId);

    void delUserStudent(String userId,Long stuId);

    List<Student> findStudents(Map<String,Object> map,String userId);

    String findUserIdByStuId(Long stuId);

}
