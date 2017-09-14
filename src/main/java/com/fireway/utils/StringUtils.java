package com.fireway.utils;

public class StringUtils {

	 public static boolean isBlank(String str)
	    {
	        if (str == null || str.trim().length() == 0)
	        {
	            return true;
	        }
	        
	        return false;
	    }
	 
	 public static boolean isNotBlank(String str)
	 {
		 if (str == null || str.trim().length() == 0)
		 {
			 return false;
		 }
		 
		 return true;
	 }
	 
	 public static String addLikeStr(String str){
		 
		 return "%"+str+"%";
	 }
	 
	 public static boolean toEquals(String fixString, String string){
		 
		 try {
			if (null != fixString && null != string){
				
				return fixString.equals(string);
			}
		} catch (Exception e) {
		}
		 
		 
		 return false;
	 }
}
