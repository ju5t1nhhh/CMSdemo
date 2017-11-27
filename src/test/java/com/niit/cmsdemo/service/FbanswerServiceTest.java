package com.niit.cmsdemo.service;

import com.niit.cmsdemo.dao.FbanswerDao;
import com.niit.cmsdemo.domain.Fbanswer;
import com.niit.cmsdemo.domain.Feedback;
import com.niit.cmsdemo.vo.FeedbackArray;
import com.niit.cmsdemo.vo.FeedbackUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@SpringBootTest
@RunWith(SpringRunner.class)
public class FbanswerServiceTest {

    @Resource
    private FbanswerService fbanswerService;

    @Resource
    private FbanswerDao fbanswerDao;

    @Test
    public void addFbanswer() throws Exception {
        Fbanswer fbanswer=new Fbanswer();
        fbanswer.setQuestionId(1);
        fbanswer.setLocation(5);
        fbanswer.setDetails("HAHAHAH");
        fbanswerService.addFbanswer(fbanswer);
    }

    @Test
    public void delFbanswer() throws Exception {
        fbanswerService.delFbanswer(40);
    }

    @Test
    public void updateFbanswer() throws Exception {
        Fbanswer fbanswer=fbanswerDao.selectOne(16);
        fbanswer.setLocation(2);
        fbanswerService.updateFbanswer(fbanswer);
    }

    @Test
    public void getByQuestionId() throws Exception {
        List<Fbanswer> fbanswers=fbanswerService.getByQuestionId(2);
        for(Fbanswer fbanswer:fbanswers){
            System.out.println(fbanswer);
        }
    }

    @Test
    public void play() throws Exception{
        List<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list2.add("1");
        list2.add("3");
    }

}