package com.niit.cmsdemo.vo;

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
        feedbackArray.setAnswer11(changeAnswer(feedback.getAnswer11()));
        feedbackArray.setAnswer12(changeAnswer(feedback.getAnswer12()));
        feedbackArray.setAnswer13(changeAnswer(feedback.getAnswer13()));
        feedbackArray.setAnswer14(changeAnswer(feedback.getAnswer14()));
        feedbackArray.setAnswer15(changeAnswer(feedback.getAnswer15()));
        feedbackArray.setAnswer16(changeAnswer(feedback.getAnswer16()));
        feedbackArray.setAnswer17(changeAnswer(feedback.getAnswer17()));
        feedbackArray.setAnswer18(changeAnswer(feedback.getAnswer18()));
        feedbackArray.setAnswer19(changeAnswer(feedback.getAnswer19()));
        feedbackArray.setAnswer20(changeAnswer(feedback.getAnswer20()));
        return feedbackArray;
    }

    private static List<String> changeAnswer(String answer){
        if(answer==null|| StringUtils.trim(answer).length()==0)return null;
        String[] strings=answer.split(",");
        return Arrays.asList(strings);
    }

}
