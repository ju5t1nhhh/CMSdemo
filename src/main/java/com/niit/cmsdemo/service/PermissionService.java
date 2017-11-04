package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.Permission;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PermissionService {

    public List<Permission> loadUserResources(Map<String,Object> map);

    List<Permission> queryAll();
}
