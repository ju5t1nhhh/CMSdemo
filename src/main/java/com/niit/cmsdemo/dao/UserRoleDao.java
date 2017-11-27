package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDao {

    Integer insertOne(@Param("userId") String userId, @Param("roleId") Integer roleId);

    Integer deleteOne(@Param("userId") String userId,@Param("roleId") Integer roleId);

    Integer updateOne(@Param("userId") String userId,@Param("roleId") Integer roleId);

    List<UserRole> selectAll();

    Integer selectRoleIdsByUserId(String userId);

    String[] selectUserIdsByRoleId(Integer roleId);

}
