package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.Feedback;

import java.util.List;
import java.util.Map;

public interface FeedbackService {

    void addFeedback(Feedback feedback);

    void delFeedback(Long stuId,String userId) throws Exception;

    void updateFeedback(Feedback feedback,String userId) throws Exception;

    Feedback findFeedback(Long stuId,String userId);

    List<Feedback> findConditions(Map<String,Object> map);

}
