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
    public void selectRoleIdsByPermId() throws Exception {
        Integer[] roleIds=rolePermissionDao.selectRoleIdsByPermId(1L);
        for(Integer roleId:roleIds){
            System.out.println(roleId);
        }
    }

    @Test
    public void selectPermIdsByRoleId() throws Exception {
        Long[] permIds=rolePermissionDao.selectPermIdsByRoleId(1);
        for(Long permId:permIds){
            System.out.println(permId);
        }
    }

}