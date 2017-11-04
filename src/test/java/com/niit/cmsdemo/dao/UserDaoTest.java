package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void  insert() throws Exception{
        User user = new User();
        user.setLoginId("aaaa");
        user.setPassword("11111");
        user.setUsername("aaaa");
    }

}