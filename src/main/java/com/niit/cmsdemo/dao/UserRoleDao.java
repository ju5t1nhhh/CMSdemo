package com.niit.cmsdemo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDao {

    Integer insertOne(@Param("userId") String userId, @Param("roleId") Integer roleId);

    Integer deleteOne(@Param("userId") String userId,@Param("roleId") Integer roleId);

    Integer[] selectRoleIdsByUserId(String userId);

    String[] selectUserIdsByRoleId(Integer roleId);

}
