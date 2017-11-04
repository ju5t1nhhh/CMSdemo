package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.RolePermission;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionDao {

    Integer insertOne(RolePermission rolePermission);

    Integer deleteOne(Integer roleId,Long permId);

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
