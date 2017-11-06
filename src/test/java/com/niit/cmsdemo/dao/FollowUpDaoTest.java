package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.FollowUp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        followUp.setNote("bangbangda");
        followUpDao.insertOne(followUp);
    }

    @Test
    public void deleteOne() throws Exception {
        followUpDao.deleteOne(3L);
    }

    @Test
    public void updateOne() throws Exception {
        FollowUp followUp=followUpDao.selectOne(1L);
        followUp.setNote("lalala");
        followUpDao.updateOne(followUp);
    }

    @Test
    public void selectOne() throws Exception {
        System.out.println(followUpDao.selectOne(1L));
    }

    @Test
    public void selectConditions() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("stuId","1");
        map.put("note","oo");
        List<FollowUp> followUps=followUpDao.selectConditions(map);
        for(FollowUp followUp:followUps){
            System.out.println(followUp);
        }
    }

}