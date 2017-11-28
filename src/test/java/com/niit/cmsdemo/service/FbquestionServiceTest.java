package com.niit.cmsdemo.service;

import com.niit.cmsdemo.dao.FbquestionDao;
import com.niit.cmsdemo.domain.Fbquestion;
import com.niit.cmsdemo.vo.Fbtable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class FbquestionServiceTest {

    @Resource
    private FbquestionService fbquestionService;

    @Resource
    private FbquestionDao fbquestionDao;

    @Test
    public void addQuestion() throws Exception {
        Fbquestion fbquestion=new Fbquestion();
        fbquestion.setDetails("你猜kkCai");
        fbquestion.setType("radio");
        fbquestionService.addQuestion(fbquestion);
    }

    @Test
    public void delQuestion() throws Exception {
        fbquestionService.delQuestion(1);
    }

    @Test
    public void updateQuestion() throws Exception {
        Fbquestion fbquestion=fbquestionDao.selectOne(6);
        System.out.println(fbquestion);
        fbquestion.setLocation(2);
        fbquestionService.updateQuestion(fbquestion);
    }

    @Test
    public void getFbtable() throws Exception {
        List<Fbtable> fbtables=fbquestionService.getFbtable();
        for(Fbtable fbtable:fbtables){
            System.out.println(fbtable);
        }
    }

}