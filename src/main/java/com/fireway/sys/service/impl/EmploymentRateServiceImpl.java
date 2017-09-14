package com.fireway.sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.EmploymentRateMapper;
import com.fireway.entity.EmploymentRateExample;
import com.fireway.sys.service.EmploymentRateService;

@Service("employmentRate")
public class EmploymentRateServiceImpl implements EmploymentRateService {

	@Resource
	private EmploymentRateMapper employmentRateMapper;
	
	public List<Map<String, Object>> statistics(String graduationYear) {

		return employmentRateMapper.statistics(graduationYear);
	}

	public List<Map<String, Object>> selectGraduationYear() {
		
		return employmentRateMapper.selectGraduationYear();
	}

	public List<Map<String, Object>> selectRateByAcademy(String academy) {
		
		return employmentRateMapper.selectRateByAcademy(academy);
	}

}
