package com.fireway.sys.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.base.BaseController;
import com.fireway.entity.Location;
import com.fireway.entity.LocationExample;
import com.fireway.entity.SelectSubject;
import com.fireway.entity.SelectSubjectExample;
import com.fireway.entity.SelectSubjectExample.Criteria;
import com.fireway.entity.Subject;
import com.fireway.entity.Teacher;
import com.fireway.sys.service.LocationService;
import com.fireway.sys.service.SelectSubjectService;
import com.fireway.sys.service.SubjectService;
import com.fireway.user.service.TeacherService;
import com.fireway.utils.DateUtil;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;
@Controller
@RequestMapping("/selectSubject")
public class SelectSubjectController implements BaseController<SelectSubject> {

	@Resource
	private SelectSubjectService selectSubjectService;
	@Resource
	private SubjectService subjectService;
	@Resource
	private TeacherService teacherService;
	@Resource
	private LocationService locationService;
	
	@RequestMapping("/selectSubjectPage.do")
	public String toPage() {
		
		return "admin/selectSubjectPage";
	}

	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object save(SelectSubject record) {
		try {
			record.setId(Utils.uuid());
			record.setCreateTime(DateUtil.dateTimeFormat(null, new Date()));
			if (StringUtils.isNotBlank(record.getSubjectId())){
				Subject subject = subjectService.findById(record.getSubjectId());
				record.setSubjectCode(subject.getCode());
				record.setSubjectName(subject.getSubjectName()+subject.getVolumes());
				record.setCatagory(subject.getCategory());
			}
			if (StringUtils.isNotBlank(record.getTeacherId())){
				Teacher teacher = teacherService.findById(record.getTeacherId());
				record.setTeacherName(teacher.getName());
			}
			selectSubjectService.save(record);
			return jsonUtil.saveSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.saveSuccess(false);
	}

	@ResponseBody
	@RequestMapping(value="/delete.do",method=RequestMethod.GET)
	public Object delete(String ids) {
		try {
			if (StringUtils.isNotBlank(ids)){
				String[] array = ids.split(",");
				for (String id: array) {
					selectSubjectService.delete(id);
				}
				return jsonUtil.deleteSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.deleteSuccess(false);
	}

	@ResponseBody
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public Object update(SelectSubject record) {
		try {
			record.setUpdateTime(DateUtil.dateTimeFormat(null, new Date()));
			if (StringUtils.isNotBlank(record.getSubjectId())){
				Subject subject = subjectService.findById(record.getSubjectId());
				record.setSubjectCode(subject.getCode());
				record.setSubjectName(subject.getSubjectName()+subject.getVolumes());
				record.setCatagory(subject.getCategory());
			}
			if (StringUtils.isNotBlank(record.getTeacherId())){
				Teacher teacher = teacherService.findById(record.getTeacherId());
				record.setTeacherName(teacher.getName());
			}
			selectSubjectService.updateSelectById(record);
			return jsonUtil.updateSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.updateSuccess(false);
	}

	@ResponseBody
	@RequestMapping(value="/findById.do")
	public Object findById(String id) {
		if (StringUtils.isNotBlank(id)){
			
			return jsonUtil.loadDataSuccess(true, selectSubjectService.findById(id));
		}
		return jsonUtil.loadDataSuccess(false, null);
	}

	@ResponseBody
	@RequestMapping("/findByPage.do")
	public Object findByPage(int page,int limit,String keyWord,
			@RequestParam(required=false)String teacherId,
			@RequestParam(required=false)String schoolYear,
			@RequestParam(required=false)String term){
		
		SelectSubjectExample example = new SelectSubjectExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(keyWord)){
			String[] key = keyWord.split("[,，]");
			for(String word : key){
			String value = StringUtils.addLikeStr(word);
			example.or().andLocationNameLike(value);
			example.or().andTeacherNameLike(value);
			example.or().andSubjectNameLike(value);
			example.or().andCatagoryLike(value);
			}
			
			
		}
		if (StringUtils.isNotBlank(teacherId)) {
			if (StringUtils.isNotBlank(keyWord)){
				String[] key = keyWord.split("[,，]");
				for(String word : key){
				String value = StringUtils.addLikeStr(word);
				example.or().andLocationNameLike(value).andTeacherIdEqualTo(teacherId);
				example.or().andTeacherNameLike(value).andTeacherIdEqualTo(teacherId);
				example.or().andSubjectNameLike(value).andTeacherIdEqualTo(teacherId);
				example.or().andCatagoryLike(value).andTeacherIdEqualTo(teacherId);
				}
				
				
			}else {
				criteria.andTeacherIdEqualTo(teacherId);
			}
		}
		if (StringUtils.isBlank(schoolYear)){
			criteria.andSchoolYearEqualTo(Utils.getSchoolYearAtNow());
		}
		if (StringUtils.isBlank(term)){
			criteria.andTermEqualTo(Utils.getTermAtNow().toString());
		}
		return selectSubjectService.findByPage(page, limit,example);
	}
	
	
	@ResponseBody
	@RequestMapping("/findByTeacherId.do")
	public Object findByTeacherId(String teacherId,String schoolYear,String term){
		
		
		return selectSubjectService.selectByTeacherId(teacherId, schoolYear, term);
	}
	
	@ResponseBody
	@RequestMapping("/findIdAndName.do")
	public Object findByIdAndName(String teacherId,String schoolYear,String term){
		
		
		return selectSubjectService.selectByIdAndName(teacherId, schoolYear, term);
	}
	
	
	@ResponseBody
	@RequestMapping("/updateStatus.do")
	public Object updateStatus(@RequestParam(required=false)Boolean returnStatus,
			@RequestParam(required=false)boolean status,HttpServletRequest request){
		try {
			SelectSubjectExample example = new SelectSubjectExample();
			example.createCriteria()
			.andSchoolYearEqualTo(request.getServletContext().getAttribute("schoolYearAtNow").toString())
			.andTermEqualTo(request.getServletContext().getAttribute("termAtNow").toString());
			List<SelectSubject> list = selectSubjectService.findByExample(example);
			if (null !=returnStatus && returnStatus){
				return list.get(0).getStatus();
			}
			for(SelectSubject selectSubject : list){
				selectSubject.setStatus(status);
				selectSubjectService.updateSelectById(selectSubject);
			}
			if (status){
				return jsonUtil.asJson(true, "选课已开启");
			}else{
				return jsonUtil.asJson(true, "选课已关闭");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.asJson(false, "请求异常...");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@ResponseBody
	@RequestMapping("/autoLayout.do")
	public Object autoLayout(String[] classWeek,String schoolYear,String term){
		Map<String, Object> json = jsonUtil.getMap();
		try {
			SelectSubjectExample selectSubjectExample = new SelectSubjectExample();
			selectSubjectExample.createCriteria().andSchoolYearEqualTo(schoolYear).andTermEqualTo(term);
			List<SelectSubject> selectSubjects = selectSubjectService.findByExample(selectSubjectExample);
			if (selectSubjects.size()>0){
				LocationExample locationExample = new LocationExample();
				locationExample.createCriteria().andStatusEqualTo(true).andIsOfficEqualTo(false);
				List<Location> locations = locationService.findByExample(locationExample);
				selectSubjectService.deleteLayout(true, selectSubjects);
				selectSubjectService.autoLayout(classWeek, "9-10", selectSubjects, locations);
				json.put("success", true);
				json.put("message", "自动编排成功");
				return json;
			}
			json.put("success", false);
			json.put("message", "自动编排失败，科目安排为空");
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		json.put("success", false);
		json.put("message", "自动编排失败");
		return json;
	}

	
	public Object isRepeat(String key) {
		
		return null;
	}

}
