package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.domain.User;
import com.niit.cmsdemo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user) {

    }

    @Override
    public void delUser(String[] userIds) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User findByUserId(String userId) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findConditions(Map<String, Object> map) {
        return null;
    }
}
