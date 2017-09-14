package com.fireway.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.codec.binary.Base32InputStream;

public class BeanAndMapUtil {
	
	private static final String active = "激活";
	private static final String unuse = "失效";
	private static final String man = "男";
	private static final String woman = "女";
	private static final String sex = "sex";
	private static final String status = "status";
	
	private static Object b2s(String property ,Object value){
		if (!sex.equalsIgnoreCase(property) && !status.equalsIgnoreCase(property)){
			return value;
		}
		if (sex.equalsIgnoreCase(property)){
			if ((Boolean)value){
				return man;
			}else {
				return woman;
			}
		}else if (status.equalsIgnoreCase(property)) {
			if ((Boolean)value){
				return active;
			}else {
				return unuse;
			}
		}
		return value;
	}
	

	public static Map<String, Object> bean2Map(Object obj) { 
        Map<String, Object> params = new HashMap<String, Object>(0); 
        try { 
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean(); 
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj); 
            for (int i = 0; i < descriptors.length; i++) { 
                String name = descriptors[i].getName(); 
                if (!"class".equals(name)) { 
                	Object value =  b2s(name, propertyUtilsBean.getNestedProperty(obj, name));
                	if (null != value ){
                		params.put(name,value.toString()); 
                	}else {
						params.put(name, "");
					}
                } 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return params; 
}
	
	public static Object map2Bean(Map<String , Object> map,Object obj){
		 try {
			PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean(); 
			 PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj); 
			for (PropertyDescriptor property : descriptors){
				String key = property.getName();
				if (map.containsKey(key)) {  
			        Object value = map.get(key);
			       
			        // 得到property对应的setter方法  
			        Method setter = property.getWriteMethod(); 
			       if (property.getPropertyType() != Boolean.class
			    		   && property.getPropertyType() != Integer.class){
			    	   if (null != value){
			    		   setter.invoke(obj, value.toString());
			    	   }else {
			    		   setter.invoke(obj, "");
					}
			       }else if (property.getPropertyType() == Boolean.class) {
					if (sex.equalsIgnoreCase(key)){
						if (man.equalsIgnoreCase(value.toString())){
							setter.invoke(obj, true);
						}else {
							setter.invoke(obj, false);
						}
					}
					
					if (status.equalsIgnoreCase(key)){
						if (active.equalsIgnoreCase(value.toString())){
							setter.invoke(obj, true);
						}else {
							setter.invoke(obj, false);
						}
					}
					
				}else if (property.getPropertyType() == Integer.class) {
					setter.invoke(obj, Integer.parseInt(value.toString()));
				}
			   }  
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return obj;
	}
	
	
	
	
	public<T> List<Map<String , Object>> listMap(List<T> list){
		List<Map<String , Object>> listMap = new ArrayList<Map<String , Object>>(0);
		if (null != list && list.size() > 0){
			
			for (T o : list){
				
				listMap.add(bean2Map(o));
			}
		}
		
		
		
		return listMap;
	}
	
	
	
	
	
	

}
