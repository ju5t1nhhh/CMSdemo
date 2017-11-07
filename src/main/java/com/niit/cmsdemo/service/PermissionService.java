package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.Permission;

import java.util.List;
import java.util.Map;

public interface PermissionService {

    void addPermission(Permission permission);

    void delPermissions(Long[] permIds);

    void updatePermission(Permission permission);

    List<Permission> findConditions(Map<String,Object> map);

}
