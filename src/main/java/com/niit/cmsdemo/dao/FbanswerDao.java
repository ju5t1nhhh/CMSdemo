package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Fbanswer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FbanswerDao {

    Integer insertOne(Fbanswer fbanswer);

    Integer deleteOne(Integer id);

    Integer updateOne(Fbanswer fbanswer);

    Integer resetLocation(@Param("id") Integer id,@Param("location") Integer location);

    Fbanswer selectOne(Integer id);

    Fbanswer selectSpecial(@Param("questionId") Integer questionId,@Param("location") Integer location);

    List<Fbanswer> selectByQuestionId(Integer questionId);

}
