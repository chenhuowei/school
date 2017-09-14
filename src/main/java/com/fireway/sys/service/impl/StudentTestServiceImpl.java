package com.fireway.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.StudentTestMapper;
import com.fireway.entity.StudentTest;
import com.fireway.entity.StudentTestExample;
import com.fireway.sys.service.StudentTestService;
import com.fireway.utils.PageBean;
import com.github.pagehelper.PageHelper;

@Service("studentTestService")
public class StudentTestServiceImpl implements StudentTestService {

	@Resource
	private StudentTestMapper studentTestMapper;

	public void save(StudentTest record) {
		studentTestMapper.insert(record);
	}

	public void delete(String testRecordId, String studentId) {
		StudentTestExample example = new StudentTestExample();
		example.createCriteria().andStudentIdEqualTo(studentId)
			.andTestRecordIdEqualTo(testRecordId);
		studentTestMapper.deleteByExample(example);
	}

	public void updateByExample(StudentTest record, StudentTestExample example) {
		studentTestMapper.updateByExampleSelective(record, example);
	}

	public List<StudentTest> findByExample(StudentTestExample example) {
		
		return studentTestMapper.selectByExample(example);
	}

	public PageBean<StudentTest> findByPage(int page, int limit, StudentTestExample example) {
		PageHelper.startPage(page, limit);
		List<StudentTest> list = findByExample(example);
		return new PageBean<StudentTest>(list);
	}

	public void updateById(StudentTest record) {
		studentTestMapper.updateByPrimaryKeySelective(record);
	}
	
	

}
