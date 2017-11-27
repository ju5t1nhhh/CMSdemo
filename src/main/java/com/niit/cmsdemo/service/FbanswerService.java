package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.Fbanswer;

import java.util.List;

public interface FbanswerService {

    void addFbanswer(Fbanswer fbanswer) throws Exception;

    void delFbanswer(Integer id);

    void updateFbanswer(Fbanswer fbanswer);

    List<Fbanswer> getByQuestionId(Integer questionId);

}
