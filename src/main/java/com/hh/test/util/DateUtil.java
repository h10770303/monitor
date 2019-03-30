package com.hh.test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author smg
 *
 */
public class DateUtil {
	
	/**
	 * date to String  yyyy-MM-dd 格式
	 * @param ms
	 */
	public static String dateToString(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	/**
	 * date to String  yyyy-MM-dd HH:mm:ss 格式
	 * @param ms
	 */
	public static String dateTimeToString(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	public static Date stringToDateTime(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(date);
	}
	
	/**
	 * 根据日期获取星期几
	 * @param startDt
	 * @return
	 */
	public static int getWeekDay(String startDt) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		try {
			Date date=sdf.parse(startDt);
			cal.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal.get(Calendar.DAY_OF_WEEK)-1;
	}
	
	public static void main(String[] args) {
		
		System.out.println(DateUtil.getWeekDay("2018-11-05"));
	}

}
