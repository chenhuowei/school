/**
 * File Name:ContantsUtil.java
 * Package Name:com.manway.util
 * Date:2016年6月2日下午4:06:24
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.fireway.utils;

import java.util.HashMap;
import java.util.Map;


/**
 * ClassName:ContantsUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年6月2日 下午4:06:24 <br/>
 * @author   chenhuowei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class jsonUtil {
	
	private static  Map<String , Object> json = null;
	
	
	
	public static Map<String, Object> getMap(){
		json = new HashMap<String, Object>();
		return json;
	}
	
	public static Map<String, Object> newJson(String key,Object message) {
		json = new HashMap<String, Object>();
		json.put(key, message);
		return json;
	}
	
	public static Map<String, Object> asJson(boolean success,String message) {
		json = new HashMap<String, Object>();
		json.put("message", message);
		json.put("success", success);
		return json;
	}
	
	
	
	
	public static Map<String , Object> loadSuccess(boolean success){
		json = new HashMap<String, Object>();
		json.put("success", success);
		if (success){
			
			json.put("message", "加载数据成功");
		}else {
			
			json.put("message", "加载数据失败");
		}
		
		
		return json;
	}
	
	public static Map<String , Object> excelSuccess(boolean success){
		json = new HashMap<String, Object>();
		json.put("success", success);
		if (success){
			
			json.put("message", "导入数据成功");
		}else {
			
			json.put("message", "导入数据失败，请重新操作");
		}
		
		
		return json;
	}
	
	public static Map<String , Object> loadDataSuccess(boolean success,Object data){
		json = new HashMap<String, Object>();
		json.put("success", success);
		if (success){
			
			json.put("data", data);
		}else {
			
			json.put("message", "加载数据失败");
		}
		
		
		return json;
	}
	
	public static Map<String , Object> saveSuccess(boolean success){
		json = new HashMap<String, Object>();
		json.put("success", success);
		if (success){
			
			json.put("message", "保存成功");
		}else {
			
			json.put("message", "保存失败");
		}
		
		
		return json;
	}
	
	public static Map<String , Object> deleteSuccess(boolean success){
		json = new HashMap<String, Object>();
		json.put("success", success);
		if (success){
			
			json.put("message", "删除成功");
		}else {
			
			json.put("message", "删除失败");
		}
		
		
		return json;
	}
	
	public static  Map<String , Object> updateSuccess(boolean success){
		json = new HashMap<String, Object>();
		json.put("success", success);
		if (success){
			
			json.put("message", "更新成功");
		}else {
			
			json.put("message", "更新失败");
		}
		
		
		return json;
	}
	
	

}
