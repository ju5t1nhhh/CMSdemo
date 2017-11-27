package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.UserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRoleDaoTest {

    @Resource
    private UserRoleDao userRoleDao;

    @Test
    public void selectAll() throws Exception {
        List<UserRole> userRoles=userRoleDao.selectAll();
        for(UserRole userRole:userRoles){
            System.out.println(userRole);
        }
    }

    @Test
    public void selectRoleIdsByUserId() throws Exception {
        Integer roleId=userRoleDao.selectRoleIdsByUserId("jackie");
        System.out.println(roleId);
    }

    @Test
    public void selectUserIdsByRoleId() throws Exception {
        String[] userIds=userRoleDao.selectUserIdsByRoleId(1);
        for(String userId:userIds){
            System.out.println(userId);
        }
    }

}