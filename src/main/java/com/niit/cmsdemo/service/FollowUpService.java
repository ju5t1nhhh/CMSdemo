package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.FollowUp;

import java.util.List;
import java.util.Map;

public interface FollowUpService {

    void addFollowUp(FollowUp followUp);

    void delFollowUp(Long[] ids);

    void updateFollowUp(FollowUp followUp);

    List<FollowUp> findConditions(Map<String,Object> map);

}
