package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Permission;
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
public class PermissionDaoTest {

    @Autowired
    private PermissionDao permissionDao;

    @Test
    public void insertOne() throws Exception {
        Permission permission = new Permission();
        permission.setId(22L);
        permission.setName("111");
        permission.setType(1);
        permission.setParentId(1L);
        permission.setUrl("afdasf");
        permissionDao.insertOne(permission);
    }

    @Test
    public void deleteOne() throws Exception {
        permissionDao.deleteOne(22L);
    }

    @Test
    public void updateOne() throws Exception {
        Permission permission = new Permission();
        permission.setId(22L);
        permission.setName("11231");
        permission.setType(3);
        permission.setParentId(2L);
        permission.setUrl("11111111");
        permissionDao.updateOne(permission);
    }

    @Test
    public void selectAll() throws Exception {
    }

    @Test
    public void selectConditions() throws Exception {
        Map map = new HashMap<>();
        map.put("date","2017-11-03");
        List<Permission> list = permissionDao.selectConditions(map);
        for (int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }

}