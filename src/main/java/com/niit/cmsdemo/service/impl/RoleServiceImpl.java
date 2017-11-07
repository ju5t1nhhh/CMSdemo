package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.RoleDao;
import com.niit.cmsdemo.domain.Role;
import com.niit.cmsdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public void addRole(Role role) {
        roleDao.insertOne(role);
    }

    @Override
    public void delRole(Integer[] roleIds) {
        for(Integer roleId:roleIds){
            roleDao.deleteOne(roleId);
        }
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateOne(role);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.selectConditions(null);
    }
}
