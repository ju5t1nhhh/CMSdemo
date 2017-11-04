package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User selectByUsername(String username);
}
