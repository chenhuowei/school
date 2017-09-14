/**
 * Project Name:ManWayCRM
 * File Name:LoggingUtil.java
 * Package Name:com.manway.util
 * Date:2016年6月2日下午4:03:05
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.fireway.utils;

import org.apache.log4j.Logger;

/**
 * ClassName:LoggingUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年6月2日 下午4:03:05 <br/>
 * @author   chenhuowei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class LogUtil {
	
	private static Logger logger = null;
	
	public static void info(Class clazz,Object message){
		
		logger = Logger.getLogger(clazz);
		logger.info("============="+clazz.getName());
		logger.info("*************"+message);
	}
	
	public static void debug(Class clazz,Object message){
		
		logger = Logger.getLogger(clazz);
		logger.debug("&&&&&&&&&&&&&&&"+message);
	}
	
	
	
	
	
	

}
