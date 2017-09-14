package com.fireway.base;

public interface BaseService<T> {

	void save(T record);
	
	void delete(String id);
	
	void updateSelectById(T record);
	void updateById(T record);
	
	T findById(String id);
	
	boolean isRepeat(String key);
	
}
