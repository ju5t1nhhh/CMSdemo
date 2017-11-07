package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.PermissionDao;
import com.niit.cmsdemo.dao.RolePermissionDao;
import com.niit.cmsdemo.domain.Permission;
import com.niit.cmsdemo.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public void addRolePerm(Integer roleId, Long[] permIds) {
        for(Long permId:permIds){
            rolePermissionDao.insertOne(roleId,permId);
        }
    }

    @Override
    public void delRolePermByRoleId(Integer roleId) {
        Long[] permIds=rolePermissionDao.selectPermIdsByRoleId(roleId);
        for(Long permId:permIds){
            rolePermissionDao.deleteOne(roleId,permId);
        }
    }

    @Override
    public List<Permission> findPermsByRoleId(Integer roleId) {
        List<Permission> permissions=new ArrayList<>();
        Long[] permIds=rolePermissionDao.selectPermIdsByRoleId(roleId);
        for(Long permId:permIds){
            permissions.add(permissionDao.selectOne(permId));
        }
        return permissions;
    }
}
