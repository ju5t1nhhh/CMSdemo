package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.AdvertiseDao;
import com.niit.cmsdemo.domain.Advertise;
import com.niit.cmsdemo.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

    @Autowired
    private AdvertiseDao advertiseDao;

    @Override
    public void addAdvertise(Advertise advertise) {
        advertiseDao.insertOne(advertise);
    }

    @Override
    public void delAdvertise(Long[] adIds) {
        for(Long id:adIds){
            advertiseDao.deleteOne(id);
        }
    }

    @Override
    public List<Advertise> findAll() {
        return advertiseDao.selectAll();
    }

    @Override
    public List<Advertise> findConditions(Map<String, Object> map) {
        return advertiseDao.selectConditions(map);
    }
}
