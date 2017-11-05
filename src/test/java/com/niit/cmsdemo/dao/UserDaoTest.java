package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void  insert() throws Exception{
        User user = new User();
        user.setUsername("admin");
        user.setLoginId("admin");
        user.setPassword("admin");
        userDao.insertOne(user);
    }

    @Test
    public void  update() throws Exception{
        User user = new User();
        user.setUsername("admins");
        user.setLoginId("admins");
        user.setPassword("admins");
        userDao.updateOne(user);
    }

    @Test
    public void  select() throws Exception{
        System.out.println(userDao.selectAll());
        System.out.println(userDao.selectById("admin"));
        System.out.println(userDao.deleteOne("admin"));
    }

    @Test
    public void moreconditon() throws Exception{
        Map map = new HashMap<>();
        map.put("date","2017-11-04");
        List<User> list = userDao.selectConditions(map);
        for (int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}