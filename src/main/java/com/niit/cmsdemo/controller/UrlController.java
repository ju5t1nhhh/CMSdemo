package com.niit.cmsdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UrlController {

//    添加学生基本信息
    @RequestMapping(value = "/addNewStudent",method = RequestMethod.POST)
    public String addNewStudent(){

    }
//    获得管理者的学生列表
    @RequestMapping(value = "/getManagerStudentList",method = RequestMethod.POST)
    public String getManagerStudentList(){

    }
//      获得学生基本信息
    @RequestMapping(value = "/getStudentInfo",method = RequestMethod.POST)
    public String StudentMessage(){

    }
//     添加学生信息
    @RequestMapping(value = "/editStudentInfo",method = RequestMethod.POST)
    public String editStudentMessage(){

    }
//     添加Url
    @RequestMapping(value = "/addUrl",method = RequestMethod.POST)
    public String addUrl(){

    }
//      删除Url
    @RequestMapping(value = "/deleteUrl",method = RequestMethod.POST)
    public String deleteUrl(){

    }


}
