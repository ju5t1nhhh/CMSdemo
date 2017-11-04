package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.UserStudent;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStudentDao {

    Integer insertOne(UserStudent userStudent);

    Integer deleteOne(String userId,Long stuId);

    /**
     * 根据 用户ID 查询 学生
     * @param userId
     * @return
     */
    Long[] selectStuIdsByUserId(String userId);

}
