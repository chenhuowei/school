package com.fireway.sys.service;

import java.util.List;

import com.fireway.entity.StudentTest;
import com.fireway.entity.StudentTestExample;
import com.fireway.utils.PageBean;

public interface StudentTestService {
	
	void save(StudentTest record);
	
	void delete(String testRecordId,String studentId);
	
	void updateByExample(StudentTest record,StudentTestExample example);
	void updateById(StudentTest record);

	List<StudentTest> findByExample(StudentTestExample example);
	
	PageBean<StudentTest> findByPage(int page,int limit,StudentTestExample example);
	
}
