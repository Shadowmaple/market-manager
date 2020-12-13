package com.market.util;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Time {
	public String getCurrentTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());
	}
}