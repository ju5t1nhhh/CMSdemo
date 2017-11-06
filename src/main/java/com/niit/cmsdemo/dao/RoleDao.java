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

    Role selectOne(Integer id);

    /**
     * 多条件查询广告
     * @param map
     * 在map中时间用变量date去存，格式是%Y-%m-%d
     * @return list
     */
    List<Role> selectConditions(Map<String,Object> map);

}
