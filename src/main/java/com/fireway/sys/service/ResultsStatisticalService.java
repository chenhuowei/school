package com.fireway.sys.service;

import java.util.List;

import com.fireway.entity.ResultsStatistical;
import com.fireway.entity.ResultsStatisticalExample;

public interface ResultsStatisticalService {

	List<ResultsStatistical> findByStudentId(int page,int limit,String studentId,String schoolYear,
			Integer term,String keyWord);
	
	List<ResultsStatistical> findByExample(ResultsStatisticalExample example
			);
	
	void save(ResultsStatistical record);
	
	void deleteByExample(ResultsStatisticalExample example);
	
	void saveAndReset(String schoolYear,Integer term ,String studentId);
	
}
