package com.fireway.user.service;

import java.util.List;

import com.fireway.base.BaseService;
import com.fireway.entity.Teacher;
import com.fireway.entity.TeacherExample;
import com.fireway.request.dto.SearchParam;
import com.fireway.utils.PageBean;
import com.sun.javafx.collections.MappingChange.Map;

public interface TeacherService extends BaseService<Teacher> {
	
	void deleteByExample(TeacherExample example);
	
	void updateByExample(Teacher record,TeacherExample example);
	
	List<Teacher> findByExample(TeacherExample example);
	
	PageBean<Teacher> findByPage(int page,int limit ,TeacherExample example);
	
	PageBean<Teacher> findBySearchParam(int page,int limit ,SearchParam searchParam);
	
	boolean isRepeat(String key);
	
	List<Map<String, String>> findIdAndNameByAcademy(String academyId);
	
	Teacher findTeacherByNum(String teacherNum);

}
