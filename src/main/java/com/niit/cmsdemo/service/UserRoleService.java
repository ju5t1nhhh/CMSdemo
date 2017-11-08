package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.UserRole;

import java.util.List;

public interface UserRoleService {

    void addUserRole(String userId,Integer roleId);

    void delUserRole(String userId,Integer roleId);

    List<UserRole> findAll();

}
