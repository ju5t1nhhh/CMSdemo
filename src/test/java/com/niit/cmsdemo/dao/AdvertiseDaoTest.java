package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Advertise;
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
public class AdvertiseDaoTest {

    @Resource
    private AdvertiseDao advertiseDao;

    @Test
    public void insertOne() throws Exception {
        Advertise advertise=new Advertise();
        advertise.setUserId("phil");
        advertise.setUrl("www.alibaba.com");
        System.out.println(advertiseDao.insertOne(advertise));
    }

    @Test
    public void deleteOne() throws Exception {
        System.out.println(advertiseDao.deleteOne(3L));
    }

    @Test
    public void selectOne() throws Exception {
        System.out.println(advertiseDao.selectOne(1L));
    }

    @Test
    public void selectConditions() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("userId","jackie");
        map.put("startDate","2017-01-01");
        map.put("endDate","2018-01-01");
        List<Advertise> advertises=advertiseDao.selectConditions(map);
        for(Advertise advertise:advertises){
            System.out.println(advertise);
        }
    }

}