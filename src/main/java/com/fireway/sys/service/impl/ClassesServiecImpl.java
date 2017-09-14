package com.fireway.sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.ClassesMapper;
import com.fireway.entity.Classes;
import com.fireway.entity.ClassesExample;
import com.fireway.sys.service.ClassesService;
import com.fireway.utils.PageBean;
import com.github.pagehelper.PageHelper;

@Service("classesService")
public class ClassesServiecImpl implements ClassesService {

	@Resource
	private ClassesMapper classesMapper;
	
	public void saveClasses(Classes record) {
		classesMapper.insert(record);
	}

	public void deleteyId(String id) {
		classesMapper.deleteByPrimaryKey(id);
	}

	public void deleteByExample(ClassesExample example) {
		classesMapper.deleteByExample(example);
	}

	public void updateByExample(Classes record, ClassesExample example) {
		classesMapper.updateByExampleSelective(record, example);
	}

	public List<Classes> findByExample(ClassesExample example) {

		return classesMapper.selectByExample(example);
	}

	public Classes findById(String id) {

		return classesMapper.selectByPrimaryKey(id);
	}

	public PageBean<Classes> findByPage(int page, int limit, ClassesExample example) {

		PageHelper.startPage(page, limit);
		List<Classes> list = findByExample(example);
		return new PageBean<Classes>(list);
	}

	public boolean isRepeat(String name) {

		return false;
	}

	public int countByExample(ClassesExample example) {
		
		return classesMapper.countByExample(example);
	}

	public List<Map<String, String>> findIdAndName(int page, int limit, ClassesExample example) {
		PageHelper.startPage(page, limit);
		List<Map<String, String>> list = classesMapper.selectIdAndName(example);
		return list;
	}

	public PageBean<Classes> findByTeacher(int page, int limit, String teacherNum) {
		PageHelper.startPage(page, limit);
		List<Classes> list = classesMapper.findByTeacher(teacherNum);
		return new PageBean<Classes>(list);
	}

}
