package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.Advertise;

import java.util.List;
import java.util.Map;

public interface AdvertiseService {

<<<<<<< HEAD
=======
    void addAdvertise(Advertise advertise);

    /**
     *
     * @param adIds 多个要删除的id
     */
    void delAdvertise(Long[] adIds);

    List<Advertise> findAll();

    //service层要检查map里是否存在该用户没有的权限
    List<Advertise> findConditions(Map<String,Object> map);

>>>>>>> 1c32c34139b2fc9bf169a17c5fb37049b3cdb3a8
}
