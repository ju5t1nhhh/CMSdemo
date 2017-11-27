package com.niit.cmsdemo.controller;

import com.niit.cmsdemo.domain.Fbquestion;
import com.niit.cmsdemo.service.FbquestionService;
import com.niit.cmsdemo.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FbquestionController {

    @Autowired
    private FbquestionService fbquestionService;

    @PostMapping("/addQuestion")
    public ServerResponse addQuestion(Fbquestion fbquestion){
        fbquestionService.addQuestion(fbquestion);
        return ServerResponse.createSuccessResponse(null);
    }

    @PostMapping("/delQuestion")
    public ServerResponse delQuestion(Integer id){
        fbquestionService.delQuestion(id);
        return ServerResponse.createSuccessResponse(null);
    }

    @PostMapping("/updateQuestion")
    public ServerResponse updateQuestion(Fbquestion fbquestion){
        fbquestionService.updateQuestion(fbquestion);
        return ServerResponse.createSuccessResponse(null);
    }

    @PostMapping("/getTable")
    public ServerResponse getTable(){
        return ServerResponse.createSuccessResponse(fbquestionService.getFbtable());
    }

}
