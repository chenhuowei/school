package com.fireway.sys.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fireway.entity.Academy;
import com.fireway.entity.AcademyExample;
import com.fireway.entity.Classes;
import com.fireway.entity.ClassesExample;
import com.fireway.entity.ClassesExample.Criteria;
import com.fireway.sys.service.AcademyService;
import com.fireway.sys.service.ClassesService;
import com.fireway.utils.DateUtil;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
public class ClassesController {

	@Resource
	private ClassesService classesService;
	@Resource
	private AcademyService academyService;
	
	@RequestMapping("/classes/classesPage.do")
	public String toPage() {
		
		return "admin/classesPage";
	}

	@ResponseBody
	@RequestMapping(value="/classes/save.do",method=RequestMethod.POST)
	public Object save(Classes t) {
		try {
			
			t.setId(Utils.uuid());
			t.setCreateTime(DateUtil.dateTimeFormat(null, new Date()));
			t.setName(t.getGrade().substring(2, 4)+t.getNumber());
			
			Academy a = academyService.findById(t.getAcademyId());
			int acount = countClass(t.getAcademyId());
			a.setClassAmount(acount+1);
			AcademyExample example = new AcademyExample();
			example.createCriteria().andIdEqualTo(t.getAcademyId());
			academyService.updateByExample(a, example);
			
			classesService.saveClasses(t);
			return jsonUtil.saveSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.saveSuccess(false);
	}

	@ResponseBody
	@RequestMapping(value="/classes/delete.do",method=RequestMethod.POST)
	public Object delete(String ids) {
		try {
			if (StringUtils.isNotBlank(ids)){
				String[] arr = ids.split(",");
				for(String id : arr){
					Classes t = classesService.findById(id);
					Academy a = academyService.findById(t.getAcademyId());
					int count = countClass(t.getAcademyId());
					a.setClassAmount(count-1);
					AcademyExample example = new AcademyExample();
					example.createCriteria().andIdEqualTo(t.getAcademyId());
					academyService.updateByExample(a, example);
					classesService.deleteyId(id);
				}
				return jsonUtil.deleteSuccess(true);
			}else {
				return jsonUtil.deleteSuccess(false);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.deleteSuccess(false);
	}

	@ResponseBody
	@RequestMapping(value="/classes/update.do",method=RequestMethod.POST)
	public Object update(Classes t) {
		try {
			if (StringUtils.isNotBlank(t.getId())){
				t.setUpdateTime(DateUtil.dateTimeFormat(null, new Date()));
				t.setName(t.getGrade().substring(2, 4)+t.getNumber());
				ClassesExample example = new ClassesExample();
				example.createCriteria().andIdEqualTo(t.getId());
				classesService.updateByExample(t, example);
				return jsonUtil.updateSuccess(true);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jsonUtil.updateSuccess(false);
	}

	@ResponseBody
	@RequestMapping("/classes/findById.do")
	public Object findById(String id) {
		try {
			if (StringUtils.isNotBlank(id)){
				
				
				return jsonUtil.loadDataSuccess(true, classesService.findById(id));
			}
		} catch (Exception e) {
		}
		return jsonUtil.loadDataSuccess(false, null);
	}

	@ResponseBody
	@RequestMapping("/classes/findByPage.do")
	public Object findByPage(int page, int limit, String keyWord,String academyId) {
		
		
		ClassesExample example = new ClassesExample();
		Criteria criteria = example.createCriteria();
		String value = StringUtils.addLikeStr(keyWord);
		if(StringUtils.isNotBlank(academyId)){
			if (StringUtils.isNotBlank(keyWord)){
				example.or().andAcademyIdEqualTo(academyId).andGradeLike(value);
				example.or().andAcademyIdEqualTo(academyId).andNameLike(value);
				example.or().andAcademyIdEqualTo(academyId).andAcademicDegreeLike(value);
				example.or().andAcademyIdEqualTo(academyId).andNumberLike(value);
				example.or().andAcademyIdEqualTo(academyId).andHeadLike(value);
			
			}else {
				
				criteria.andAcademyIdEqualTo(academyId);
			}
		}else if(StringUtils.isNotBlank(keyWord)){
			// 全局查询
			example.or().andGradeLike(value);
			example.or().andNameLike(value);
			example.or().andAcademicDegreeLike(value);
			example.or().andNumberLike(value);
			example.or().andHeadLike(value);
		
		}
		
		
		return classesService.findByPage(page, limit, example);
		
	}
	
	@ResponseBody
	@RequestMapping("/classes/findByTeacher.do")
	public Object findByTeacher(int page, int limit, String keyWord,String teacherNum) {
		
		
		
		
		
		return classesService.findByTeacher(page, limit, teacherNum);
		
	}
	
	@ResponseBody
	@RequestMapping("/classes/findIdAndName.do")
	public Object findIdAndName(int page, int limit,String academyId,String grade,String keyWord){
		
		ClassesExample example = new ClassesExample();
		Criteria criteria = example.createCriteria();
		criteria.andAcademyIdEqualTo(academyId);
		criteria.andGradeEqualTo(grade);
		criteria.andStatusEqualTo(true);
		if (StringUtils.isNotBlank(keyWord)){
			criteria.andNameLike(keyWord);
		}
		return classesService.findIdAndName(page, limit, example);
		
	}
	
	
	public void exportToExcel(HttpServletResponse response, String ids) {
	}

	public Object importFromExcel(@RequestParam(value = "uploadFile", required = true)MultipartFile file) {
		
		return null;
	}
	
	private int countClass(String acdemyId){
		ClassesExample example = new ClassesExample();
		example.createCriteria().andAcademyIdEqualTo(acdemyId);
		
		return classesService.countByExample(example);
	}
	
}
