package com.fireway.sys.service;

import java.util.List;
import java.util.Map;

import com.fireway.entity.Dictionary;
import com.fireway.entity.DictionaryExample;
import com.fireway.utils.PageBean;

public interface DictionaryService {

	void save(Dictionary record);
	
	void deleteById(String id);
	
	Dictionary findById(String id);
	void updateByExample(Dictionary record,DictionaryExample example);
	List<Dictionary> findByExample(DictionaryExample example);
	
	PageBean<Dictionary> findByPage(int page, int limit, DictionaryExample example);
	
	List<Map<String, String>> findByType(int page,int limit,String type);
	
	List<Map<String, String>> findTreeList(String type);
}
