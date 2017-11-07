package com.niit.cmsdemo.controller;


import com.github.pagehelper.PageInfo;
import com.niit.cmsdemo.domain.Permission;
import com.niit.cmsdemo.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/25.
 */
@RestController
@RequestMapping("/resources")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

//    @RequestMapping
//    public Map<String,Object> getAll(Permission permission, String draw,
//                                     @RequestParam(required = false, defaultValue = "1") int start,
//                                     @RequestParam(required = false, defaultValue = "10") int length){
//        Map<String,Object> map = new HashMap<>();
//        PageInfo<Permission> pageInfo = permissionService.selectByPage(permission, start, length);
//        System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
//        map.put("draw",draw);
//        map.put("recordsTotal",pageInfo.getTotal());
//        map.put("recordsFiltered",pageInfo.getTotal());
//        map.put("data", pageInfo.getList());
//        return map;
//    }

    @RequestMapping("/permissionWithCondition")
    public List<Permission> permissionWithCondition(Map<String,Object> map){

            map.put("name",);
            map.put("url",);
            map.put("type",);
            map.put("parent_id",);
            map.put("create_time",)
            return permissionService.findConditions(map);
        }

    @RequestMapping("/permissionWithID")
    public List<Permission> PermissionWithId(){
        Map<String,Object> map = new HashMap<>();
        Integer userid = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId");
        map.put("type",1);
        map.put("userid",userid);
        List<Permission> PermissionList = permissionService.findConditions(map);
        return PermissionList;
    }


    @RequestMapping(value = "/add")
    public String addPermission(Permission permission){
        try{
            permissionService.addPermission(permission);
            //更新权限
            permissionService.updatePermission(permission);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/deletePermission")
    public String deletePermissions(Long[] id){
        try{
            permissionService.delPermissions(id);
            //更新权限
            permissionService.updatePermission();
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}
