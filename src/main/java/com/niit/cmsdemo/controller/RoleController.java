package com.niit.cmsdemo.controller;



import com.niit.cmsdemo.domain.Role;
import com.niit.cmsdemo.domain.RolePermission;
import com.niit.cmsdemo.service.RolePermissionService;
import com.niit.cmsdemo.service.RoleService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/26.
 */
@RestController
@RequestMapping("/roles")
public class RoleController {
    @Resource
    private RoleService roleService;
    @Resource
    private RolePermissionService rolePermissionService;

//    @RequestMapping
//    public  Map<String,Object> getAll(Role role, String draw,
//                                      @RequestParam(required = false, defaultValue = "1") int start,
//                                      @RequestParam(required = false, defaultValue = "10") int length){
//
//        Map<String,Object> map = new HashMap<>();
//        PageInfo<Role> pageInfo = roleService.selectByPage(role, start, length);
//        map.put("draw",draw);
//        map.put("recordsTotal",pageInfo.getTotal());
//        map.put("recordsFiltered",pageInfo.getTotal());
//        map.put("data", pageInfo.getList());
//        return map;
//    }

    @RequestMapping("/rolesWithSelected")
    public List<Role> rolesWithSelected(Integer uid){

        return roleService.findAll(uid);
    }

    //分配角色
    @RequestMapping("/saveRoleResources")
    public String saveRoleResources(RolePermission rolePermission){
        if(StringUtils.isEmpty(rolePermission.getRoleId()))
            return "error";
        try {
            rolePermissionService.addRolePerm(rolePermission);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/add")
    public String add(Role role) {
        try {
            roleService.updateRole(role);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer[] id){
        try{
            roleService.delRole(id);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}
