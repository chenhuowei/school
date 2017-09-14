package com.fireway.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.resource.spi.RetryableUnavailableException;


public class Utils {
	
	
	public static String  uuid() {
		
		return UUID.randomUUID().toString();
	}
	
	public static int getAge(String birth) throws Exception{
		
		int age = 0;
		if (StringUtils.isNotBlank(birth)){
			
			
			String sYear = birth.substring(0, 4);
			int bYear = Integer.parseInt(sYear);
			LocalDate today = LocalDate.now(); 
			int nYear = today.getYear();
			age = nYear - bYear;
		}
		
		return age;
	}
	
	public static double scoreToPoint(Double totalScore) {
		
			if (totalScore < 60){
				return 0.00;
			}else {
				double num =  (Double)totalScore/10.00-5;
				return Double.parseDouble(new java.text.DecimalFormat("#.00").format(num));
			}
		
				
	}
	
	public static double countTotalScoreByScale(String scoreScale,Double commonScore,Double testScore){
		try {
			if (StringUtils.isNotBlank(scoreScale)){
				String[] scale = scoreScale.split("[:：]");
				double score =  (Integer.parseInt(scale[0])*testScore+Integer.parseInt(scale[1])*commonScore)/10;
				if (score%(int)score==0){
					return score;
				}else {
					return (int)score+1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static  Map<String, String> getSchoolYearAndTermAtNow(){
		Map<String, String> map = new HashMap<String, String>();
		String date = DateUtil.dateFormat("yyyy-MM", new Date());
		String[] yearTerm = date.split("-");
		int year = Integer.parseInt(yearTerm[0]);
		int month = Integer.parseInt(yearTerm[1]);
		
		if (month+1 >=8){
			map.put("schoolYear", year+"-"+(year+1));
			map.put("term", "1");
		}else {
			map.put("schoolYear", (year-1)+"-"+year);
			map.put("term", "2");
		}
		
		return map;
		
	}
	
	
	public static  String getSchoolYearAtNow(){
		String date = DateUtil.dateFormat("yyyy-MM", new Date());
		String[] yearTerm = date.split("-");
		int year = Integer.parseInt(yearTerm[0]);
		int month = Integer.parseInt(yearTerm[1]);
		if (month+1 >=8){
			return year+"-"+(year+1);
		}else {
			return (year-1)+"-"+(year);
		}
		
		
		
	}
	
	public static  Integer getTermAtNow(){
		String date = DateUtil.dateFormat("yyyy-MM", new Date());
		String[] yearTerm = date.split("-");
		int month = Integer.parseInt(yearTerm[1]);
		if (month+1 >=8){
			return 1;
		}else {
			return 2;
		}
		
		
		
	}
	
	public static List<String> getSchoolYearByGrade(String grade){
		List<String> list = null;
		if (StringUtils.isNotBlank(grade)){
			list = new ArrayList<String>();
			int now = Integer.parseInt(grade);
			int next = now+1;
			
				for (int i = 0; i < 4; i++) {
					list.add(now+"-"+next);
					now++;
					next++;
				}
		}
		return list;
	}
	
	
	

}
