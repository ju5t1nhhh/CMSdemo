package com.niit.cmsdemo.controller;

import com.niit.cmsdemo.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdvertiseController {

    @Autowired
    private AdvertiseService advertiseService;


}
