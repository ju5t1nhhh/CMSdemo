package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentDao {

    Integer insertOne(Student student);

    Integer deleteOne(Long id);

    Integer updateOne(Student student);

    Integer resetClassification(@Param("stuId") Long stuId,@Param("classification") Character classification);

    Student selectOne(Long id);
    /**
     * 多条件查询广告
     * @param map
     * 在map中时间用变量date去存，格式是%Y-%m-%d
     * @return list
     */
    List<Student> selectConditions(Map<String,Object> map);

}
