package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.StuSource;

import java.util.List;

public interface StuSourceService {

    void addStuSource(String details) throws Exception;

    void delStuSource(Integer id);

    //具体问题 具体分析
    List<StuSource> findAll();

    List<StuSource> getStuSource();

}
