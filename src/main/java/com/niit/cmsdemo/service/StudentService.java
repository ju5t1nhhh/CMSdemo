package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentService {

    void addStudent(Student student);

    void delStudents(Long[] stuIds);

    void updateStudent(Student student);

    List<Student> findAll();

    //service层要检查map里是否存在该用户没有的权限
    List<Student> findConditions(Map<String,Object> map);

}
