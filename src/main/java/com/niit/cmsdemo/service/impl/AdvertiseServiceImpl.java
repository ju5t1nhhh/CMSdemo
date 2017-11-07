package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.AdvertiseDao;
import com.niit.cmsdemo.domain.Advertise;
import com.niit.cmsdemo.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

    @Autowired
    private AdvertiseDao advertiseDao;


    @Override
    public void addAdvertise(Advertise advertise, String userId) {
        advertise.setUserId(userId);
        advertiseDao.insertOne(advertise);
    }

    @Override
    public void delAdvertise(Long[] adIds, String userId) {
        for(Long id:adIds){
            //检查userId与Advertise是否对应
            if(advertiseDao.selectOne(id).getUserId().equals(userId)){
                advertiseDao.deleteOne(id);
            }
        }
    }

    @Override
    public List<Advertise> findConditions(Map<String, Object> map, String userId) {
        map.put("userId",userId);
        return advertiseDao.selectConditions(map);
    }
}
