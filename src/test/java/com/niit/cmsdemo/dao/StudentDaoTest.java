package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentDaoTest {

    @Resource
    private StudentDao studentDao;

    @Test
    public void insertOne() throws Exception {
        Student student=new Student();
        student.setName("Kris TTT");
        studentDao.insertOne(student);
        System.out.println(student.getId());
    }

    @Test
    public void deleteOne() throws Exception {
        studentDao.deleteOne(3L);
    }

    @Test
    public void updateOne() throws Exception {
        Student student=studentDao.selectOne(2L);
        student.setName("LeBron James");
        studentDao.updateOne(student);
    }

    @Test
    public void selectOne() throws Exception {
        System.out.println(studentDao.selectOne(1L));
    }

    @Test
    public void selectConditions() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("name","is");
        List<Student> students=studentDao.selectConditions(map);
        for(Student student:students){
            System.out.println(student);
        }
    }

}