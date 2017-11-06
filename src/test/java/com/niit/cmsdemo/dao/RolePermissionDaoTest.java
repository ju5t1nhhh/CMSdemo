package com.niit.cmsdemo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@SpringBootTest
@RunWith(SpringRunner.class)
public class RolePermissionDaoTest {

    @Resource
    private RolePermissionDao rolePermissionDao;

    @Test
    public void insertOne() throws Exception {
        rolePermissionDao.insertOne(3,1L);
    }

    @Test
    public void deleteOne() throws Exception {
        rolePermissionDao.deleteOne(1,1L);
    }

    @Test
    public void selectRoleIdsByPermId() throws Exception {
        Integer[] ids=rolePermissionDao.selectRoleIdsByPermId(1L);
        for(Integer id:ids){
            System.out.println(id);
        }
    }

    @Test
    public void selectPermIdsByRoleId() throws Exception {
        Long[] ids=rolePermissionDao.selectPermIdsByRoleId(1);
        for(Long id:ids){
            System.out.println(id);
        }
    }

}