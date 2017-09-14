package com.fireway.sys.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.sys.service.ResultsStatisticalService;

@Controller
@RequestMapping("/resultsStatistical")
public class ResultsStatisticalController {

	@Resource
	private ResultsStatisticalService resultsStatisticalService;
	
	@ResponseBody
	@RequestMapping("/findByStudentId.do")
	public Object findByStudentId(int page,int limit,String studentId,String schoolYear,Integer term){
		
	
		
		return resultsStatisticalService.findByStudentId(page, limit, studentId, schoolYear, term, null);
	}
	
	
}
