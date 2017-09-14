package com.fireway.sys.service;

import java.util.List;
import java.util.Map;

import com.fireway.entity.GradeSchoolYear;

public interface GradeSchoolYearService {

	void save(GradeSchoolYear record);
	
	void deleteByGade(String grade);
	
	List<Map<String, String>> findByGrade(String grade);
	
	
}
