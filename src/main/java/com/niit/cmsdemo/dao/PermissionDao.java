package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PermissionDao {

    Integer insertOne(Permission permission);

    Integer deleteOne(Long id);

    Integer updateOne(Permission permission);

    /**
     *查询所有权限
     * @return
     */
    List<Permission> selectAll();

    /**
     * 多条件查询权限
     * @param map
     * @return
     */
    List<Permission> selectConditions(Map<String,Object> map);
}
