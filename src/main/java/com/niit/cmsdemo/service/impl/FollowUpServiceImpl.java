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
    public void addFollowUp(FollowUp followUp, String userId) {
        //检查学生与User关系
        if(userStudentDao.selectUserIdByStuId(followUp.getStuId()).equals(userId)){
            followUpDao.insertOne(followUp);
        }
    }

    @Override
    public void delFollowUp(Long[] ids, String userId) {
        for(Long id:ids){
            if(userStudentDao.selectUserIdByStuId(id).equals(userId)){
                followUpDao.deleteOne(id);
            }
        }
    }

    @Override
    public void updateFollowUp(FollowUp followUp, String userId) {
        if(userStudentDao.selectUserIdByStuId(followUp.getStuId()).equals(userId)){
            followUpDao.updateOne(followUp);
        }
    }

    @Override
    public List<FollowUp> findConditions(Map<String, Object> map, String userId) {
        return followUpDao.selectConditions(map);
    }
}
