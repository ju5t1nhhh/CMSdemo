package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Feedback;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FeedbackDao {

    Integer insertOne(Feedback feedback);

    Integer deleteOne(Long stuId);

    Integer updateOne(Feedback feedback);

    Integer exchange(@Param("field1") String field1,@Param("field2") String field2);

    Feedback selectOne(Long stuId);

    List<Feedback> selectConditions(Map<String,Object> map);

}
