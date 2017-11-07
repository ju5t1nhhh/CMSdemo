package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.Advertise;

import java.util.List;
import java.util.Map;

public interface AdvertiseService {

    void addAdvertise(Advertise advertise,String userId);

    /**
     *
     * @param adIds 多个要删除的id
     */
    void delAdvertise(Long[] adIds,String userId);

    //service层要检查map里是否存在该用户没有的权限
    List<Advertise> findConditions(Map<String,Object> map,String userId);

}
