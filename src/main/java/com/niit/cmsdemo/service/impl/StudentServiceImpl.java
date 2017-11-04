package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.domain.Student;
import com.niit.cmsdemo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public void addStudent(Student student) {

    }

    @Override
    public void delStudents(Long[] stuIds) {

    }

    @Override
    public void updateStudent(Student student) {

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
