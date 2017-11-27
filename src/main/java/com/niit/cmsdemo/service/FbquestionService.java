package com.niit.cmsdemo.service;

import com.niit.cmsdemo.domain.Fbquestion;
import com.niit.cmsdemo.vo.Fbtable;

import java.util.List;

public interface FbquestionService {

    void addQuestion(Fbquestion fbquestion);

    void delQuestion(Integer id);

    void updateQuestion(Fbquestion fbquestion);

    List<Fbtable> getFbtable();

}
