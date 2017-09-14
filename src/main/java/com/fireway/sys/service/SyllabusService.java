package com.fireway.sys.service;

import java.util.List;

import com.fireway.entity.Location;
import com.fireway.entity.SubjectArrangement;
import com.fireway.entity.Syllabus;
import com.fireway.entity.SyllabusExample;
import com.fireway.utils.PageBean;

public interface SyllabusService {

	void autoLayoutCourse(String schoolYear,String term,
			List<SubjectArrangement> subjectArrangements,List<Location> locations);
	
	void save(Syllabus record);
	void deleteById(String id);
	void deleteByExample(SyllabusExample example);
	void updateSelectById(Syllabus record);
	void updateById(Syllabus record);
	void updateByExample(Syllabus record,SyllabusExample example);
	
	List<Syllabus> findByExample(SyllabusExample example);
	
	PageBean<Syllabus> findByPage(int page,int limit,SyllabusExample example);
	
}
