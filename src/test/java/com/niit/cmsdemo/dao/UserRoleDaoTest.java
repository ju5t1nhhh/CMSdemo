package com.niit.cmsdemo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRoleDaoTest {

    @Resource
    private UserRoleDao userRoleDao;

    @Test
    public void insertOne() throws Exception {
        userRoleDao.insertOne("jackie77233",1);
    }

    @Test
    public void deleteOne() throws Exception {
        userRoleDao.deleteOne("john233",1);
    }

    @Test
    public void selectRoleIdsByUserId() throws Exception {
        Integer[] ids=userRoleDao.selectRoleIdsByUserId("jackie233");
        for(Integer id:ids){
            System.out.println(id);
        }
    }

    @Test
    public void selectUserIdsByRoleId() throws Exception {
        String[] ids=userRoleDao.selectUserIdsByRoleId(1);
        for(String id:ids){
            System.out.println(id);
        }
    }

}