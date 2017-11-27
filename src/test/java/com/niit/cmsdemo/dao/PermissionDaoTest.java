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
    public void selectOne() throws Exception {
        System.out.println(permissionDao.selectOne(1L));
    }

    @Test
    public void selectConditions() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("parentId",1);
        List<Permission> permissions=permissionDao.selectConditions(map);
        for(Permission permission:permissions){
            System.out.println(permission);
        }
    }

}