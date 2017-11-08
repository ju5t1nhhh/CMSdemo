package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.StudentDao;
import com.niit.cmsdemo.dao.UserStudentDao;
import com.niit.cmsdemo.domain.Student;
import com.niit.cmsdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private UserStudentDao userStudentDao;

    @Override
    @Transactional
    public void addStudent(Student student, String userId) {
        Integer rows=studentDao.insertOne(student);
        if(rows>0){
            userStudentDao.insertOne(userId,student.getId());
        }
    }

    @Override
    public void delStudents(Long[] stuIds, String userId) {
        for(Long stuId:stuIds){
            if(userStudentDao.selectUserIdByStuId(stuId).equals(userId)){
                studentDao.deleteOne(stuId);
            }
        }
    }

    @Override
    public void updateStudent(Student student, String userId) {
        if(userStudentDao.selectUserIdByStuId(student.getId()).equals(userId)){
            studentDao.updateOne(student);
        }
    }

    @Override
    public List<Student> findAll() {
        return studentDao.selectConditions(null);
    }

    //查找该userId的学生
    @Override
    public List<Student> findConditions(Map<String, Object> map, String userId) {
        Long[] ids=userStudentDao.selectStuIdsByUserId(userId);
        map.put("ids",ids);
        return studentDao.selectConditions(map);
    }
}
