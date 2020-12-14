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

	public static String getTimeAfterMonths(String curTime, int month) {
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			date = df.parse(curTime);
		} catch (Exception e) {
			date = new Date();
		}

		Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(date);
	    calendar.add(Calendar.MONTH, month);
	    date = calendar.getTime();

		return df.format(date);
	}

	// 校验填入的日期是否合法
	public static boolean checkInputDate(int year, int month, int day) {
		if (year <= 0 || month <= 0 || month > 12 || day > 31 || day <= 0) return false;
		if (day <= 28) return true;
		
		int[] regularDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		if (month != 2) {
			if (day != regularDay[day-1]) return false;
			return true;
		}

		// 闰年
		if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
			if (day == 29) return true;
			return false;
		}

		return day == 28;
	}
	
	public static int getTheEndDay(int year, int month) {
		if (year <= 0 || month <= 0 || month > 12) return 0;

		if (month != 2) {
			int[] regularDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			return regularDay[month-1];
		}

		// 闰年
		if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
			return 29;
		}

		return 28;
	}
}