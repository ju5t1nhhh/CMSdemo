package com.niit.cmsdemo.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.niit.cmsdemo.dao.FeedbackDao;
import com.niit.cmsdemo.dao.StudentDao;
import com.niit.cmsdemo.dao.UserDao;
import com.niit.cmsdemo.domain.Feedback;
import com.niit.cmsdemo.domain.Student;
import com.niit.cmsdemo.service.StudentService;
import com.niit.cmsdemo.vo.FeedbackArray;
import com.niit.cmsdemo.vo.FeedbackUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private FeedbackDao feedbackDao;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void addStudent(Student student, String userId) throws Exception {
        student.setWriterId(userId);
        Integer rows=studentDao.insertOne(student);
        if(rows>0){
            Feedback feedback=new Feedback();
            feedback.setStuId(student.getId());
            nullToString(feedback);
            feedbackDao.insertOne(feedback);
        }else{
            throw new Exception("添加学生失败");
        }
    }

    @Override
    public void delStudents(Long stuId, String userId) throws Exception {
        if(studentDao.selectOne(stuId).getWriterId().equals(userId)
                ||userDao.selectOne(userId).getRole().equals("admin")){
            Integer rows=studentDao.deleteOne(stuId);
            if(rows==0)throw new Exception("删除失败");
        }
    }

    @Override
    public void updateStudent(Student student, String userId) {
        if(studentDao.selectOne(student.getId()).getWriterId().equals(userId)
                ||userDao.selectOne(userId).getRole().equals("admin")){
            studentDao.updateOne(student);
        }
    }

    @Override
    public Student getStudent(Long stuId, String userId) throws Exception {
        if(studentDao.selectOne(stuId).getWriterId().equals(userId)
                ||userDao.selectOne(userId).getRole().equals("admin")){
            return studentDao.selectOne(stuId);
        }else{
            throw new Exception("No permission");
        }
    }

    @Override
    public Integer searchCount(Map<String, Object> map, String userId) {
        if(userId!=null&&userId.length()>0
                &&!userDao.selectOne(userId).getRole().equals("admin")){
            map.put("writerId",userId);
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
    public List<Student> findConditions(FeedbackArray feedbackArray, Map<String, Object> map, String userId) {
        if(!userDao.selectOne(userId).getRole().equals("admin")){
            map.put("writerId",userId);
        }
        List<Student> students=studentDao.selectConditions(map);
        List<Feedback> feedbacks=new ArrayList<>();
        for(Student student:students){
            feedbacks.add(feedbackDao.selectOne(student.getId()));
        }
        List<Long> ids=new ArrayList<>();
        for(Feedback feedback:feedbacks){
            FeedbackArray iFeedbackArray=FeedbackUtil.toArray(feedback);
            if(checkContains(iFeedbackArray,feedbackArray)){
                ids.add(feedback.getStuId());
            }
        }
        List<Student> studentList=null;
        if(ids.isEmpty())return studentList;
        Map<String,Object> map2=new HashMap<>();
        map2.put("ids",ids);
        return studentDao.selectConditions(map2);
    }

    private boolean checkContains(FeedbackArray feedbackArray,FeedbackArray filter){
        if(!checkListContains(feedbackArray.getAnswer1(),filter.getAnswer1()))return false;
        if(!checkListContains(feedbackArray.getAnswer2(),filter.getAnswer2()))return false;
        if(!checkListContains(feedbackArray.getAnswer3(),filter.getAnswer3()))return false;
        if(!checkListContains(feedbackArray.getAnswer4(),filter.getAnswer4()))return false;
        if(!checkListContains(feedbackArray.getAnswer5(),filter.getAnswer5()))return false;
        if(!checkListContains(feedbackArray.getAnswer6(),filter.getAnswer6()))return false;
        if(!checkListContains(feedbackArray.getAnswer7(),filter.getAnswer7()))return false;
        if(!checkListContains(feedbackArray.getAnswer8(),filter.getAnswer8()))return false;
        if(!checkListContains(feedbackArray.getAnswer9(),filter.getAnswer9()))return false;
        if(!checkListContains(feedbackArray.getAnswer10(),filter.getAnswer10()))return false;
        if(!checkListContains(feedbackArray.getAnswer11(),filter.getAnswer11()))return false;
        if(!checkListContains(feedbackArray.getAnswer12(),filter.getAnswer12()))return false;
        if(!checkListContains(feedbackArray.getAnswer13(),filter.getAnswer13()))return false;
        if(!checkListContains(feedbackArray.getAnswer14(),filter.getAnswer14()))return false;
        if(!checkListContains(feedbackArray.getAnswer15(),filter.getAnswer15()))return false;
        if(!checkListContains(feedbackArray.getAnswer16(),filter.getAnswer16()))return false;
        if(!checkListContains(feedbackArray.getAnswer17(),filter.getAnswer17()))return false;
        if(!checkListContains(feedbackArray.getAnswer18(),filter.getAnswer18()))return false;
        if(!checkListContains(feedbackArray.getAnswer19(),filter.getAnswer19()))return false;
        if(!checkListContains(feedbackArray.getAnswer20(),filter.getAnswer20()))return false;
        return true;
    }

    private boolean checkListContains(List<String> listA,List<String> listB){
        if(listB==null)return true;
        if(listA!=null&&listA.containsAll(listB))return true;
        return false;
    }

    private void nullToString(Feedback feedback){
        if(feedback.getAnswer1()==null)feedback.setAnswer1(" ");
        if(feedback.getAnswer2()==null)feedback.setAnswer2(" ");
        if(feedback.getAnswer3()==null)feedback.setAnswer3(" ");
        if(feedback.getAnswer4()==null)feedback.setAnswer4(" ");
        if(feedback.getAnswer5()==null)feedback.setAnswer5(" ");
        if(feedback.getAnswer6()==null)feedback.setAnswer6(" ");
        if(feedback.getAnswer7()==null)feedback.setAnswer7(" ");
        if(feedback.getAnswer8()==null)feedback.setAnswer8(" ");
        if(feedback.getAnswer9()==null)feedback.setAnswer9(" ");
        if(feedback.getAnswer10()==null)feedback.setAnswer10(" ");
        if(feedback.getAnswer11()==null)feedback.setAnswer11(" ");
        if(feedback.getAnswer12()==null)feedback.setAnswer12(" ");
        if(feedback.getAnswer13()==null)feedback.setAnswer13(" ");
        if(feedback.getAnswer14()==null)feedback.setAnswer14(" ");
        if(feedback.getAnswer15()==null)feedback.setAnswer15(" ");
        if(feedback.getAnswer16()==null)feedback.setAnswer16(" ");
        if(feedback.getAnswer17()==null)feedback.setAnswer17(" ");
        if(feedback.getAnswer18()==null)feedback.setAnswer18(" ");
        if(feedback.getAnswer19()==null)feedback.setAnswer19(" ");
        if(feedback.getAnswer20()==null)feedback.setAnswer20(" ");
        if(feedback.getAnswer21()==null)feedback.setAnswer21(" ");
    }
}
