package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.UserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRoleDaoTest {

    @Autowired
    private UserRoleDao userRoleDao;

    @Test
    public void insertOne() throws Exception {
        UserRole userRole = new UserRole();
        userRole.setRoleId(1L);
        userRole.setUserId("111");
        userRoleDao.insertOne(userRole);
    }

    @Test
    public void deleteOne() throws Exception {
    }

    @Test
    public void selectRoleIdsByUserId() throws Exception {
        System.out.println(userRoleDao.selectRoleIdsByUserId("1"));
    }

    @Test
    public void selectUserIdsByRoleId() throws Exception {
        System.out.println(userRoleDao.selectUserIdsByRoleId(1));
    }

}