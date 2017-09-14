package com.fireway.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.StudentSelectSubjectMapper;
import com.fireway.entity.StudentSelectSubject;
import com.fireway.entity.StudentSelectSubjectExample;
import com.fireway.sys.service.StudentSelectSubjectService;
import com.fireway.utils.PageBean;
import com.fireway.utils.StringUtils;
import com.github.pagehelper.PageHelper;

@Service("studentSelectSubjectService")
public class StudentSelectSubjectServiceImpl implements StudentSelectSubjectService {

	@Resource
	private StudentSelectSubjectMapper studentSelectSubjectMapper;
	
	public void save(StudentSelectSubject record) {
		studentSelectSubjectMapper.insert(record);
	}

	public void deleteByExample(StudentSelectSubjectExample example) {
		studentSelectSubjectMapper.deleteByExample(example);
	}

	public List<StudentSelectSubject>  findByStudentId(String studentId) {
		StudentSelectSubjectExample example = new StudentSelectSubjectExample();
		
		if (StringUtils.isNotBlank(studentId)){
			example.createCriteria().andStudentIdEqualTo(studentId);
			return findByExample(example);
		}
		return null;
	}

	public List<StudentSelectSubject>  findByExample(StudentSelectSubjectExample example) {
		return studentSelectSubjectMapper.selectByExample(example);
	}

	public PageBean<StudentSelectSubject>  findByPage(int page, int limit, StudentSelectSubjectExample example) {
		PageHelper.startPage(page, limit);
		List<StudentSelectSubject> list = findByExample(example);
		return new PageBean<StudentSelectSubject>(list);
	}

	public void delete(StudentSelectSubject studentSelectSubject) {
		StudentSelectSubjectExample example = new StudentSelectSubjectExample();
		example.createCriteria().andStudentIdEqualTo(studentSelectSubject.getStudentId())
			.andSelectSubjectIdEqualTo(studentSelectSubject.getSelectSubjectId());
		studentSelectSubjectMapper.deleteByExample(example);
	}

	public int countByExample(StudentSelectSubjectExample example) {
		
		return studentSelectSubjectMapper.countByExample(example);
	}

	

}
