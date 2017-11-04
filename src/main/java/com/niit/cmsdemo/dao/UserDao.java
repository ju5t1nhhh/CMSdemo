package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {

    Integer insertOne(User user);

    Integer deleteOne(String userId);

    Integer updateOne(User user);

    List<User> selectAll();

    List<User> selectConditions(Map<String,Object> map);

}
