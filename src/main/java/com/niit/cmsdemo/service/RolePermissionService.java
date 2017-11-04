package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.Permission;

import java.util.List;

public interface RolePermissionService {

    void addRolePerm(Integer roleId,Long[] permIds);

    void delRolePermByRoleId(Integer roleId);

    List<Permission> findPermsByRoleId(Integer roleId);

}
