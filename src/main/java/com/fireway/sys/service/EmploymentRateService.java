package com.fireway.sys.service;

import java.util.List;
import java.util.Map;


public interface EmploymentRateService {
	
	List<Map<String, Object>> statistics(String graduationYear);
	List<Map<String, Object>> selectGraduationYear();
	List<Map<String, Object>> selectRateByAcademy(String academy);
	
	
	
	

}
