package com.fireway.base;

public interface BaseController<T> {

	String toPage();
	
	Object save(T record);
	
	Object delete(String ids);
	
	Object update(T record);
	
	Object findById(String id);
	
	Object isRepeat(String key);

}
