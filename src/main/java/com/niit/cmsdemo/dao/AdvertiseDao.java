package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.Advertise;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdvertiseDao {

    Integer insertOne(Advertise advertise);

    Integer deleteOne(Long id);

    /**
     * 查询所有广告
     * @return
     */
    List<Advertise> selectAll();

    /**
     * 多条件查询广告
     * @param map
     * @return
     */
    List<Advertise> selectConditions(Map<String,Object> map);
}
