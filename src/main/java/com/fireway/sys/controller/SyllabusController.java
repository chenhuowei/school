package com.fireway.sys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.ls.LSInput;

import com.fireway.entity.Location;
import com.fireway.entity.LocationExample;
import com.fireway.entity.SelectSubject;
import com.fireway.entity.SubjectArrangement;
import com.fireway.entity.SubjectArrangementExample;
import com.fireway.entity.Syllabus;
import com.fireway.entity.SyllabusExample;
import com.fireway.entity.SyllabusExample.Criteria;
import com.fireway.sys.service.LocationService;
import com.fireway.sys.service.SelectSubjectService;
import com.fireway.sys.service.SubjectArrangementService;
import com.fireway.sys.service.SyllabusService;
import com.fireway.utils.StringUtils;
import com.fireway.utils.jsonUtil;

@Controller
@RequestMapping("/syllabus")
public class SyllabusController {

	@Resource
	private SyllabusService syllabusService;
	@Resource
	private SubjectArrangementService subjectArrangementService;
	@Resource
	private LocationService locationService;
	@Resource
	private SelectSubjectService selectSubjectService;
	
	
	@RequestMapping("/classSyllabusTable.do")
	public String classSyllabusTable(String classId,String schoolYear,String term,HttpServletRequest request){
		SyllabusExample example = new SyllabusExample();
		Criteria criteria = example.createCriteria();
		criteria.andClassIdEqualTo(classId);
		criteria.andSchoolYearEqualTo(schoolYear);
		criteria.andTermEqualTo(term);
		List<Syllabus> list = syllabusService.findByExample(example);
		request.setAttribute("syllabusTable", list);
		return "admin/classSyllabusTable";
	}
	
	@RequestMapping("/studentSyllabusTable.do")
	public String studentSyllabusTable(String studentId,String classId,String schoolYear,String term,HttpServletRequest request){
		SyllabusExample example = new SyllabusExample();
		Criteria criteria = example.createCriteria();
		criteria.andClassIdEqualTo(classId);
		criteria.andSchoolYearEqualTo(schoolYear);
		criteria.andTermEqualTo(term);
		List<Syllabus> list = syllabusService.findByExample(example);
		request.setAttribute("syllabusTable", list);
		List<SelectSubject> selectSubjects = selectSubjectService.selectByStudentId(studentId,schoolYear,term);
		request.setAttribute("selectTable", selectSubjects);
		return "admin/classSyllabusTable";
	}
	
	@RequestMapping("/teacherSyllabusTable.do")
	public String teacherSyllabusTable(String teacherId,String teacherNum,String schoolYear,String term,HttpServletRequest request){
		SyllabusExample example = new SyllabusExample();
		Criteria criteria = example.createCriteria();
		criteria.andTeacherNumEqualTo(teacherNum);
		criteria.andSchoolYearEqualTo(schoolYear);
		criteria.andTermEqualTo(term);
		List<Syllabus> list = syllabusService.findByExample(example);
		request.setAttribute("syllabusTable", list);
		List<SelectSubject> selectSubjects = selectSubjectService.selectByTeacherId(teacherId, schoolYear, term);
		request.setAttribute("selectTable", selectSubjects);
		return "admin/teacherSyllabusTable";
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/autoLayoutCourse.do",method=RequestMethod.POST)
	public Object autoLayoutCourse(String schoolYear,String term){
		Map<String, Object> json = jsonUtil.getMap();
		try {
			if (StringUtils.isNotBlank(schoolYear)&&StringUtils.isNotBlank(term)){
				SubjectArrangementExample subjectArrangementExample = new SubjectArrangementExample();
				subjectArrangementExample.createCriteria().andSchoolYearEqualTo(schoolYear).andTermEqualTo(term);
				subjectArrangementExample.setOrderByClause("TEACHER_NUM asc,SUBJECT_CODE asc");
				List<SubjectArrangement> subjectArrangements = subjectArrangementService.findByExample(subjectArrangementExample);
				if (subjectArrangements.size() == 0){
					json.put("success", false);
					json.put("message", "所选择的的课程安排不存在，请联系管理员");
					return json;
				}
				LocationExample locationExample = new LocationExample();
				locationExample.createCriteria().andStatusEqualTo(true).andIsOfficEqualTo(false);
				locationExample.setOrderByClause("BUILDING asc,ROOM_NUMBER asc");
				List<Location> locations = locationService.findByExample(locationExample);
				if (locations.size()==0){
					json.put("success", false);
					json.put("message", "所选择的的教学地点不存在，请联系管理员");
					return json;
				}
				
				SyllabusExample example = new SyllabusExample();
				Criteria criteria = example.createCriteria();
				criteria.andSchoolYearEqualTo(schoolYear);
				criteria.andTermEqualTo(term);
				List<Syllabus> list = syllabusService.findByExample(example);
				if (list.size()>0){
					SyllabusExample example1 = new SyllabusExample();
					example.createCriteria().andSchoolYearEqualTo(schoolYear).andTermEqualTo(term);
					syllabusService.deleteByExample(example1);
					
				}
				
				syllabusService.autoLayoutCourse(schoolYear,term,subjectArrangements,locations);
				json.put("success", true);
				json.put("message", "成功");
				
				return json;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		json.put("success", false);
		json.put("message", "失败");
		
		return json;
		
	}
	
	@ResponseBody
	@RequestMapping("/getSyllabus.do")
	public Object getSyllabus(String classId,@RequestParam(required=false)String schoolYear,
			@RequestParam(required=false)String term){
		SyllabusExample example = new SyllabusExample();
		Criteria criteria = example.createCriteria();
		criteria.andClassIdEqualTo(classId);
		if (StringUtils.isNotBlank(schoolYear)){
			criteria.andSchoolYearEqualTo(schoolYear);
		}
		if (StringUtils.isNotBlank(term)){
			criteria.andTermEqualTo(term);
		}
		
		return syllabusService.findByExample(example);
	}
	
	@ResponseBody
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public Object save(Syllabus record){
		try {
			if (null != record){
				syllabusService.updateSelectById(record);
				return jsonUtil.updateSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.updateSuccess(false);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/delete.do")
	public Object delete(String ids){
		try {
			if (StringUtils.isNotBlank(ids)){
				String[] array = ids.split(",");
				for(String id: array){
					syllabusService.deleteById(id);
				}
				return jsonUtil.deleteSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.deleteSuccess(false);
		
	}
	
	
	
	
	
}
