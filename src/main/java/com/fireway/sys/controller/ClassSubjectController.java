package com.fireway.sys.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.base.BaseController;
import com.fireway.entity.ClassSubject;
import com.fireway.sys.service.ClassSubjectService;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
@RequestMapping("/classSubject")
public class ClassSubjectController implements BaseController<ClassSubject> {

	@Resource
	private ClassSubjectService classSubjectService;
	
	@RequestMapping("/classSubjectPage.do")
	public String toPage() {
		
		return "admin/classSubjectPage";
	}

	@ResponseBody
	@RequestMapping(value="save.do",method=RequestMethod.POST)
	public Object save(ClassSubject record) {
		try {
			record.setId(Utils.uuid());
			classSubjectService.save(record);
			return jsonUtil.saveSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.saveSuccess(false);
	}

	public Object delete(String ids) {
		
		return null;
	}

	public Object update(ClassSubject record) {
		
		return null;
	}

	public Object findById(String id) {
		
		return null;
	}

	public Object isRepeat(String key) {
		
		return null;
	}

}
