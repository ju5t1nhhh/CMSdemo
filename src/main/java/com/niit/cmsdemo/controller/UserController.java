package com.niit.cmsdemo.controller;

import com.niit.cmsdemo.domain.User;
import com.niit.cmsdemo.service.UserService;
import com.niit.cmsdemo.util.PasswordHelper;
import com.niit.cmsdemo.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/searchUser")
    public ServerResponse searchUser(){
        return ServerResponse.createSuccessResponse(userService.findAll());
    }

    @PostMapping("/getUser")
    public ServerResponse getUser(String loginId){
        return ServerResponse.createSuccessResponse(userService.findByUserId(loginId));
    }

    @PostMapping("/addUser")
    public ServerResponse addUser(User user){
        ServerResponse serverResponse=null;
        try {
            userService.addUser(user);
            serverResponse=serverResponse.createSuccessResponse(null);
        } catch (Exception e) {
            serverResponse=serverResponse.createErrorResponse(500,e.getMessage());
        }
        return serverResponse;
    }

    @PostMapping("/delUser")
    public ServerResponse delUser(String loginId){
        ServerResponse serverResponse=null;
        try{
            userService.delUser(loginId);
            serverResponse=serverResponse.createSuccessResponse(null);
        }catch (Exception e){
            serverResponse=serverResponse.createErrorResponse(500,e.getMessage());
        }
        return serverResponse;
    }

    @PostMapping("/updateUser")
    public ServerResponse updateUser(User user){
        ServerResponse serverResponse=null;
        try{
            if(user.getPassword()!=null&&user.getPassword().length()>0) {
                PasswordHelper passwordHelper = new PasswordHelper();
                passwordHelper.encryptPassword(user);
            }
            userService.updateUser(user);
            serverResponse=serverResponse.createSuccessResponse(null);
        }catch (Exception e){
            serverResponse=serverResponse.createErrorResponse(500,e.getMessage());
        }
        return serverResponse;
    }
}
