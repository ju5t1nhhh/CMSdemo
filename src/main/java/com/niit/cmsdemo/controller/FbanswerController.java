package com.niit.cmsdemo.controller;

import com.niit.cmsdemo.domain.Fbanswer;
import com.niit.cmsdemo.service.FbanswerService;
import com.niit.cmsdemo.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FbanswerController {

    @Autowired
    private FbanswerService fbanswerService;

    @PostMapping("/addAnswer")
    public ServerResponse addAnswer(Fbanswer fbanswer){
        try {
            fbanswerService.addFbanswer(fbanswer);
        } catch (Exception e) {
            return ServerResponse.createErrorResponse(500,e.getMessage());
        }
        return ServerResponse.createSuccessResponse(null);
    }

    @PostMapping("/delAnswer")
    public ServerResponse delAnswer(Integer id){
        fbanswerService.delFbanswer(id);
        return ServerResponse.createSuccessResponse(null);
    }

    @PostMapping("/updateAnswer")
    public ServerResponse updateAnswer(Fbanswer fbanswer){
        fbanswerService.updateFbanswer(fbanswer);
        return ServerResponse.createSuccessResponse(null);
    }
}
