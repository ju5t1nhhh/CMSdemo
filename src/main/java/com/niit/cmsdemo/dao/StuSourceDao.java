package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.StuSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StuSourceDao {

    Integer insertOne(StuSource stuSource);

    Integer deleteOne(Integer id);

    Integer updateOne(StuSource stuSource);

    StuSource selectOne(Integer id);

    StuSource selectUnique(@Param("parentId") Integer parentId,@Param("name") String name);

    List<StuSource> selectParent(Integer parentId);

    List<StuSource> selectConditions(Map<String,Object> map);

}
