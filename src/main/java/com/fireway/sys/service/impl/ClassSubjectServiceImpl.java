package com.fireway.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.ClassSubjectMapper;
import com.fireway.entity.ClassSubject;
import com.fireway.entity.ClassSubjectExample;
import com.fireway.entity.ClassSubjectExample.Criteria;
import com.fireway.sys.service.ClassSubjectService;
import com.fireway.utils.PageBean;
import com.fireway.utils.StringUtils;
import com.github.pagehelper.PageHelper;

@Service("classSubjectService")
public class ClassSubjectServiceImpl implements ClassSubjectService {

	@Resource
	private ClassSubjectMapper classSubjectMapper;

	public void save(ClassSubject record) {
		classSubjectMapper.insert(record);
	}

	public void delete(String id) {
		classSubjectMapper.deleteByPrimaryKey(id);
	}

	public void updateSelectById(ClassSubject record) {
		classSubjectMapper.updateByPrimaryKeySelective(record);
	}

	public void updateById(ClassSubject record) {
		classSubjectMapper.updateByPrimaryKey(record);
	}

	public ClassSubject findById(String id) {
		
		return classSubjectMapper.selectByPrimaryKey(id);
	}

	public boolean isRepeat(String key) {
		
		return false;
	}

	public void updateByExample(ClassSubject record, ClassSubjectExample example) {
		
	}

	public void updateSelectByExample(ClassSubject record, ClassSubjectExample example) {
		classSubjectMapper.updateByExampleSelective(record, example);
	}

	public List<ClassSubject> findByExample(ClassSubjectExample example) {
		
		return classSubjectMapper.selectByExample(example);
	}

	public PageBean<ClassSubject> findByPage(int page, int limit, ClassSubjectExample example) {
		PageHelper.startPage(page, limit);
		List<ClassSubject> list = findByExample(example);
		
		return new PageBean<ClassSubject>(list);
	}

	public void deleteByExample(String classId,String subjectArrangementId) {
		ClassSubjectExample example = new ClassSubjectExample();
		Criteria criteria  = example.createCriteria();
		if(StringUtils.isNotBlank(classId)){
			criteria.andClassIdEqualTo(classId);
		}
		if(StringUtils.isNotBlank(subjectArrangementId)){
			criteria.andSubjectArrangementIdEqualTo(subjectArrangementId);
		}
		classSubjectMapper.deleteByExample(example);
	}
	
	
	

}
