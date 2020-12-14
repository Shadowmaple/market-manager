package com.market.util;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Time {
	public static String getCurrentTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());
	}

	public static String getTimeAfterMonths(int month) {		
		var date = new Date();
		Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(date);
	    calendar.add(Calendar.MONTH, month);
	    date = calendar.getTime();

	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
}