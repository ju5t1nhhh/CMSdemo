package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.FbanswerDao;
import com.niit.cmsdemo.domain.Fbanswer;
import com.niit.cmsdemo.service.FbanswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FbanswerServiceImpl implements FbanswerService{

    @Autowired
    private FbanswerDao fbanswerDao;

    @Override
    public void addFbanswer(Fbanswer fbanswer) throws Exception {
        if(fbanswerDao.selectByQuestionId(fbanswer.getQuestionId()).size()==11)
            throw new Exception("问题"+fbanswer.getQuestionId()+"不能超过10个选项");
        else{
            fbanswerDao.insertOne(fbanswer);
        }
    }

    @Override
    @Transactional
    public void delFbanswer(Integer id) {
        Fbanswer fbanswer=fbanswerDao.selectOne(id);
        int location=fbanswer.getLocation();
        int questionId=fbanswer.getQuestionId();
        for(int i=location+1;i<11;i++){
            Fbanswer iFbanswer=fbanswerDao.selectSpecial(questionId,i);
            if(iFbanswer==null)break;
            fbanswerDao.resetLocation(iFbanswer.getId(),i-1);
        }
        fbanswerDao.deleteOne(id);
    }

    @Override
    @Transactional
    public void updateFbanswer(Fbanswer fbanswer) {
        Fbanswer dbFbanswer=fbanswerDao.selectOne(fbanswer.getId());
        if(dbFbanswer.getLocation()==fbanswer.getLocation()){
            fbanswerDao.updateOne(fbanswer);
        }else{
            int questionId=fbanswer.getQuestionId();
            if(fbanswer.getLocation()>dbFbanswer.getLocation()){
                for(int i=dbFbanswer.getLocation()+1;i<=fbanswer.getLocation();i++){
                    Fbanswer iFbanswer=fbanswerDao.selectSpecial(questionId,i);
                    fbanswerDao.resetLocation(iFbanswer.getId(),i-1);
                }
            }else{
                for(int i=dbFbanswer.getLocation()-1;i>=fbanswer.getLocation();i--){
                    Fbanswer iFbanswer=fbanswerDao.selectSpecial(questionId,i);
                    fbanswerDao.resetLocation(iFbanswer.getId(),i+1);
                }
            }
            fbanswerDao.updateOne(fbanswer);
            fbanswerDao.resetLocation(fbanswer.getId(),fbanswer.getLocation());
        }
    }

    @Override
    public List<Fbanswer> getByQuestionId(Integer questionId) {
        return fbanswerDao.selectByQuestionId(questionId);
    }
}
