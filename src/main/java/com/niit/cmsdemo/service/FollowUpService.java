package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.FollowUp;

import java.util.List;
import java.util.Map;

public interface FollowUpService {

    void addFollowUp(FollowUp followUp,String userId);

    void delFollowUp(Long[] ids,String userId);

    void updateFollowUp(FollowUp followUp,String userId);

    List<FollowUp> findAll();

    List<FollowUp> findConditions(Map<String,Object> map,String userId);

}
