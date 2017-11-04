package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.domain.Student;
import com.niit.cmsdemo.domain.UserStudent;
import com.niit.cmsdemo.service.UserStudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserStudentServiceImpl implements UserStudentService {
    @Override
    public void addUserStudent(UserStudent userStudent) {
        
    }

    @Override
    public void delUserStudent(List<UserStudent> userStudents) {

    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public List<Student> findConditions(Map<String, Object> map) {
        return null;
    }
}
