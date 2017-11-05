package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Permission;
import com.niit.cmsdemo.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void insertOne() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("apple");
        student.setGender('m');
        studentDao.insertOne(student);
    }

    @Test
    public void deleteOne() throws Exception {
    }

    @Test
    public void updateOne() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("apple1111111111");
        student.setGender('m');
        student.setCollege("qingdao University");
        studentDao.updateOne(student);
    }

    @Test
    public void selectAll() throws Exception {
        List<Student> list = studentDao.selectAll();
        for (Student student : list){
            System.out.println(student);
        }
    }

    @Test
    public void selectConditions() throws Exception {
        Map map = new HashMap<>();
        map.put("date","2017-11-05");
        map.put("id",1);
        map.put("name","apple1111111111");
        List<Student> list = studentDao.selectConditions(map);
        for (int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }

}