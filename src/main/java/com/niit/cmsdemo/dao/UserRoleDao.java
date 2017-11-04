package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDao {

    Integer insertOne(UserRole userRole);

    Integer deleteOne(String userId,Integer roleId);

    Integer[] selectRoleIdsByUserId(String userId);

    String[] selectUserIdsByRoleId(Integer roleId);

}
