package com.niit.cmsdemo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStudentDao {

    Integer insertOne(@Param("userId") String userId,@Param("stuId")Long stuId);

    Integer deleteOne(@Param("userId")String userId,@Param("stuId")Long stuId);

    /**
     * 根据 用户ID 查询 学生
     * @param userId
     * @return
     */
    Long[] selectStuIdsByUserId(String userId);

    String selectUserIdByStuId(Long stuId);

}
