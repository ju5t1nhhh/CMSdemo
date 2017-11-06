package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.StuSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StuSourceDao {

    Integer insertOne(StuSource stuSource);

    Integer deleteOne(Integer id);

    Integer updateOne(StuSource stuSource);

    StuSource selectOne(Integer id);

    List<StuSource> selectConditions(Map<String,Object> map);

}
