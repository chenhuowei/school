package com.fireway.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.StudentMapper;
import com.fireway.entity.Student;
import com.fireway.entity.StudentExample;
import com.fireway.request.dto.SearchParam;
import com.fireway.user.service.StudentService;
import com.fireway.utils.PageBean;
import com.github.pagehelper.PageHelper;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentMapper studentMapper;
	
	public void save(Student record) {
		studentMapper.insert(record);
	}

	public void delete(String id) {
		studentMapper.deleteByPrimaryKey(id);
	}

	public void updateSelectById(Student record) {
		studentMapper.updateByPrimaryKeySelective(record);
	}

	public void updateById(Student record) {
		studentMapper.updateByPrimaryKey(record);
	}

	public Student findById(String id) {
		
		return studentMapper.selectByPrimaryKey(id);
	}

	public void deleteByExample(StudentExample example) {
		studentMapper.deleteByExample(example);
	}

	public void updateSelectByExample(Student record, StudentExample example) {
		studentMapper.updateByExampleSelective(record, example);
	}

	public void updateByExample(Student record, StudentExample example) {
		studentMapper.updateByExample(record, example);
	}

	public List<Student> findByExample(StudentExample example) {
		
		return studentMapper.selectByExample(example);
	}

	public PageBean<Student> findByPage(int page, int limit, StudentExample example) {
		PageHelper.startPage(page, limit);
		List<Student> list = findByExample(example);
		
		return new PageBean<Student>(list);
	}

	public PageBean<Student> findBySearchParam(int page, int limit, SearchParam searchParam) {
		PageHelper.startPage(page, limit);
		List<Student> list = studentMapper.selectBySearchParam(searchParam);
		
		return new PageBean<Student>(list);
	}

	public boolean isRepeat(String key) {
		
		return false;
	}

	public PageBean<Student> findBySelectSubject(int page, int limit, SearchParam searchParam, String selectSubjectId) {
		PageHelper.startPage(page, limit);
		List<Student> list = studentMapper.findBySelectSubject(selectSubjectId);
		
		return new PageBean<Student>(list);
	}

	public Student findStudentByNum(String studentNum) {
		StudentExample example = new StudentExample();
		example.createCriteria().andStudentNumEqualTo(studentNum);
		List<Student> list = studentMapper.selectByExample(example);
		if (null != list && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

}
