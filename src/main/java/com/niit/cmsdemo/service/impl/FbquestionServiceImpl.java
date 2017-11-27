package com.niit.cmsdemo.service.impl;

import com.niit.cmsdemo.dao.FbanswerDao;
import com.niit.cmsdemo.dao.FbquestionDao;
import com.niit.cmsdemo.domain.Fbanswer;
import com.niit.cmsdemo.domain.Fbquestion;
import com.niit.cmsdemo.service.FbanswerService;
import com.niit.cmsdemo.service.FbquestionService;
import com.niit.cmsdemo.vo.Fbtable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FbquestionServiceImpl implements FbquestionService{

    @Autowired
    private FbquestionDao fbquestionDao;

    @Autowired
    private FbanswerDao fbanswerDao;

    @Autowired
    private FbanswerService fbanswerService;

    @Override
    @Transactional
    public void addQuestion(Fbquestion fbquestion) {
        fbquestionDao.insertOne(fbquestion);
        Fbanswer fbanswer=new Fbanswer();
        fbanswer.setQuestionId(fbquestion.getId());
        fbanswer.setLocation(99);
        fbanswer.setDetails("其他");
        fbanswerDao.insertOne(fbanswer);
    }

    @Override
    @Transactional
    public void delQuestion(Integer id) {
        List<Fbanswer> fbanswers=fbanswerService.getByQuestionId(id);
        for(Fbanswer fbanswer:fbanswers){
            fbanswerDao.deleteOne(fbanswer.getId());
        }
        Fbquestion fbquestion=fbquestionDao.selectOne(id);
        int i=fbquestion.getLocation()+1;
        while(true){
            Fbquestion iFbquestion=fbquestionDao.selectByLocation(i);
            if(iFbquestion==null)break;
            fbquestionDao.resetLocation(iFbquestion.getId(),i-1);
            i++;
        }
        fbquestionDao.deleteOne(id);
    }

    @Override
    public void updateQuestion(Fbquestion fbquestion) {
        Fbquestion dbFbquestion=fbquestionDao.selectOne(fbquestion.getId());
        if(fbquestion.getLocation()==dbFbquestion.getLocation()){
            fbquestionDao.updateOne(fbquestion);
        }else{
            if(fbquestion.getLocation()>dbFbquestion.getLocation()){
                for(int i=dbFbquestion.getLocation()+1;i<=fbquestion.getLocation();i++){
                    Fbquestion iFbquestion=fbquestionDao.selectByLocation(i);
                    fbquestionDao.resetLocation(iFbquestion.getId(),i-1);
                }
            }else{
                for(int i=dbFbquestion.getLocation()-1;i>=fbquestion.getLocation();i--){
                    Fbquestion iFbquestion=fbquestionDao.selectByLocation(i);
                    fbquestionDao.resetLocation(iFbquestion.getId(),i+1);
                }
            }
            fbquestionDao.updateOne(fbquestion);
            fbquestionDao.resetLocation(fbquestion.getId(),fbquestion.getLocation());
        }
    }

    @Override
    public List<Fbtable> getFbtable() {
        List<Fbquestion> fbquestions=fbquestionDao.selectAll();
        List<Fbtable> fbtables=new ArrayList<>();
        for(Fbquestion fbquestion:fbquestions){
            Fbtable fbtable=new Fbtable();
            List<Fbanswer> fbanswers=fbanswerService.getByQuestionId(fbquestion.getId());
            fbtable.setFbquestion(fbquestion);
            fbtable.setFbanswers(fbanswers);
            fbtables.add(fbtable);
        }
        return fbtables;
    }
}
