package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Permission;
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
public class PermissionDaoTest {

    @Resource
    private PermissionDao permissionDao;

    @Test
    public void insertOne() throws Exception {
        Permission permission=new Permission();
        permission.setName("sdsd");
        permission.setUrl("/asdasd");
        permissionDao.insertOne(permission);
    }

    @Test
    public void deleteOne() throws Exception {
        permissionDao.deleteOne(19L);
    }

    @Test
    public void updateOne()
            throws Exception {
        Permission permission=permissionDao.selectOne(18L);
        permission.setUrl("/6666");
        permissionDao.updateOne(permission);
    }

    @Test
    public void selectOne() throws Exception {
        System.out.println(permissionDao.selectOne(14L));
    }

    @Test
    public void selectConditions() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("url","add");
        List<Permission> permissions=permissionDao.selectConditions(map);
        for(Permission permission:permissions){
            System.out.println(permission);
        }
    }

}