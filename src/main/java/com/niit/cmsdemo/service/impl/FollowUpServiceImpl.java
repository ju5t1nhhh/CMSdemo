package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.FollowUpDao;
import com.niit.cmsdemo.dao.RoleDao;
import com.niit.cmsdemo.dao.StudentDao;
import com.niit.cmsdemo.dao.UserRoleDao;
import com.niit.cmsdemo.domain.FollowUp;
import com.niit.cmsdemo.domain.Student;
import com.niit.cmsdemo.service.FollowUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class FollowUpServiceImpl implements FollowUpService{

    @Autowired
    private FollowUpDao followUpDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional
    public void addFollowUp(FollowUp followUp, String userId) throws Exception {
        //检查学生与User关系
        if(studentDao.selectOne(followUp.getStuId()).getWriterId().equals(userId)
                ||roleDao.selectOne(userRoleDao.selectRoleIdsByUserId(userId)).getName().equals("admin")){
            followUpDao.insertOne(followUp);
            studentDao.resetClassification(followUp.getStuId(),followUp.getClassification());
        }else{
            throw new Exception("添加跟进失败");
        }
    }

    @Override
    @Transactional
    public void delFollowUp(Long id, String userId) throws Exception {
        FollowUp followUp=followUpDao.selectOne(id);
        Long stuId=followUp.getStuId();
        if(studentDao.selectOne(stuId).getWriterId().equals(userId)
                ||roleDao.selectOne(userRoleDao.selectRoleIdsByUserId(userId)).getName().equals("admin")){
            List<FollowUp> followUps=followUpDao.selectRecent(followUp.getStuId(),null,null,null);
            if(followUps.size()>1){
                FollowUp fson=followUps.get(followUps.size()-2);
                studentDao.resetClassification(fson.getStuId(),fson.getClassification());
            }else{
                studentDao.resetClassification(stuId,null);
            }
            followUpDao.deleteOne(id);
        }else{
            throw new Exception("删除失败");
        }
    }

    @Override
    @Transactional
    public void updateFollowUp(FollowUp followUp, String userId) throws Exception {
        if(studentDao.selectOne(followUp.getStuId()).getWriterId().equals(userId)
                ||roleDao.selectOne(userRoleDao.selectRoleIdsByUserId(userId)).getName().equals("admin")){
            List<FollowUp> followUps=followUpDao.selectRecent(followUp.getStuId(),null,null,null);
            FollowUp fson=followUps.get(followUps.size()-1);
            if(fson.getId()==followUp.getId())studentDao.resetClassification(followUp.getStuId(),followUp.getClassification());
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
