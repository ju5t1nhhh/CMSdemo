package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.StuSourceDao;
import com.niit.cmsdemo.domain.StuSource;
import com.niit.cmsdemo.service.StuSourceService;
import com.niit.cmsdemo.vo.StuSourceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StuSourceServiceImpl implements StuSourceService {

    @Autowired
    private StuSourceDao stuSourceDao;

    @Override
    public void addStuSource(StuSource stuSource) {
        stuSourceDao.insertOne(stuSource);
    }

    @Override
    public void delStuSource(Integer[] ids) {
        for(Integer id:ids){
            stuSourceDao.deleteOne(id);
        }
    }

    @Override
    public List<StuSource> findAll() {
        return stuSourceDao.selectConditions(null);
    }

    @Override
    public List<StuSourceResponse> getStuSource() {
        List<StuSourceResponse> stuSourceResponses=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("parentId",0);
        List<StuSource> stuSources=stuSourceDao.selectConditions(map);
        for(StuSource stuSource:stuSources){
            map.put("parentId",stuSource.getId());
            List<StuSource> sources=stuSourceDao.selectConditions(map);
            StuSourceResponse stuSourceResponse=new StuSourceResponse();
            stuSourceResponse.setStuSource(stuSource);
            stuSourceResponse.setSonStuSources(sources);
            stuSourceResponses.add(stuSourceResponse);
        }
        return stuSourceResponses;
    }
}
