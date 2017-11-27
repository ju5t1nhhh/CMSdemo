package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.StuSource;
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
public class StuSourceDaoTest {

    @Resource
    private StuSourceDao stuSourceDao;

    @Test
    public void insertOne() throws Exception {
        StuSource stuSource=new StuSource();
        stuSource.setName("街边捡的");
        stuSourceDao.insertOne(stuSource);
    }

    @Test
    public void selectOne() throws Exception {
        System.out.println(stuSourceDao.selectOne(1));
    }

    @Test
    public void selectConditions() throws Exception {
        List<StuSource> stuSources=stuSourceDao.selectConditions(null);
        for(StuSource stuSource:stuSources){
            System.out.println(stuSource);
        }
    }

}