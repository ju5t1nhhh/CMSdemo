package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.FollowUp;

import java.util.List;
import java.util.Map;

public interface FollowUpService {

    void addFollowUp(FollowUp followUp,String userId) throws Exception;

    void delFollowUp(Long id,String userId) throws Exception;

    void updateFollowUp(FollowUp followUp,String userId) throws Exception;

    List<FollowUp> findAll();

    List<FollowUp> findConditions(Map<String,Object> map);

}
