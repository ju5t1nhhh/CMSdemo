package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);

    void delRole(Integer[] roleIds);

    void updateRole(Role role);

    List<Role> findAll();

}
