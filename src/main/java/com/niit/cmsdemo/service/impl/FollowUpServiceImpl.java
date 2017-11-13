package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.FollowUpDao;
import com.niit.cmsdemo.dao.UserStudentDao;
import com.niit.cmsdemo.domain.FollowUp;
import com.niit.cmsdemo.service.FollowUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FollowUpServiceImpl implements FollowUpService{

    @Autowired
    private FollowUpDao followUpDao;

    @Autowired
    private UserStudentDao userStudentDao;

    @Override
    public void addFollowUp(FollowUp followUp, String userId) throws Exception {
        //检查学生与User关系
        if(userStudentDao.selectUserIdByStuId(followUp.getStuId()).equals(userId)||userId.equals("admin")){
            followUpDao.insertOne(followUp);
        }else{
            throw new Exception("添加跟进失败");
        }
    }

    @Override
    public void delFollowUp(Long id, String userId) throws Exception {
        FollowUp followUp=followUpDao.selectOne(id);
        Long stuId=followUp.getStuId();
        if(userStudentDao.selectUserIdByStuId(stuId).equals(userId)||userId.equals("admin")){
            followUpDao.deleteOne(id);
        }else{
            throw new Exception("删除失败");
        }
    }

    @Override
    public void updateFollowUp(FollowUp followUp, String userId) throws Exception {
        if(userStudentDao.selectUserIdByStuId(followUp.getStuId()).equals(userId)||userId.equals("admin")){
            followUpDao.updateOne(followUp);
        }else{
            throw new Exception("更新失败");
        }
    }

    @Override
    public List<FollowUp> findAll() {
        return followUpDao.selectConditions(null);
    }

    @Override
    public List<FollowUp> findConditions(Map<String, Object> map) {
        return followUpDao.selectConditions(map);
    }
}
