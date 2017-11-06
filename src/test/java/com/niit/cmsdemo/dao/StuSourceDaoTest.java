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
        stuSource.setName("asdasd");
        stuSourceDao.insertOne(stuSource);
    }

    @Test
    public void deleteOne() throws Exception {
        stuSourceDao.deleteOne(7);
    }

    @Test
    public void updateOne() throws Exception {
        StuSource stuSource=stuSourceDao.selectOne(4);
        stuSource.setName("wedwdw");
        stuSourceDao.updateOne(stuSource);
    }

    @Test
    public void selectOne() throws Exception {
        System.out.println(stuSourceDao.selectOne(2));
    }

    @Test
    public void selectConditions() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("parentId","1");
        List<StuSource> stuSources=stuSourceDao.selectConditions(map);
        for(StuSource stuSource:stuSources){
            System.out.println(stuSource);
        }
    }

}