package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Feedback;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FeedbackDaoTest {

    @Resource
    private FeedbackDao feedbackDao;

//    @Test
    public void insertOne() throws Exception {
        Feedback feedback=new Feedback();
        feedback.setStuId(4L);
        feedback.setAnswer1("1");
        feedbackDao.insertOne(feedback);
    }

    @Test
    public void deleteOne() throws Exception {
        System.out.println(feedbackDao.deleteOne(4L));
    }

    @Test
    public void updateOne() throws Exception {
        Feedback feedback=feedbackDao.selectOne(1L);
        feedback.setAnswer10("1,2,3");
        System.out.println(feedbackDao.updateOne(feedback));
    }

    @Test
    public void selectOne() throws Exception {
//        System.out.println(feedbackDao.selectOne(1L));
//        feedbackDao.exchange("answer1","answer2");
        feedbackDao.setFieldNull("answer1");
    }

    @Test
    public void selectConditions() throws Exception {
        Map<String,Object> map=new HashMap<>();
        List<Long> ids=new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        map.put("ids",ids);
        map.put("startDate","2017-01-01");
        map.put("endDate","2018-01-01");
        List<Feedback> feedbacks=feedbackDao.selectConditions(map);
        for(Feedback feedback:feedbacks){
            System.out.println(feedback);
        }
    }

}