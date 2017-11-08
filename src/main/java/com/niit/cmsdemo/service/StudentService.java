package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentService {

    void addStudent(Student student,String userId);

    void delStudents(Long[] stuIds,String userId);

    void updateStudent(Student student,String userId);

    List<Student> findAll();
    //service层要检查map里是否存在该用户没有的权限
    List<Student> findConditions(Map<String,Object> map,String userId);

}
