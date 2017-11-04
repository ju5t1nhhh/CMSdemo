package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.StuSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuSourceDao {

    Integer insertOne(StuSource stuSource);

    Integer deleteOne(Integer id);

    Integer updateOne(StuSource stuSource);

    /**
     * 根据 type 查询 1-菜单 2-可选值
     * @param type
     * @return
     */
    List<StuSource> selectByType(Integer type);

    /**
     * 根据父结点查询
     * @param parentId
     * @return
     */
    List<StuSource> selectByParentId(Integer parentId);

}
