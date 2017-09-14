package com.fireway.sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.SubjectArrangementMapper;
import com.fireway.entity.SubjectArrangement;
import com.fireway.entity.SubjectArrangementExample;
import com.fireway.sys.service.SubjectArrangementService;
import com.fireway.utils.PageBean;
import com.github.pagehelper.PageHelper;

@Service("subjectArrangementService")
public class SubjectArrangementServiceImpl implements SubjectArrangementService {

	@Resource
	private SubjectArrangementMapper subjectArrangementMapper;
	
	
	public void save(SubjectArrangement record) {
		subjectArrangementMapper.insert(record);
	}

	public void delete(String id) {
		subjectArrangementMapper.deleteByPrimaryKey(id);
	}

	public void updateSelectById(SubjectArrangement record) {
		subjectArrangementMapper.updateByPrimaryKeySelective(record);
	}

	public void updateById(SubjectArrangement record) {
		subjectArrangementMapper.updateByPrimaryKey(record);
	}

	public SubjectArrangement findById(String id) {

		return subjectArrangementMapper.selectByPrimaryKey(id);
	}

	public boolean isRepeat(String key) {

		return false;
	}

	public void updateByExample(SubjectArrangement record, SubjectArrangementExample example) {
		subjectArrangementMapper.updateByExample(record, example);
	}

	public void updateSelectByExample(SubjectArrangement record, SubjectArrangementExample example) {
		subjectArrangementMapper.updateByExampleSelective(record, example);
	}

	public List<SubjectArrangement> findByExample(SubjectArrangementExample example) {

		return subjectArrangementMapper.selectByExample(example);
	}

	public PageBean<SubjectArrangement> findByPage(int page, int limit, SubjectArrangementExample example) {
		PageHelper.startPage(page, limit);
		List<SubjectArrangement> list = findByExample(example);
		return new PageBean<SubjectArrangement>(list);
	}

	public PageBean<SubjectArrangement> findByPage(int page, int limit) {
		PageHelper.startPage(page, limit);
		List<SubjectArrangement> list = subjectArrangementMapper.selectByPage();
		return new PageBean<SubjectArrangement>(list);
	}

	public List<Map<String, String>> selectByClassId(String classId, String schoolYear, 
			String term,String teacherId) {
		
		return subjectArrangementMapper.selectByClassId(classId, schoolYear, term,teacherId);
	}

}
