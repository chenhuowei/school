package com.fireway.sys.service;

import java.util.List;

import com.fireway.base.BaseService;
import com.fireway.entity.Subject;
import com.fireway.entity.SubjectExample;
import com.fireway.utils.PageBean;
import com.sun.javafx.collections.MappingChange.Map;

public interface SubjectService extends BaseService<Subject> {

	void deleteByExample(SubjectExample example);
	void updateSelectByExample(Subject record,SubjectExample example);
	void updateByExample(Subject record,SubjectExample example);
	List<Subject> findByExample(SubjectExample example);
	PageBean<Subject> findByPage(int page,int limit ,SubjectExample example);
	
	List<Map<String, String>> findIdAndNameByCategory(String category);
}
