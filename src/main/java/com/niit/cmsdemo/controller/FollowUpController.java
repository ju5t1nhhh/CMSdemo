package com.niit.cmsdemo.controller;

import com.niit.cmsdemo.service.FollowUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowUpController {

    @Autowired
    private FollowUpService followUpService;

    
}
