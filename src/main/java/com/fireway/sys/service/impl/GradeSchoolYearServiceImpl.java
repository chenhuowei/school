package com.fireway.sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.GradeSchoolYearMapper;
import com.fireway.entity.GradeSchoolYear;
import com.fireway.entity.GradeSchoolYearExample;
import com.fireway.sys.service.GradeSchoolYearService;

@Service("gradeSchoolYearService")
public class GradeSchoolYearServiceImpl implements GradeSchoolYearService {

	@Resource
	private GradeSchoolYearMapper gradeSchoolYearMapper;
	
	public void save(GradeSchoolYear record) {
		gradeSchoolYearMapper.insert(record);
	}

	public void deleteByGade(String grade) {
		
		GradeSchoolYearExample example = new GradeSchoolYearExample();
		example.createCriteria().andGradeEqualTo(grade);
		gradeSchoolYearMapper.deleteByExample(example);
		
	}

	public List<Map<String, String>> findByGrade(String grade) {
		
		return gradeSchoolYearMapper.selectByGrade(grade);
	}

}
