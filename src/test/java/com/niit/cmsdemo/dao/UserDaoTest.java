package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.User;
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
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void insertOne() throws Exception {
        User user=new User();
        user.setLoginId("jiji");
        user.setUsername("lala");
        user.setPassword("coco");
        user.setStatus(1);
        userDao.insertOne(user);
    }

    @Test
    public void deleteOne() throws Exception {
        userDao.deleteOne("phil233");
    }

    @Test
    public void updateOne() throws Exception {
        User user=userDao.selectOne("john233");
        user.setUsername("hahaha");
    }

    @Test
    public void selectOne() throws Exception {
        System.out.println(userDao.selectOne("jackie233"));
    }

    @Test
    public void selectConditions() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("name","n");
        List<User> users=userDao.selectConditions(map);
        for(User user:users){
            System.out.println(user);
        }
    }

}