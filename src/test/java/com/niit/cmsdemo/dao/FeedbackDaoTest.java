package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Feedback;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FeedbackDaoTest {

    @Resource
    private FeedbackDao feedbackDao;

    @Test
    public void insertOne() throws Exception {
        Feedback feedback=new Feedback();
        feedback.setStuId(4L);
        feedback.setAnswer1("A,B;");
        feedbackDao.insertOne(feedback);
    }

    @Test
    public void deleteOne() throws Exception {
        feedbackDao.deleteOne(3L);
    }

    @Test
    public void updateOne() throws Exception {
        Feedback feedback=feedbackDao.selectOne(4L);
        feedback.setAnswer1("BBBBBB");
        feedbackDao.updateOne(feedback);
    }

    @Test
    public void selectOne() throws Exception {

    }

    @Test
    public void selectConditions() throws Exception {
        List<Feedback> feedbacks=feedbackDao.selectConditions(null);
        for(Feedback feedback:feedbacks){
            System.out.println(feedback);
        }
    }

}