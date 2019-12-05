package org.jplus.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class GetYear {

    /*获取学年*/
    public static int getYears(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        String time=sdf.format(date);
        String[] item = time.split("-");
        int year  = Integer.parseInt(item[0]);
        int month = Integer.parseInt(item[1]);
        if((month - 3) <= 0){
            month = month + 12 - 3;
            year = year -1;
        }
        return year;
    }
}
