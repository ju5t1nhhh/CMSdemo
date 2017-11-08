package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void addUser() throws Exception {
    }

    @Test
    public void delUser() throws Exception {
    }

    @Test
    public void updateUser() throws Exception {
    }

    @Test
    public void findByUserId() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
        List<User> users=userService.findAll();
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void findConditions() throws Exception {
    }

}