package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.Student;
import com.niit.cmsdemo.vo.FeedbackArray;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentService {

    void addStudent(Student student,String userId) throws Exception;

    void delStudents(Long stuId,String userId) throws Exception;

    void updateStudent(Student student,String userId);

    Student getStudent(Long stuId,String userId) throws Exception;

    Integer searchCount(Map<String,Object> map,String userId);

    List<Student> findAll();
    //service层要检查map里是否存在该用户没有的权限
    List<Student> findConditions(FeedbackArray feedbackArray, Map<String,Object> map, String userId);

}
