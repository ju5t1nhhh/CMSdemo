package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.PermissionDao;
import com.niit.cmsdemo.dao.RoleDao;
import com.niit.cmsdemo.dao.RolePermissionDao;
import com.niit.cmsdemo.dao.UserDao;
import com.niit.cmsdemo.domain.Permission;
import com.niit.cmsdemo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RolePermissionDao rolePermissionDao;

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

    @Override
    public List<Permission> findByUserId(String userId) {
        List<Permission> permissions=new ArrayList<>();
        String role=userDao.selectOne(userId).getRole();
        Map<String,Object> map=new HashMap<>();
        map.put("name",role);
        Integer roleId=roleDao.selectConditions(map).get(0).getId();
        Long[] permIds=rolePermissionDao.selectPermIdsByRoleId(roleId);
        for(Long permId:permIds){
            permissions.add(permissionDao.selectOne(permId));
        }
        return permissions;
    }

}
