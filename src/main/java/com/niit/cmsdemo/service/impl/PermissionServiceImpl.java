package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.PermissionDao;
import com.niit.cmsdemo.domain.Permission;
import com.niit.cmsdemo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public void addPermission(Permission permission) {
        permissionDao.insertOne(permission);
    }

    @Override
    public void delPermissions(Long[] permIds) {
        for(Long id:permIds){
            permissionDao.deleteOne(id);
        }
    }

    @Override
    public void updatePermission(Permission permission) {
        permissionDao.updateOne(permission);
    }

    @Override
    public List<Permission> findConditions(Map<String, Object> map) {
        return permissionDao.selectConditions(map);
    }
}
