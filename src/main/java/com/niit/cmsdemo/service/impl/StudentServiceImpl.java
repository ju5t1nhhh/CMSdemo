package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.FeedbackDao;
import com.niit.cmsdemo.dao.StudentDao;
import com.niit.cmsdemo.dao.UserStudentDao;
import com.niit.cmsdemo.domain.Feedback;
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

    @Autowired
    private FeedbackDao feedbackDao;

    @Override
    @Transactional
    public void addStudent(Student student, String userId) throws Exception {
        Integer rows=studentDao.insertOne(student);
        if(rows>0){
            userStudentDao.insertOne(userId,student.getId());

            Feedback feedback=new Feedback();
            feedback.setStuId(student.getId());
            feedbackDao.insertOne(feedback);
        }else{
            throw new Exception("添加学生失败");
        }
    }

    @Override
    public void delStudents(Long stuId, String userId) throws Exception {
        if(userStudentDao.selectUserIdByStuId(stuId).equals(userId)||userId.equals("admin")){
            Integer rows=studentDao.deleteOne(stuId);
            if(rows==0)throw new Exception("删除失败");
        }
    }

    @Override
    public void updateStudent(Student student, String userId) {
        if(userStudentDao.selectUserIdByStuId(student.getId()).equals(userId)||userId.equals("admin")){
            studentDao.updateOne(student);
        }
    }

    @Override
    public Student getStudent(Long stuId, String userId) throws Exception {
        if(userStudentDao.selectUserIdByStuId(stuId).equals(userId)||userId.equals("admin")){
            return studentDao.selectOne(stuId);
        }else{
            throw new Exception("No permission");
        }
    }

    @Override
    public Integer searchCount(Map<String, Object> map, String userId) {
        if(userId!=null&&userId.length()>0&&!userId.equals("admin")) {
            Long[] ids=userStudentDao.selectStuIdsByUserId(userId);
            map.put("ids",ids);
        }
        List<Student> students=studentDao.selectConditions(map);
        return students.size();
    }

    @Override
    public List<Student> findAll() {
        return studentDao.selectConditions(null);
    }

    //查找该userId的学生
    @Override
    public List<Student> findConditions(Map<String, Object> map, String userId) {
        if(!userId.equals("admin")){
            Long[] ids=userStudentDao.selectStuIdsByUserId(userId);
            map.put("ids",ids);
        }
        return studentDao.selectConditions(map);
    }
}
