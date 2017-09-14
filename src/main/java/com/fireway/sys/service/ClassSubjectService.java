package com.fireway.sys.service;

import java.util.List;

import com.fireway.base.BaseService;
import com.fireway.entity.ClassSubject;
import com.fireway.entity.ClassSubjectExample;
import com.fireway.utils.PageBean;

public interface ClassSubjectService extends BaseService<ClassSubject> {

	void updateByExample(ClassSubject record,ClassSubjectExample example);
	void updateSelectByExample(ClassSubject record,ClassSubjectExample example);
	List<ClassSubject> findByExample(ClassSubjectExample example);
	void deleteByExample(String classId,String subjectArrangementId);
	PageBean<ClassSubject> findByPage(int page,int limit,ClassSubjectExample example);

}
