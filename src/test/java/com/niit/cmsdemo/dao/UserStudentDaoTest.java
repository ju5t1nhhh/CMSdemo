package com.niit.cmsdemo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserStudentDaoTest {

    @Resource
    private UserStudentDao userStudentDao;

    @Test
    public void insertOne() throws Exception {
        userStudentDao.insertOne("jackie233",4L);
    }

    @Test
    public void deleteOne() throws Exception {
        userStudentDao.deleteOne("phil233",3L);
    }

    @Test
    public void selectStuIdsByUserId() throws Exception {
        Long[] ids=userStudentDao.selectStuIdsByUserId("jackie233");
        for(Long id:ids){
            System.out.println(id);
        }
    }

    @Test
    public void selectUserIdByStuId() throws Exception {
        System.out.println(userStudentDao.selectUserIdByStuId(2L));
    }

}