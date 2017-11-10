package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.FeedbackDao;
import com.niit.cmsdemo.dao.UserStudentDao;
import com.niit.cmsdemo.domain.Feedback;
import com.niit.cmsdemo.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FeedbackServiceImpl implements FeedbackService{

    @Autowired
    private FeedbackDao feedbackDao;

    @Autowired
    private UserStudentDao userStudentDao;

    @Override
    public void addFeedback(Feedback feedback) {
        feedbackDao.insertOne(feedback);
    }

    @Override
    public void delFeedback(Long stuId, String userId) throws Exception {
        if(userStudentDao.selectUserIdByStuId(stuId).equals(userId)||userId.equals("admin")){
            feedbackDao.deleteOne(stuId);
        }else{
            throw new Exception("删除失败");
        }
    }

    @Override
    public void updateFeedback(Feedback feedback, String userId) throws Exception {
        if(userStudentDao.selectUserIdByStuId(feedback.getStuId()).equals(userId)||userId.equals("admin")){
            feedbackDao.updateOne(feedback);
        }else{
            throw new Exception("更新失败");
        }
    }

    @Override
    public Feedback findFeedback(Long stuId, String userId) {
        if(userStudentDao.selectUserIdByStuId(stuId).equals(userId)||userId.equals("admin")){
            return feedbackDao.selectOne(stuId);
        }else{
            return null;
        }
    }

    @Override
    public List<Feedback> findConditions(Map<String, Object> map) {
        return feedbackDao.selectConditions(map);
    }
}
