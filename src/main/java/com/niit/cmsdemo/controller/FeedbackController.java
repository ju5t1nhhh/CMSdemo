package com.niit.cmsdemo.controller;

import com.niit.cmsdemo.domain.Feedback;
import com.niit.cmsdemo.service.FeedbackService;
import com.niit.cmsdemo.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/updateFeedback")
    public ServerResponse updateFeedback(Feedback feedback, HttpSession session){
        String userSessionId= (String) session.getAttribute("userSessionId");
        ServerResponse serverResponse=null;
        try {
            feedbackService.updateFeedback(feedback,userSessionId);
            serverResponse=ServerResponse.createSuccessResponse(null);
        } catch (Exception e) {
            serverResponse=ServerResponse.createErrorResponse(500,e.getMessage());
        }
        return serverResponse;
    }

    @PostMapping("/getFeedback")
    public ServerResponse getFeedback(Long stuId,HttpSession session){
        String userSessionId= (String) session.getAttribute("userSessionId");
        return ServerResponse.createSuccessResponse(feedbackService.findFeedback(stuId,userSessionId));
    }
}
