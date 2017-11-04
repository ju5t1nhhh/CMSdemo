package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleDao {

    Integer insertOne(Role role);

    Integer deleteOne(Integer id);

    Integer updateOne(Role role);

    /**
     * 查询所有角色
     * @return
     */
    List<Role> selectAll();

    /**
     * 多条件查询角色
     * @param map
     * @return
     */
    List<Role> selectConditions(Map<String,Object> map);

}
