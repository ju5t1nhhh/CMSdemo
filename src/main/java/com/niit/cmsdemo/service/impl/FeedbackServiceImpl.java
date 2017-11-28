package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.FeedbackDao;
import com.niit.cmsdemo.dao.RoleDao;
import com.niit.cmsdemo.dao.StudentDao;
import com.niit.cmsdemo.dao.UserDao;
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
    private StudentDao studentDao;

    @Autowired
    private UserDao userDao;

    @Override
    public void addFeedback(Feedback feedback) {
        feedbackDao.insertOne(feedback);
    }

    @Override
    public void delFeedback(Long stuId, String userId) throws Exception {
        if(studentDao.selectOne(stuId).getWriterId().equals(userId)
                ||userDao.selectOne(userId).getRole().equals("admin")){
            feedbackDao.deleteOne(stuId);
        }else{
            throw new Exception("删除失败");
        }
    }

    @Override
    public void updateFeedback(Feedback feedback, String userId) throws Exception {
        if(studentDao.selectOne(feedback.getStuId()).getWriterId().equals(userId)
                ||userDao.selectOne(userId).getRole().equals("admin")){
            feedbackDao.updateOne(feedback);
        }else{
            throw new Exception("更新失败");
        }
    }

    @Override
    public Feedback findFeedback(Long stuId, String userId) {
        if(studentDao.selectOne(stuId).getWriterId().equals(userId)
                ||userDao.selectOne(userId).getRole().equals("admin")){
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
