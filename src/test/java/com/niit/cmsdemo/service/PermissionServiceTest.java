package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PermissionServiceTest {

    @Resource
    private PermissionService permissionService;

    @Test
    public void addPermission() throws Exception {
    }

    @Test
    public void delPermissions() throws Exception {
    }

    @Test
    public void updatePermission() throws Exception {
    }

    @Test
    public void findConditions() throws Exception {
    }

    @Test
    public void findByUserId() throws Exception {
        List<Permission> permissions=permissionService.findByUserId("admin");
        for(Permission permission:permissions){
            System.out.println(permission);
        }
    }

}