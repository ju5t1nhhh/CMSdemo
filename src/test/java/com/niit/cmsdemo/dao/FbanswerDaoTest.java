package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Fbanswer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class FbanswerDaoTest {

    @Resource
    private FbanswerDao fbanswerDao;

    @Test
    public void insertOne() throws Exception {
        Fbanswer fbanswer=new Fbanswer();
        fbanswer.setQuestionId(3);
        fbanswer.setDetails("asdasdasd");
        System.out.println(fbanswerDao.insertOne(fbanswer));
    }

    @Test
    public void deleteOne() throws Exception {
        System.out.println(fbanswerDao.deleteOne(5));
    }

    @Test
    public void updateOne() throws Exception {
        Fbanswer fbanswer=fbanswerDao.selectOne(4);
        fbanswer.setDetails("asdasdasdasd");
        System.out.println(fbanswerDao.updateOne(fbanswer));
    }

    @Test
    public void resetLocation() throws Exception {
        System.out.println(fbanswerDao.resetLocation(5,88));
    }

    @Test
    public void selectOne() throws Exception {
        System.out.println(fbanswerDao.selectOne(3));
    }

    @Test
    public void selectByQuestionId() throws Exception {
        List<Fbanswer> fbanswers=fbanswerDao.selectByQuestionId(3);
        for(Fbanswer fbanswer:fbanswers){
            System.out.println(fbanswer);
        }
    }

}