package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.UserDao;
import com.niit.cmsdemo.domain.User;
import com.niit.cmsdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void addUser(User user) throws Exception {
        Integer rows=userDao.insertOne(user);
        if(rows==0){
            throw new Exception("添加失败");
        }
    }

    @Override
    public void delUser(String userId) throws Exception {
        Integer rows=userDao.deleteOne(userId);
        if(rows==0)throw new Exception("添加失败");
    }

    @Override
    public void updateUser(User user) {
        userDao.updateOne(user);
    }

    @Override
    public User findByUserId(String userId) {
        return userDao.selectOne(userId);
    }

    @Override
    public List<User> findAll() {
        return userDao.selectConditions(null);
    }

    @Override
    public List<User> findConditions(Map<String, Object> map) {
        return userDao.selectConditions(map);
    }
}
