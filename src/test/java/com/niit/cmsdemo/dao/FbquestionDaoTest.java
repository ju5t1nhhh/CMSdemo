package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Fbquestion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class FbquestionDaoTest {

    @Resource
    private FbquestionDao fbquestionDao;

    @Test
    public void insertOne() throws Exception {
        Fbquestion fbquestion=new Fbquestion();
        fbquestion.setDetails("hahahahaha");
        System.out.println(fbquestionDao.insertOne(fbquestion));
    }

    @Test
    public void deleteOne() throws Exception {
        System.out.println(fbquestionDao.deleteOne(8));
    }

    @Test
    public void updateOne() throws Exception {
        Fbquestion fbquestion=fbquestionDao.selectOne(2);
        fbquestion.setDetails("2323");
        System.out.println(fbquestionDao.updateOne(fbquestion));
        System.out.println(fbquestionDao.resetLocation(9,10));
    }

    @Test
    public void selectOne() throws Exception {
        System.out.println(fbquestionDao.selectOne(1));
    }

    @Test
    public void selectAll() throws Exception {
        List<Fbquestion> fbquestions=fbquestionDao.selectAll();
        for(Fbquestion fbquestion:fbquestions){
            System.out.println(fbquestion);
        }
    }

}