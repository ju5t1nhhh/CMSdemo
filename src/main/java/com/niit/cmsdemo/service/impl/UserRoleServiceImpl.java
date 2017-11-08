package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.UserRoleDao;
import com.niit.cmsdemo.domain.UserRole;
import com.niit.cmsdemo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public void addUserRole(String userId,Integer roleId) {
        userRoleDao.insertOne(userId,roleId);
    }

    @Override
    public void delUserRole(String userId,Integer roleId) {
        userRoleDao.deleteOne(userId,roleId);
    }

    @Override
    public List<UserRole> findAll() {
        return userRoleDao.selectAll();
    }
}
