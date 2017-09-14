package com.fireway.sys.service;

import java.util.List;
import java.util.Map;

import com.fireway.base.BaseService;
import com.fireway.entity.Location;
import com.fireway.entity.SelectSubject;
import com.fireway.entity.SelectSubjectExample;
import com.fireway.utils.PageBean;

public interface SelectSubjectService extends BaseService<SelectSubject> {

	void updateByExample(SelectSubject record,SelectSubjectExample example);
	void updateSelectByExample(SelectSubject record,SelectSubjectExample example);
	List<SelectSubject> findByExample(SelectSubjectExample example);
	
	PageBean<SelectSubject> findByPage(int page,int limit,SelectSubjectExample example);
	void autoLayout(String[] classWeek,String classTime,
			List<SelectSubject> selectSubjects,List<Location> locations);
	
	void deleteLayout(boolean sure,List<SelectSubject> selectSubjects);
	
	List<SelectSubject> selectByStudentId(String studentId,String schoolYear,String term);
	
	List<SelectSubject> selectByTeacherId(String teacherId,String schoolYear,String term);
	List<Map<String ,String>> selectByIdAndName(String teacherId,String schoolYear,String term);
	
	PageBean<SelectSubject> selectByStudentIdAndPage(int page,int limit,String studentId,String schoolYear,String term);
}
