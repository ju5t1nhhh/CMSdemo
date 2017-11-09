package com.niit.cmsdemo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    public static String getDate(){
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }
}
