package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {

    Integer insertOne(User user);

    Integer deleteOne(String loginId);

    Integer updateOne(User user);

    User selectOne(String loginId);

    /**
     * 多条件查询广告
     * @param map
     * 在map中时间用变量date去存，格式是%Y-%m-%d
     * @return list
     */
    List<User> selectConditions(Map<String,Object> map);

}
