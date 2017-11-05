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
     * 在map中时间用变量date去存，格式是%Y-%m-%d
     * @return list
     */
    List<Advertise> selectConditions(Map<String,Object> map);
}
