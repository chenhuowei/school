package com.fireway.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/** 
     * 
     *  
     * @param pattern 
     *            default yyyy-MM-dd /time yyyy-MM-dd HH:mm:ss
     * @param  
     * @return 
     */  
	
	public static String dateFormat(String pattern,Date date){
		if (StringUtils.isBlank(pattern)){
			pattern = "yyyy-MM-dd";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String sd = simpleDateFormat.format(date);
		return sd;
	}
	
	public static Date dateParse(String pattern,String date){
		if (StringUtils.isBlank(pattern)){
			pattern = "yyyy-MM-dd";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		try {
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public static String dateTimeFormat(String pattern,Date date){
		if (StringUtils.isBlank(pattern)){
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String sd = simpleDateFormat.format(date);
		return sd;
	}
	
	public static Date dateParseTime(String pattern,String date){
		if (StringUtils.isBlank(pattern)){
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		try {
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
