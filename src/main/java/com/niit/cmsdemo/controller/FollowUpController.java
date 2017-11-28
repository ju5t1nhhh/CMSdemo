package com.niit.cmsdemo.controller;

import com.niit.cmsdemo.domain.FollowUp;
import com.niit.cmsdemo.service.FollowUpService;
import com.niit.cmsdemo.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FollowUpController {

    @Autowired
    private FollowUpService followUpService;

    @PostMapping("/addFollowUp")
    public ServerResponse addFollowUp(Long stuId, String note, Character classification,HttpSession session){
        ServerResponse serverResponse=null;
        String userSessionId= (String) session.getAttribute("userSessionId");
        FollowUp followUp=new FollowUp();
        followUp.setStuId(stuId);
        followUp.setNote(note);
        followUp.setClassification(classification);
        try {
            followUpService.addFollowUp(followUp,userSessionId);
            serverResponse=ServerResponse.createSuccessResponse(null);
        } catch (Exception e) {
            serverResponse=ServerResponse.createErrorResponse(500,e.getMessage());
        }
        return serverResponse;
    }

    @PostMapping("/delFollowUp")
    public ServerResponse delFollowUp(Long fuId,HttpSession session){
        ServerResponse serverResponse=null;
        String userSessionId= (String) session.getAttribute("userSessionId");
        try {
            followUpService.delFollowUp(fuId,userSessionId);
            serverResponse=ServerResponse.createSuccessResponse(null);
        } catch (Exception e) {
            serverResponse=ServerResponse.createErrorResponse(500,e.getMessage());
        }
        return serverResponse;
    }

    @PostMapping("/updateFollowUp")
    public ServerResponse updateFollowUp(FollowUp followUp,HttpSession session){
        ServerResponse serverResponse=null;
        String userSessionId= (String) session.getAttribute("userSessionId");
        try {
            followUpService.updateFollowUp(followUp,userSessionId);
            serverResponse=ServerResponse.createSuccessResponse(null);
        } catch (Exception e) {
            serverResponse=ServerResponse.createErrorResponse(500,e.getMessage());
        }
        return serverResponse;
    }

    @PostMapping("/searchFollowUp")
    public ServerResponse searchFollowUp(Long stuId){
        ServerResponse serverResponse=null;
        Map<String,Object> map=new HashMap<>();
        if(stuId!=null){
            map.put("stuId",stuId);
        }
        try {
            serverResponse=ServerResponse.createSuccessResponse(followUpService.findConditions(map));
        } catch (Exception e) {
            serverResponse=ServerResponse.createErrorResponse(500,e.getMessage());
        }
        return serverResponse;
    }
}
