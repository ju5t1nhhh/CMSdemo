package com.niit.cmsdemo.controller;

import com.niit.cmsdemo.service.StuSourceService;
import com.niit.cmsdemo.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuSourceController {

    @Autowired
    private StuSourceService stuSourceService;

    @PostMapping("/addStuSource")
    public ServerResponse addStuSource(String pre,String back){
        ServerResponse serverResponse=null;
        try{
            stuSourceService.addStuSource(pre,back);
            serverResponse=ServerResponse.createSuccessResponse(null);
        }catch(Exception e){
            serverResponse=ServerResponse.createErrorResponse(500,e.getMessage());
        }
        return serverResponse;
    }

    @PostMapping("/getStuSource")
    public ServerResponse getStuSource(){
        return ServerResponse.createSuccessResponse(stuSourceService.getStuSource());
    }
}
