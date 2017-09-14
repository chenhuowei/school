package com.fireway.sys.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.faces.event.PreValidateEvent;
import javax.resource.spi.RetryableUnavailableException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.base.BaseController;
import com.fireway.entity.ClassSubject;
import com.fireway.entity.ClassSubjectExample;
import com.fireway.entity.Subject;
import com.fireway.entity.SubjectArrangement;
import com.fireway.entity.SubjectArrangementExample;
import com.fireway.entity.SubjectArrangementExample.Criteria;
import com.fireway.entity.Teacher;
import com.fireway.sys.service.ClassSubjectService;
import com.fireway.sys.service.SubjectArrangementService;
import com.fireway.sys.service.SubjectService;
import com.fireway.sys.service.SyllabusService;
import com.fireway.user.service.TeacherService;
import com.fireway.utils.LogUtil;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
@RequestMapping("/subjectArrangement")
public class SubjectArrangementController implements BaseController<SubjectArrangement> {

	@Resource
	private SubjectArrangementService subjectArrangementService;
	@Resource
	private SubjectService subjectService;
	@Resource
	private TeacherService teacherService;
	@Resource
	private ClassSubjectService classSubjectService;
	@Resource
	private SyllabusService syllabusService;
	
	@RequestMapping("/subjectArrangementPage.do")
	public String toPage() {
		
		return "admin/subjectArrangementPage";
	}

	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object save(SubjectArrangement record,String[] classId) {
		try {
			record.setId(Utils.uuid());
			if (StringUtils.isNotBlank(record.getTeacherId())){
				Teacher teacher = teacherService.findById(record.getTeacherId());
				record.setTeacherName(teacher.getName());
				record.setTeacherNum(teacher.getTeacherNum());
				
			}
			if(StringUtils.isNotBlank(record.getSubjectId())){
				
				Subject subject = subjectService.findById(record.getSubjectId());
				record.setSubjectCode(subject.getCode());
				record.setSubjectName(subject.getSubjectName());
				record.setSubjectVolumes(subject.getVolumes());
			}
			subjectArrangementService.save(record);
			
			for (String cid : classId){
				ClassSubject cs = new ClassSubject();
				if (StringUtils.isNotBlank(cid)){
					cs.setId(Utils.uuid());
					cs.setClassId(cid);
					cs.setSubjectArrangementId(record.getId());
					classSubjectService.save(cs);
				}
			}
			
			return jsonUtil.saveSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.saveSuccess(false);
	}

	@ResponseBody
	@RequestMapping(value="/delete.do",method=RequestMethod.POST)
	public Object delete(String ids) {
		try {
			if (StringUtils.isNotBlank(ids)){
				String[] values = ids.split(",");
				for (String id : values){
					subjectArrangementService.delete(id);
					//delete classSubject 
					classSubjectService.deleteByExample("", id);
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
	public Object update(SubjectArrangement record) {
		try {
			if (StringUtils.isNotBlank(record.getTeacherId())){
				Teacher teacher = teacherService.findById(record.getTeacherId());
				record.setTeacherName(teacher.getName());
				record.setTeacherNum(teacher.getTeacherNum());
				
			}
			if(StringUtils.isNotBlank(record.getSubjectId())){
				
				Subject subject = subjectService.findById(record.getSubjectId());
				record.setSubjectCode(subject.getCode());
				record.setSubjectName(subject.getSubjectName());
				record.setSubjectVolumes(subject.getVolumes());
			}
			subjectArrangementService.updateSelectById(record);
			return jsonUtil.updateSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.updateSuccess(false);
	}

	@ResponseBody
	@RequestMapping("/findById.do")
	public Object findById(String id) {
		try {
			if (StringUtils.isNotBlank(id)){
				return jsonUtil.loadDataSuccess(true, subjectArrangementService.findById(id));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.loadDataSuccess(false, null);
	}

	@ResponseBody
	@RequestMapping("/findByPage.do")
	public Object findByPage(int page,int limit,String[] classId,String keyWord){
		List<ClassSubject> classSubjects = null;
		if (null != classId && classId.length>0){
			ClassSubjectExample classSubjectExample = new ClassSubjectExample();
			com.fireway.entity.ClassSubjectExample.Criteria criteria = classSubjectExample.createCriteria();
			for (String cid : classId){
				classSubjectExample.or().andClassIdEqualTo(cid);
			}
		 classSubjects = classSubjectService.findByExample(classSubjectExample);
		}
		SubjectArrangementExample example = new SubjectArrangementExample();
		if (null != classSubjects && classSubjects.size() >0){
			for (ClassSubject classSubject : classSubjects){
				if (StringUtils.isNotBlank(keyWord)){
					String value = StringUtils.addLikeStr(keyWord);
					example.or().andSubjectCodeLike(value).andIdEqualTo(classSubject.getSubjectArrangementId());
					example.or().andSubjectNameLike(value).andIdEqualTo(classSubject.getSubjectArrangementId());
					example.or().andTeacherNameLike(value).andIdEqualTo(classSubject.getSubjectArrangementId());
					example.or().andTeacherNumLike(value).andIdEqualTo(classSubject.getSubjectArrangementId());
					
				}else {
					example.or().andIdEqualTo(classSubject.getSubjectArrangementId());
					
				}
			}
			return subjectArrangementService.findByPage(page, limit,example);
		}
		
		return null;
		
	}
	
	@ResponseBody
	@RequestMapping("/findByClassId.do")
	public Object findByClassId(String classId,String schoolYear,String term,
			@RequestParam(required=false)String teacherId){
		
		
		return subjectArrangementService.selectByClassId(classId, schoolYear, term,teacherId);
	}
	
	
	
	public Object isRepeat(String key) {
		
		return null;
	}

	public Object save(SubjectArrangement record) {
		
		return null;
	}

}
