package com.fireway.sys.service;

import java.util.List;
import java.util.Map;

import com.fireway.entity.Academy;
import com.fireway.entity.AcademyExample;
import com.fireway.utils.PageBean;

public interface AcademyService {

	void saveAcademy(Academy a);
	
	void deleteyId(String id);
	
	void deleteByExample(AcademyExample example);
	
	void updateByExample(Academy a, AcademyExample example);
	
	List<Academy> findByExample(AcademyExample example);
	
	Academy findById(String id);
	
	PageBean<Academy> findByPage(int page, int rows,AcademyExample example);
	
	boolean isRepeat(String code);
	
	List<Map<String, String>> findIdnName(int page,int limit,AcademyExample example);
	
	List<Map<String, String>> findTreeList(AcademyExample example);
	
	
	
}
