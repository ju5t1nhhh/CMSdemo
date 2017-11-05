package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.RolePermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RolePermissionDaoTest {

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Test
    public void insertOne() throws Exception {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setPermId(11L);
        rolePermission.setRoleId(21L);
        rolePermissionDao.insertOne(rolePermission);
    }

    @Test
    public void deleteOne() throws Exception {
        rolePermissionDao.deleteOne(21,11L);
    }

    @Test
    public void selectRoleIdsByPermId() throws Exception {
        Integer[] integers = rolePermissionDao.selectRoleIdsByPermId(1L);
        for (Integer i:integers){
            System.out.println(i);
        }
    }

    @Test
    public void selectPermIdsByRoleId() throws Exception {
        Long[] integers = rolePermissionDao.selectPermIdsByRoleId(1);
        for (Long i:integers){
            System.out.println(i);
        }
    }

}