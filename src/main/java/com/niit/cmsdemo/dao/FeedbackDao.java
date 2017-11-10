package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FeedbackDao {

    Integer insertOne(Feedback feedback);

    Integer deleteOne(Long stuId);

    Integer updateOne(Feedback feedback);

    Feedback selectOne(Long stuId);

    List<Feedback> selectConditions(Map<String,Object> map);
    
}
