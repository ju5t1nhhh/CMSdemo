package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.domain.Permission;
import com.niit.cmsdemo.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public void addPermission(Permission permission) {

    }

    @Override
    public void delPermissions(Long[] permIds) {

    }

    @Override
    public void updatePermission(Permission permission) {

    }

    @Override
    public List<Permission> findAll() {
        return null;
    }

    @Override
    public List<Permission> findConditions(Map<String, Object> map) {
        return null;
    }
}
