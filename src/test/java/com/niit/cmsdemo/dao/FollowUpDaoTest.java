package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.FollowUp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FollowUpDaoTest {

    @Resource
    private FollowUpDao followUpDao;

    @Test
    public void insertOne() throws Exception {
        FollowUp followUp=new FollowUp();
        followUp.setStuId(1L);
        followUp.setNote("watch 666");
        followUpDao.insertOne(followUp);
    }

    @Test
    public void deleteOne() throws Exception {
        followUpDao.deleteOne(4L);
    }

    @Test
    public void updateOne() throws Exception {

    }

    @Test
    public void selectAll() throws Exception {
    }

    @Test
    public void selectConditions() throws Exception {
    }

}