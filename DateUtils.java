package com.javatut;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /**
     *
     * @return current Date from Calendar in dd-MM-yyyy format
     * adding 1 into month because Calendar month starts from zero
     */
    public static String getDate(Calendar cal){
        return "" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.YEAR);
    }


    //Convert Date to Calendar
    public static Calendar dateToCalendar(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;

    }

    //Convert Calendar to Date
    public static Date calendarToDate(Calendar calendar) {
        return calendar.getTime();
    }
}