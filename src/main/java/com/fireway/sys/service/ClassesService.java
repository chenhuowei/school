package com.fireway.sys.service;

import java.util.List;
import java.util.Map;

import com.fireway.entity.Classes;
import com.fireway.entity.ClassesExample;
import com.fireway.utils.PageBean;

public interface ClassesService {

	void saveClasses(Classes record);
	
	void deleteyId(String id);
	
	void deleteByExample(ClassesExample example);
	
	void updateByExample(Classes record, ClassesExample example);
	
	List<Classes> findByExample(ClassesExample example);
	
	Classes findById(String id);
	
	PageBean<Classes> findByPage(int page, int limit,ClassesExample example);
	
	boolean isRepeat(String name);

	int countByExample(ClassesExample example);
	
	List<Map<String, String>> findIdAndName(int page,int limit,ClassesExample example);
	PageBean<Classes> findByTeacher(int page, int limit,String teacherNum);
	
}
