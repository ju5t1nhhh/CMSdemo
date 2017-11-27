package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Fbquestion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FbquestionDao {

    Integer insertOne(Fbquestion fbquestion);

    Integer deleteOne(Integer id);

    Integer updateOne(Fbquestion fbquestion);

    Integer resetLocation(@Param("id") Integer id, @Param("location") Integer location);

    Fbquestion selectOne(Integer id);

    Fbquestion selectByLocation(Integer location);

    List<Fbquestion> selectAll();
}
