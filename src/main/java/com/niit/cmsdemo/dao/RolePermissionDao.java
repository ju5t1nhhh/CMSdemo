package com.niit.cmsdemo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionDao {

    Integer insertOne(@Param("roleId")Integer roleId,@Param("permId")Long permId);

    Integer deleteOne(@Param("roleId") Integer roleId,@Param("permId") Long permId);

    /**
     * 根据 权限id 查询 角色ids
     * @param permId
     * @return
     */
    Integer[] selectRoleIdsByPermId(Long permId);

    /**
     * 根据 角色id 查询 权限ids
     * @param roleId
     * @return
     */
    Long[] selectPermIdsByRoleId(Integer roleId);

}
