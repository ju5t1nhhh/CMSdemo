package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentDao {

    Integer insertOne(Student student);

    Integer deleteOne(Long id);

    Integer updateOne(Student student);

    List<Student> selectAll();

    List<Student> selectConditions(Map<String,Object> map);

}
