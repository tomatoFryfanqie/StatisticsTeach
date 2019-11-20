package org.jplus.utils;

import java.util.Calendar;

/**
 * @author wb
 * @date 2019/10/28 - 9:22
 * 项目中操作时间的工具类
 */
public class DateUtils {
    public static Integer getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        long time = calendar.getTimeInMillis();
        int year = calendar.getWeekYear();
        calendar.clear();
        calendar.set(year,4,1);
        long startMillis = calendar.getTimeInMillis();
        calendar.clear();
        calendar.set(year+1,3,31);
        long endMillis = calendar.getTimeInMillis();
        if(time >startMillis && time < endMillis) {
            return year;
        }else {
            return year+1;
        }
    }
}
