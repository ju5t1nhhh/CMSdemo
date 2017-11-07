package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentServiceTest {

    @Resource
    private StudentService studentService;

    @Test
    public void addStudent() throws Exception {
        Student student=new Student();
        student.setName("bababa");
        studentService.addStudent(student,"jackie233");
    }

    @Test
    public void delStudents() throws Exception {
    }

    @Test
    public void updateStudent() throws Exception {
    }

    @Test
    public void findConditions() throws Exception {
    }

}