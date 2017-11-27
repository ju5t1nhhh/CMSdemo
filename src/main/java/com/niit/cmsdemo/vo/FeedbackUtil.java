package com.niit.cmsdemo.vo;

import com.github.pagehelper.util.StringUtil;
import com.niit.cmsdemo.domain.Feedback;
import org.thymeleaf.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class FeedbackUtil {
    public static FeedbackArray toArray(Feedback feedback){
        FeedbackArray feedbackArray=new FeedbackArray();
        feedbackArray.setAnswer1(changeAnswer(feedback.getAnswer1()));
        feedbackArray.setAnswer2(changeAnswer(feedback.getAnswer2()));
        feedbackArray.setAnswer3(changeAnswer(feedback.getAnswer3()));
        feedbackArray.setAnswer4(changeAnswer(feedback.getAnswer4()));
        feedbackArray.setAnswer5(changeAnswer(feedback.getAnswer5()));
        feedbackArray.setAnswer6(changeAnswer(feedback.getAnswer6()));
        feedbackArray.setAnswer7(changeAnswer(feedback.getAnswer7()));
        feedbackArray.setAnswer8(changeAnswer(feedback.getAnswer8()));
        feedbackArray.setAnswer9(changeAnswer(feedback.getAnswer9()));
        feedbackArray.setAnswer10(changeAnswer(feedback.getAnswer10()));
        return feedbackArray;
    }

    private static List<String> changeAnswer(String answer){
        if(answer==null|| StringUtils.trim(answer).length()==0)return null;
        String[] strings=answer.split(",");
        return Arrays.asList(strings);
    }

}
