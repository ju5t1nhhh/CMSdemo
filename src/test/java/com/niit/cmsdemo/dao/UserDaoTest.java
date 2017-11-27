package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void insertOne() throws Exception {
        User user=new User();
        user.setLoginId("Kobe");
        user.setPassword("123");
        System.out.println(userDao.insertOne(user));
    }

    @Test
    public void deleteOne() throws Exception {
        System.out.println(userDao.deleteOne("Kobe"));
    }

    @Test
    public void updateOne() throws Exception {
        User user=userDao.selectOne("phil");
        user.setPassword("1234");
        System.out.println(userDao.updateOne(user));
    }

    @Test
    public void selectOne() throws Exception {
        System.out.println(userDao.selectOne("jackie"));
    }

    @Test
    public void selectConditions() throws Exception {
        System.out.println(userDao.selectConditions(null));
    }

}