package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.AdvertiseDao;
import com.niit.cmsdemo.dao.RoleDao;
import com.niit.cmsdemo.dao.UserRoleDao;
import com.niit.cmsdemo.domain.Advertise;
import com.niit.cmsdemo.service.AdvertiseService;
import com.niit.cmsdemo.util.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

    @Autowired
    private AdvertiseDao advertiseDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public void addAdvertise(Advertise advertise, String userId) {
        advertise.setUserId(userId);
        advertiseDao.insertOne(advertise);
    }

    @Override
    public void delAdvertise(Long adId, String userId) throws Exception {
        //检查userId与Advertise是否对应
        if(roleDao.selectOne(userRoleDao.selectRoleIdsByUserId(userId)).getName().equals("admin")
                ||advertiseDao.selectOne(adId).getUserId().equals(userId)){
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
        if(!roleDao.selectOne(userRoleDao.selectRoleIdsByUserId(userId)).getName().equals("admin")){
            map.put("userId",userId);
        }
        String startDate= (String) map.get("startDate");
        String endDate= (String) map.get("endDate");
        if(startDate==null||endDate==null||startDate.length()==0||endDate.length()==0){
            String date=DateHelper.getDate();
            map.put("startDate", date);
            map.put("endDate", date);
        }else{
            map.put("endDate",endDate);
        }
        return advertiseDao.selectConditions(map);
    }
}
