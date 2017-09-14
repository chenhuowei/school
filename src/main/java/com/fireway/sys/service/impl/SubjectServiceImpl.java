package com.fireway.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.SubjectMapper;
import com.fireway.entity.Subject;
import com.fireway.entity.SubjectExample;
import com.fireway.sys.service.SubjectService;
import com.fireway.utils.PageBean;
import com.fireway.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.sun.javafx.collections.MappingChange.Map;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

	@Resource
	private SubjectMapper subjectMapper;
	
	public void save(Subject record) {
		subjectMapper.insertSelective(record);
	}

	public void delete(String id) {
		subjectMapper.deleteByPrimaryKey(id);
	}

	public void updateSelectById(Subject record) {
		subjectMapper.updateByPrimaryKeySelective(record);
	}

	public void updateById(Subject record) {
		subjectMapper.updateByPrimaryKey(record);
	}

	public Subject findById(String id) {

		return subjectMapper.selectByPrimaryKey(id);
	}

	public void deleteByExample(SubjectExample example) {
	}

	public void updateSelectByExample(Subject record, SubjectExample example) {
		subjectMapper.updateByExampleSelective(record, example);
	}

	public void updateByExample(Subject record, SubjectExample example) {
	}

	public List<Subject> findByExample(SubjectExample example) {
		
		return subjectMapper.selectByExample(example);
	}

	public PageBean<Subject> findByPage(int page,int limit,SubjectExample example) {
		PageHelper.startPage(page,limit);
		List<Subject> list = findByExample(example);
		return new PageBean<Subject>(list);
	}

	public boolean isRepeat(String key) {
		if (StringUtils.isNotBlank(key)){
			SubjectExample example = new SubjectExample();
			example.createCriteria().andCodeEqualTo(key);
			int count = subjectMapper.countByExample(example);
			if (count == 0){
				return false;
			}
		}
		return true;
	}

	public List<Map<String, String>> findIdAndNameByCategory(String category) {
		
		return subjectMapper.findIdAndNameByCategory(category);
	}

}
