package com.example.taras.privatinfo.utils;

import java.util.Calendar;

public class DateUtils {

    public static long getCurrentTimestamp(){
        Calendar cal = Calendar.getInstance();
        return cal.getTimeInMillis();
    }

    public static boolean isWeekAgo(){
        long prevUpdateTime = PreferenceUtils.getLastTimestampUpdate();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -7);
        long sevenDaysAgo = cal.getTimeInMillis();

        if (prevUpdateTime < sevenDaysAgo){
            return true;
        } else {
            return false;
        }
    }

}
