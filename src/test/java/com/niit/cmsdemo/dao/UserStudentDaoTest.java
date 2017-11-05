package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.UserStudent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserStudentDaoTest {

    @Autowired
    private UserStudentDao userStudentDao;

    @Test
    public void insertOne() throws Exception {
        UserStudent userStudent = new UserStudent();
        userStudent.setStuId(1L);
        userStudent.setUserId("111");
        userStudentDao.insertOne(userStudent);
    }

    @Test
    public void deleteOne() throws Exception {
    }

    @Test
    public void selectStuIdsByUserId() throws Exception {
        System.out.println(userStudentDao.selectStuIdsByUserId("111"));
    }

}