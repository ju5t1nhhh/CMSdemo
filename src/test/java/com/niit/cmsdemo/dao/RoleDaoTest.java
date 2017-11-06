package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Role;
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
public class RoleDaoTest {

    @Resource
    private RoleDao roleDao;

    @Test
    public void insertOne() throws Exception {
        Role role=new Role();
        role.setName("superman");
        roleDao.insertOne(role);
    }

    @Test
    public void deleteOne() throws Exception {
        roleDao.deleteOne(2);
    }

    @Test
    public void updateOne() throws Exception {
        Role role=roleDao.selectOne(1);
        role.setName("mnmn");
        roleDao.updateOne(role);
    }

    @Test
    public void selectOne() throws Exception {
        System.out.println(roleDao.selectOne(1));
    }

    @Test
    public void selectConditions() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("name","a");
        List<Role> roles=roleDao.selectConditions(map);
        for(Role role:roles){
            System.out.println(role);
        }
    }

}