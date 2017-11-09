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
    public void delAdvertise(Long adId, String userId) throws Exception {
        //检查userId与Advertise是否对应
        if(userId.equals("admin")||advertiseDao.selectOne(adId).getUserId().equals(userId)){
            advertiseDao.deleteOne(adId);
        }else{
            throw new Exception("no permission");
        }
    }

    @Override
    public List<Advertise> findAll() {
        return advertiseDao.selectConditions(null);
    }

    @Override
    public List<Advertise> findConditions(Map<String, Object> map, String userId) {
        if(!userId.equals("admin")){
            map.put("userId",userId);
        }
        return advertiseDao.selectConditions(map);
    }
}
