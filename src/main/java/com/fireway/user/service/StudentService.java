package com.fireway.user.service;

import java.util.List;

import com.fireway.base.BaseService;
import com.fireway.entity.Student;
import com.fireway.entity.StudentExample;
import com.fireway.request.dto.SearchParam;
import com.fireway.utils.PageBean;

public interface StudentService extends BaseService<Student>{

	void deleteByExample(StudentExample example);
	void updateSelectByExample(Student record,StudentExample example);
	void updateByExample(Student record,StudentExample example);
	List<Student> findByExample(StudentExample example);
	PageBean<Student> findByPage(int page,int limit, StudentExample example);
	
	PageBean<Student> findBySearchParam(int page,int limit, SearchParam searchParam);
	
	PageBean<Student> findBySelectSubject(int page,int limit, SearchParam searchParam,String selectSubjectId);
	
	Student findStudentByNum(String studentNum);
	
}
