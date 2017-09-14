package com.fireway.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.TeacherMapper;
import com.fireway.entity.Teacher;
import com.fireway.entity.TeacherExample;
import com.fireway.request.dto.SearchParam;
import com.fireway.user.service.TeacherService;
import com.fireway.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.sun.javafx.collections.MappingChange.Map;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

	@Resource
	private TeacherMapper teacherMapper;
	
	public void save(Teacher record) {
		teacherMapper.insert(record);
	}

	public void delete(String id) {
		teacherMapper.deleteByPrimaryKey(id);
	}

	public void updateById(Teacher record) {
		teacherMapper.updateByPrimaryKey(record);
		
	}

	public Teacher findById(String id) {

		
		return teacherMapper.selectByPrimaryKey(id);
	}

	public void deleteByExample(TeacherExample example) {
		teacherMapper.deleteByExample(example);
	}

	public void updateByExample(Teacher record,TeacherExample example) {
		teacherMapper.updateByExampleSelective(record, example);
	}

	public List<Teacher> findByExample(TeacherExample example) {

		return teacherMapper.selectByExample(example);
	}

	public PageBean<Teacher> findByPage(int page, int limit, TeacherExample example) {

		PageHelper.startPage(page, limit);
		List<Teacher> list = findByExample(example);
		
		return new PageBean<Teacher>(list);
	}

	public boolean isRepeat(String key) {

		TeacherExample example = new TeacherExample();
		example.createCriteria().andTeacherNumEqualTo(key);
		List<Teacher> list = findByExample(example);
		if (list == null || list.size() <= 0){
			return false;
		}
		
		return true;
	}

	public void updateSelectById(Teacher record) {
		teacherMapper.updateByPrimaryKeySelective(record);
	}

	public PageBean<Teacher> findBySearchParam(int page, int limit, SearchParam searchParam) {
		PageHelper.startPage(page, limit);
		List<Teacher> list = teacherMapper.selectBySearchParam(searchParam);
		return new PageBean<Teacher>(list);
	}

	public List<Map<String, String>> findIdAndNameByAcademy(String academyId) {
		
		return teacherMapper.findIdAndNameByAcademy(academyId);
	}

	public Teacher findTeacherByNum(String teacherNum) {
		TeacherExample example = new TeacherExample();
		example.createCriteria().andTeacherNumEqualTo(teacherNum);
		List<Teacher> list = teacherMapper.selectByExample(example);
		if (null != list && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

}
