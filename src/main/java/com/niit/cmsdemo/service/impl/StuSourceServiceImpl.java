package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.StuSourceDao;
import com.niit.cmsdemo.domain.StuSource;
import com.niit.cmsdemo.service.StuSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StuSourceServiceImpl implements StuSourceService {

    @Autowired
    private StuSourceDao stuSourceDao;


    @Override
    public void addStuSource(String details) throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("name",details);
        List<StuSource> stuSources=stuSourceDao.selectConditions(map);
        if(stuSources.isEmpty()){
            StuSource stuSource=new StuSource();
            stuSource.setName(details);
            stuSourceDao.insertOne(stuSource);
        }else throw new Exception("已存在生源"+details);
    }

    @Override
    public void delStuSource(Integer id) {
        stuSourceDao.deleteOne(id);
    }

    @Override
    public List<StuSource> findAll() {
        return stuSourceDao.selectConditions(null);
    }

    @Override
    public List<StuSource> getStuSource() {
        return stuSourceDao.selectConditions(null);
    }
}
