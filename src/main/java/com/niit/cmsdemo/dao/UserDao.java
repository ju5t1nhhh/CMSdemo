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

    User selectById(String userId);

    List<User> selectAll();

//  在map中时间用变量date去存，格式是%Y-%m-%d
    List<User> selectConditions(Map<String,Object> map);

}
