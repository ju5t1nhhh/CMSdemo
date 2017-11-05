package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.StuSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StuSourceDaoTest
{
    @Autowired
    private StuSourceDao stuSourceDao;

    @Test
    public void insertOne() throws Exception {
        StuSource stuSource = new StuSource();
        stuSource.setId(1);
        stuSource.setName("aaa");
        stuSourceDao.insertOne(stuSource);
    }

    @Test
    public void deleteOne() throws Exception {
    }

    @Test
    public void updateOne() throws Exception {
        StuSource stuSource = new StuSource();
        stuSource.setId(1);
        stuSource.setName("aaabbb");
        stuSourceDao.updateOne(stuSource);
    }

    @Test
    public void selectByType() throws Exception {
        System.out.println(stuSourceDao.selectByType(2));
    }

    @Test
    public void selectByParentId() throws Exception {
        System.out.println(stuSourceDao.selectByParentId(2));
    }

}