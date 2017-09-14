package com.fireway.sys.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.entity.StudentSelectSubject;
import com.fireway.entity.StudentSelectSubjectExample;
import com.fireway.sys.service.SelectSubjectService;
import com.fireway.sys.service.StudentSelectSubjectService;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
@RequestMapping("/studentSelectSubject")
public class StudentSelectSubjectController {

	@Resource
	private StudentSelectSubjectService studentSelectSubjectService;
	@Resource
	private SelectSubjectService selectSubjectSerivce;
	
	
	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object sava(StudentSelectSubject record){
		try {
			record.setId(Utils.uuid());
			studentSelectSubjectService.save(record);
			return jsonUtil.saveSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.saveSuccess(true);
	}
	
	@ResponseBody
	@RequestMapping(value="/delete.do",method=RequestMethod.GET)
	public Object delete(StudentSelectSubject record){
		try {
			StudentSelectSubjectExample example = new StudentSelectSubjectExample();
			example.createCriteria().andStudentIdEqualTo(record.getStudentId())
				.andSelectSubjectIdEqualTo(record.getSelectSubjectId());
			studentSelectSubjectService.deleteByExample(example);
			return jsonUtil.deleteSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.deleteSuccess(false);
	}
	
	
	@ResponseBody
	@RequestMapping("/findByStudentId.do")
	public Object findByPage(int page,int limit,String studentId,
			@RequestParam(required=false)String schoolYear,@RequestParam(required=false)String term){
		
		
		return selectSubjectSerivce.selectByStudentIdAndPage(page, limit, studentId, schoolYear, term);
	}
	
	
	
	
	
	
	
}
