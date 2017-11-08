package com.niit.cmsdemo.service;

import com.niit.cmsdemo.vo.StuSourceResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StuSourceServiceTest {

    @Resource
    private StuSourceService stuSourceService;

    @Test
    public void addStuSource() throws Exception {
    }

    @Test
    public void delStuSource() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void getStuSource() throws Exception {
        List<StuSourceResponse> stuSourceResponses= stuSourceService.getStuSource();
        for(StuSourceResponse stuSourceResponse:stuSourceResponses){
            System.out.println(stuSourceResponse);
        }
    }

}