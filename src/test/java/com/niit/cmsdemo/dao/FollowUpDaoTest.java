package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.FollowUp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class FollowUpDaoTest {

    @Resource
    private FollowUpDao followUpDao;

    @Test
    public void insertOne() throws Exception {
        FollowUp followUp=new FollowUp();
        followUp.setStuId(2L);
        followUp.setNote("其实不错");
        followUp.setClassification('A');
        followUpDao.insertOne(followUp);
    }

    @Test
    public void deleteOne() throws Exception {
        System.out.println(followUpDao.deleteOne(3L));
    }

    @Test
    public void updateOne() throws Exception {
        FollowUp followUp=followUpDao.selectOne(1L);
        followUp.setNote("改进一下不错");
        System.out.println(followUpDao.updateOne(followUp));
    }

    @Test
    public void selectOne() throws Exception {
        System.out.println(followUpDao.selectOne(2L));
    }

    @Test
    public void selectByStuId() throws Exception {
        List<FollowUp> followUps=followUpDao.selectByStuId(1L);
    }

    @Test
    public void selectRecent() throws Exception {
        List<FollowUp> followUps=followUpDao.selectRecent(1L,'A',"2017-09-09","2018-01-01");
        for(FollowUp followUp:followUps){
            System.out.println(followUp);
        }
    }

    @Test
    public void selectConditions() throws Exception {
    }

}