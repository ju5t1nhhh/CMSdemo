package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.domain.Permission;
import com.niit.cmsdemo.service.RolePermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Override
    public void addRolePerm(Integer roleId, Long[] permIds) {

    }

    @Override
    public void delRolePermByRoleId(Integer roleId) {

    }

    @Override
    public List<Permission> findPermsByRoleId(Integer roleId) {
        return null;
    }
}
