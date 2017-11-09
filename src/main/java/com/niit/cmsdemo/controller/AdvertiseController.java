package com.niit.cmsdemo.controller;

import com.niit.cmsdemo.domain.Advertise;
import com.niit.cmsdemo.service.AdvertiseService;
import com.niit.cmsdemo.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AdvertiseController {

    @Autowired
    private AdvertiseService advertiseService;

    @PostMapping("/addAds")
    public ServerResponse addAds(Advertise advertise, HttpSession session){
        String userSessionId= (String) session.getAttribute("userSessionId");
        ServerResponse serverResponse=null;
        try{
            advertiseService.addAdvertise(advertise,userSessionId);
            serverResponse.createSuccessResponse(null);
        }catch (Exception e){
            serverResponse.createErrorResponse(500,"添加失败");
        }
        return serverResponse;
    }

    @PostMapping("/delAds")
    public ServerResponse delAds(Long adId,HttpSession session){
        String userSessionId= (String) session.getAttribute("userSessionId");
        ServerResponse serverResponse=null;
        try {
            advertiseService.delAdvertise(adId,userSessionId);
            serverResponse.createSuccessResponse(null);
        } catch (Exception e) {
            serverResponse.createErrorResponse(500,e.getMessage());
        }
        return serverResponse;
    }

    @PostMapping("/searchAds")
    public ServerResponse searchAds(HttpSession session){
        Map<String,Object> map=new HashMap<>();
        String userSessionId= (String) session.getAttribute("userSessionId");
        return ServerResponse.createSuccessResponse(advertiseService.findConditions(map,userSessionId));
    }
}
