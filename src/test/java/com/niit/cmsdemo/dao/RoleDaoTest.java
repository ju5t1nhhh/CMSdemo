package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Advertise;
import com.niit.cmsdemo.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleDaoTest {

    @Autowired
    private RoleDao roleDao;

    @Test
    public void insertOne() throws Exception {
        Role role = new Role();
        role.setId(12L);
        role.setName("111");
        roleDao.insertOne(role);
    }

    @Test
    public void deleteOne() throws Exception {
    }

    @Test
    public void updateOne() throws Exception {
        Role role = new Role();
        role.setId(12L);
        role.setName("4124");
        roleDao.updateOne(role);
    }

    @Test
    public void selectAll() throws Exception {
        List<Role> list = roleDao.selectAll();
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }

    @Test
    public void selectConditions() throws Exception {
        Map map = new HashMap<>();
        map.put("date","2017-11-03");
        List<Role> list = roleDao.selectConditions(map);
        for (int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }

}