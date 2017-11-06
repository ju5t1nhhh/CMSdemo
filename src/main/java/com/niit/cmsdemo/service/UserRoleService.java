package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.UserRole;

import java.util.List;

public interface UserRoleService {

    void addUserRole(UserRole userRole);

    void delUserRole(Long[] ids);

    List<UserRole> findAll();

}
