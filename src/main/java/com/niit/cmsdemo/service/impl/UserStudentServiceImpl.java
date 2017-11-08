package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.StudentDao;
import com.niit.cmsdemo.dao.UserStudentDao;
import com.niit.cmsdemo.domain.Student;
import com.niit.cmsdemo.domain.UserStudent;
import com.niit.cmsdemo.service.UserStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserStudentServiceImpl implements UserStudentService {

    @Autowired
    private UserStudentDao userStudentDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public void addUserStudent(String userId,Long stuId) {
        userStudentDao.insertOne(userId,stuId);
    }

    @Override
    public void delUserStudent(String userId,Long stuId) {
        userStudentDao.deleteOne(userId,stuId);
    }

    @Override
    public List<Student> findStudents(Map<String, Object> map, String userId) {
        List<Student> students=new ArrayList<>();
        Long[] stuIds=userStudentDao.selectStuIdsByUserId(userId);
        for(Long stuId:stuIds){
            students.add(studentDao.selectOne(stuId));
        }
        return students;
    }

    @Override
    public String findUserIdByStuId(Long stuId) {
        return userStudentDao.selectUserIdByStuId(stuId);
    }


}
