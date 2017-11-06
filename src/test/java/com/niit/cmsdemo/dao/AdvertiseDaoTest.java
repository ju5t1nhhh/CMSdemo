package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Advertise;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdvertiseDaoTest {

    @Autowired
    private AdvertiseDao advertiseDao;

    @Test
    public void insertOne() throws Exception {
        Advertise advertise = new Advertise();
        advertise.setId(3L);
        advertise.setUrl("1111");
        advertise.setUserId("1111");
        advertiseDao.insertOne(advertise);
    }

    @Test
    public void deleteOne() throws Exception {
        advertiseDao.deleteOne(3L);
    }

    @Test
    public void selectAll() throws Exception {
        List<Advertise> list = advertiseDao.selectAll();
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }

    @Test
    public void selectConditions() throws Exception {
        Map map = new HashMap<>();
        map.put("date","2017-11-06");
        List<Advertise> list = advertiseDao.selectConditions(map);
        for (int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }

}