package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    void addUser(User user);

    void delUser(String[] userIds);

    void updateUser(User user);

    User findByUserId(String userId);

    List<User> findAll();

    List<User> findConditions(Map<String,Object> map);
}
