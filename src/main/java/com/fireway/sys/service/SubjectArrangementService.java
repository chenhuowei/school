package com.fireway.sys.service;

import java.util.List;
import java.util.Map;

import com.fireway.base.BaseService;
import com.fireway.entity.SubjectArrangement;
import com.fireway.entity.SubjectArrangementExample;
import com.fireway.utils.PageBean;

public interface SubjectArrangementService extends BaseService<SubjectArrangement> {

	void updateByExample(SubjectArrangement record,SubjectArrangementExample example);
	void updateSelectByExample(SubjectArrangement record,SubjectArrangementExample example);
	List<SubjectArrangement> findByExample(SubjectArrangementExample example);
	
	PageBean<SubjectArrangement> findByPage(int page,int limit,SubjectArrangementExample example);
	
	PageBean<SubjectArrangement> findByPage(int page,int limit);
	
	List<Map<String, String>> selectByClassId(String classId,String schoolYear,
			String term,String teacherId);
}
