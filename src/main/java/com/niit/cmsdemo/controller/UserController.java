package com.niit.cmsdemo.controller;

import com.niit.cmsdemo.service.UserService;
import com.niit.cmsdemo.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/searchUser")
    public ServerResponse searchUser(){
        return ServerResponse.createSuccessResponse(userService.findAll());
    }
}
