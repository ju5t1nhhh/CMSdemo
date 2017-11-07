package com.niit.cmsdemo.controller;

import com.niit.cmsdemo.domain.Advertise;
import com.niit.cmsdemo.service.AdvertiseService;
import org.apache.shiro.SecurityUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UrlController {
    @Resource
    private AdvertiseService advertiseService;
    String userId= (String) SecurityUtils.getSubject().getSession().getAttribute("userId");

    @RequestMapping(value = "/addAdvertise")
    public void addAdvertise(Advertise advertise){
        advertiseService.addAdvertise(advertise,userId);
    }


    @RequestMapping(value = "/delAdvertise")
    public void delAdvertise(Long[] adIds){
        advertiseService.delAdvertise(adIds,userId);
    }


    @RequestMapping(value= "/searchAllUrl")
    public List SearchAllUrl(ModelMap map){

        List advList =advertiseService.findConditions(map,userId)
        return advList;
    }
}
