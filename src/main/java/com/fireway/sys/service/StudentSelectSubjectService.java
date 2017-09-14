package com.fireway.sys.service;


import java.util.List;

import com.fireway.entity.StudentSelectSubject;
import com.fireway.entity.StudentSelectSubjectExample;
import com.fireway.utils.PageBean;

public interface StudentSelectSubjectService {
	
	
	
	void save(StudentSelectSubject studentSelectSubject);
	
	void delete(StudentSelectSubject studentSelectSubject);
	
	void deleteByExample(StudentSelectSubjectExample example);
	
	int countByExample(StudentSelectSubjectExample example);
	
	List<StudentSelectSubject> findByStudentId(String studentId); 
	List<StudentSelectSubject>  findByExample(StudentSelectSubjectExample example); 
	PageBean<StudentSelectSubject>  findByPage(int page,int limit,StudentSelectSubjectExample example); 

}
