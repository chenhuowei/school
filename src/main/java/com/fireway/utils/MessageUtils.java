package com.fireway.utils;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.fireway.entity.ChatRecord;

public class MessageUtils {

	public static Map<String, String> getUserNMessage(String message) {
		Map<String, String> map = new HashMap<String, String>();
		int index = message.indexOf("@");
		String user  = message.substring(0, index);
		String msg  = message.substring(index+1);
		String[] users = user.split(",");
		if(users.length == 2){
			map.put("userId", users[0]);
			map.put("userName", users[1]);
		}
		map.put("message", msg);
		map.put("userMessage", users[1]+": "+msg);
		return map;
	}
	
	
	
	
	
	
}
