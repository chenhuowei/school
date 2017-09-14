package com.fireway.user.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.entity.ResultsStatisticalExample;
import com.fireway.entity.ScoreRecordExample;
import com.fireway.entity.SelectSubject;
import com.fireway.entity.SelectSubjectExample;
import com.fireway.entity.Student;
import com.fireway.entity.StudentExample;
import com.fireway.entity.StudentSelectSubject;
import com.fireway.entity.StudentSelectSubjectExample;
import com.fireway.entity.StudentTest;
import com.fireway.entity.StudentTestExample;
import com.fireway.entity.Syllabus;
import com.fireway.entity.SyllabusExample;
import com.fireway.entity.TestRecord;
import com.fireway.entity.TestRecordExample;
import com.fireway.entity.SyllabusExample.Criteria;
import com.fireway.sys.service.ResultsStatisticalService;
import com.fireway.sys.service.ScoreRecordService;
import com.fireway.sys.service.SelectSubjectService;
import com.fireway.sys.service.StudentSelectSubjectService;
import com.fireway.sys.service.StudentTestService;
import com.fireway.sys.service.SyllabusService;
import com.fireway.sys.service.TestRecordService;
import com.fireway.user.service.StudentService;
import com.fireway.utils.DateUtil;
import com.fireway.utils.Encrypt;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

import net.sf.ehcache.store.disk.StoreUpdateException;

@Controller
@RequestMapping("/student")
public class StudentPageController {
	
	@Resource
	private StudentService studentService;
	@Resource
	private SyllabusService syllabusService;
	@Resource 
	private SelectSubjectService selectSubjectService;
	@Resource 
	private ScoreRecordService scoreRecordService;
	@Resource
	private ResultsStatisticalService resultsStatisticalService;
	@Resource
	private TestRecordService testRecordService;
	@Resource
	private StudentTestService studentTestService;
	@Resource
	private StudentSelectSubjectService studentSelectSubjectService;
	
	@RequestMapping("/{path}.do")
	public String toMessage(@PathVariable String path,@RequestParam(required=false)String type,
			HttpServletRequest request){
		if (StringUtils.isNotBlank(type)){
			
			request.setAttribute("type", type);
		}
		return "student/"+path;
	}
	
	@ResponseBody
	@RequestMapping("/getById.do")
	public Object getById(String id){
		
		
		return studentService.findById(id);
	}
	
	@ResponseBody
	@RequestMapping(value="/updatePassword.do",method=RequestMethod.POST)
	public Object updatePassword(String num,Student record,String newPassword,String oldPassword){
		try {
			if (null != record && StringUtils.isNotBlank(record.getId())){
				StudentExample example = new StudentExample();
				example.createCriteria().andIdEqualTo(record.getId())
					.andPassword2EqualTo(oldPassword).andStudentNumEqualTo(num)
					.andPasswordEqualTo(Encrypt.md5Encode(oldPassword));
				List<Student> list = studentService.findByExample(example);
				if (null != list && list.size()>0){
					record = list.get(0);
					record.setPassword2(newPassword);
					record.setPassword(Encrypt.md5Encode(newPassword));
					studentService.updateById(record);
					return jsonUtil.updateSuccess(true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.asJson(false, "原密码有误或你尚未登陆");
	}
	
	@ResponseBody
	@RequestMapping("/syllabus.do")
	public Object classSyllabus(@RequestParam(required=false)String studentId,String classId,String schoolYear,String term){
		
		Map<String, List> map = new HashMap<String, List>();
		SyllabusExample example = new SyllabusExample();
		Criteria criteria = example.createCriteria();
		criteria.andClassIdEqualTo(classId);
		criteria.andSchoolYearEqualTo(schoolYear);
		criteria.andTermEqualTo(term);
		List<Syllabus> list = syllabusService.findByExample(example);
		map.put("classSyllabus", list);
		List<SelectSubject> selectSubjects = null;
		if (StringUtils.isNotBlank(studentId)){
			 selectSubjects = selectSubjectService.selectByStudentId(studentId,schoolYear,term);
			
		}
		map.put("studentSyllabus", selectSubjects);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/getScoreRecord.do")
	public Object getScoreByStudentId(String schoolYear,Integer term,
			String studentId,Boolean noPass){
		ScoreRecordExample example = new ScoreRecordExample();
		com.fireway.entity.ScoreRecordExample.Criteria criteria = example.createCriteria();
		criteria.andStudentIdEqualTo(studentId);
		if (StringUtils.isNotBlank(schoolYear)){
			criteria.andSchoolYearEqualTo(schoolYear);
			if (null !=term && term > 0){
				criteria.andTermEqualTo(term);
			}
		}
		if (noPass){
			criteria.andPointLessThan(1.00);
		}
		
		return scoreRecordService.findByExample(example);
	}
	
	@ResponseBody
	@RequestMapping("/getResultsStatistical.do")
	public Object getresultsStatisticalServiceByStudentId(String schoolYear,Integer term,
			String studentId){
		ResultsStatisticalExample example = new ResultsStatisticalExample();
		com.fireway.entity.ResultsStatisticalExample.Criteria criteria = example.createCriteria();
		criteria.andStudentIdEqualTo(studentId);
		if (StringUtils.isNotBlank(schoolYear)){
			criteria.andSchoolYearEqualTo(schoolYear);
			if (null !=term && term > 0){
				criteria.andTermEqualTo(term);
			}
		}else {
			criteria.andSchoolYearIsNull();
			criteria.andTermIsNull();
		}
		
		
		return resultsStatisticalService.findByExample(example);
	}
	
	@ResponseBody
	@RequestMapping("/getTestRecord.do")
	public Object getTestRecord(int page,int limit){
		TestRecordExample example = new TestRecordExample();
		
			example.createCriteria().andStatusEqualTo(true);
		
		return testRecordService.findByPage(page, limit, example);
	}
	
	@ResponseBody
	@RequestMapping("/getStudentTest.do")
	public Object getStudentTest(Integer page, Integer  limit,String studentId){
		StudentTestExample example = new StudentTestExample();
		example.createCriteria().andStudentIdEqualTo(studentId)
			.andIsRegisSuccessEqualTo(true).andIsPaymentEqualTo(false);
		example.or().andStudentIdEqualTo(studentId)
		.andIsRegisSuccessEqualTo(true).andIsPaymentIsNull();
		return studentTestService.findByPage(page, limit, example);
	}
	
	@ResponseBody
	@RequestMapping("/studentTest.do")
	public Object studentTest(Integer page, Integer  limit,String studentId){
		StudentTestExample example = new StudentTestExample();
		example.createCriteria().andStudentIdEqualTo(studentId)
		.andIsRegisSuccessEqualTo(true).andIsPaymentEqualTo(true);
		return studentTestService.findByPage(page, limit, example);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/saveStudentTest.do",method=RequestMethod.POST)
	public Object saveStudentTest(StudentTest record,int page,int limit){
		Random random = new Random();
		try {
			if (StringUtils.isNotBlank(record.getTestRecordId()) 
					&& StringUtils.isNotBlank(record.getStudentId())){
				// find 
				StudentTestExample  example = new StudentTestExample();
				example.createCriteria().andTestRecordIdEqualTo(record.getTestRecordId())
					.andStudentIdEqualTo(record.getStudentId())
						.andIsRegisSuccessEqualTo(true);
				List<StudentTest> list = studentTestService.findByExample(example);
				if (null != list && list.size()>0){
					return jsonUtil.asJson(false, "此项目你已经成功报名!!!");
				}
				record.setId(Utils.uuid());
				TestRecord testRecord = testRecordService.findById(record.getTestRecordId());
				record.setIsRegisSuccess(true);
				record.setStatus(true);
				record.setTestCode(testRecord.getTestCode());
				record.setTestName(testRecord.getTestName());
				//int testNum = random.nextInt(99-10+1)+10;
				int testNum2 = random.nextInt(99-10+1)+10;
				record.setTestNum(DateUtil.dateTimeFormat("yyyyHHmmssSSS", new Date())+testNum2);
				studentTestService.save(record);
				return jsonUtil.asJson(true, "成功报名!!!");
				//
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return jsonUtil.asJson(false, "报名失败，请稍后再次尝试...");
	}
	
	@ResponseBody
	@RequestMapping("/deleteStudentTest.do")
	public Object deleteStudentTest(StudentTest record,int page,int limit){
		try {
			if (StringUtils.isNotBlank(record.getTestRecordId()) 
					&& StringUtils.isNotBlank(record.getStudentId())){
				boolean b = testRecordService.findById(record.getTestRecordId()).getStatus();
				if (!b){
					return jsonUtil.asJson(false, "此时间段，该功能暂未开放");
				}
				studentTestService.delete(record.getTestRecordId(), record.getStudentId());
				
			}
			
			return jsonUtil.asJson(true, "成功退选!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.asJson(false, "退选失败，请稍后再次尝试!!!");
	}
	
	@ResponseBody
	@RequestMapping("/getSelectSubject.do")
	public Object getSelectSubjec(int page,int limit,HttpServletRequest request){
		SelectSubjectExample example = new SelectSubjectExample();
		example.createCriteria()
			.andSchoolYearEqualTo(request.getServletContext().getAttribute("schoolYearAtNow").toString())
			.andTermEqualTo(request.getServletContext().getAttribute("termAtNow").toString())
			.andStatusEqualTo(true);
			
		return selectSubjectService.findByPage(page, limit, example);
	}
	
	@ResponseBody
	@RequestMapping("/getStudentSelectSubject.do")
	public Object getStudentSelectSubject(int page,int limit,String studentId,
			HttpServletRequest request){
		StudentSelectSubjectExample studentSelectSubjectExample = new StudentSelectSubjectExample();
		studentSelectSubjectExample.createCriteria().andStudentIdEqualTo(studentId);
		List<StudentSelectSubject> list = studentSelectSubjectService.findByStudentId(studentId);
		if (null !=list && list.size() > 0){
			SelectSubjectExample example = new SelectSubjectExample();
			//com.fireway.entity.SelectSubjectExample.Criteria criteria = example.createCriteria();
			for(StudentSelectSubject record : list){
				example.or().andIdEqualTo(record.getSelectSubjectId())
				.andSchoolYearEqualTo(request.getServletContext().getAttribute("schoolYearAtNow").toString())
				.andTermEqualTo(request.getServletContext().getAttribute("termAtNow").toString())
				.andStatusEqualTo(true);
			
			}
			return selectSubjectService.findByPage(page, limit, example);
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/studentSelectSubject.do")
	public Object studentSelectSubject(int page,int limit,String studentId,
			String schoolYear,String term){
		StudentSelectSubjectExample studentSelectSubjectExample = new StudentSelectSubjectExample();
		studentSelectSubjectExample.createCriteria().andStudentIdEqualTo(studentId);
		List<StudentSelectSubject> list = studentSelectSubjectService.findByStudentId(studentId);
		if (null !=list && list.size() > 0){
			SelectSubjectExample example = new SelectSubjectExample();
			//com.fireway.entity.SelectSubjectExample.Criteria criteria = example.createCriteria();
			if (StringUtils.isNotBlank(schoolYear) && StringUtils.isNotBlank(term)){
					
					for(StudentSelectSubject record : list){
						example.or().andIdEqualTo(record.getSelectSubjectId())
						.andSchoolYearEqualTo(schoolYear)
						.andTermEqualTo(term);
						
					}
					
			}else if (StringUtils.isNotBlank(schoolYear)) {
				for(StudentSelectSubject record : list){
					example.or().andIdEqualTo(record.getSelectSubjectId())
					.andSchoolYearEqualTo(schoolYear);
					
				}
			}else {
				for(StudentSelectSubject record : list){
					example.or().andIdEqualTo(record.getSelectSubjectId());
					
				}
			}
			return selectSubjectService.findByPage(page, limit, example);
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="/saveStudentSelectSubject",method=RequestMethod.POST)
	public Object saveStudentSelectSubject(StudentSelectSubject record){
		try {
			
			if (StringUtils.isNotBlank(record.getSelectSubjectId()) && 
					StringUtils.isNotBlank(record.getStudentId())){
				// vaild only
				StudentSelectSubjectExample studentSelectSubjectExample = new StudentSelectSubjectExample();
				studentSelectSubjectExample.createCriteria().andStudentIdEqualTo(record.getStudentId())
				.andSelectSubjectIdEqualTo(record.getSelectSubjectId());
				List<StudentSelectSubject> list = studentSelectSubjectService.findByExample(studentSelectSubjectExample);
				studentSelectSubjectExample.clear();
				studentSelectSubjectExample.createCriteria().andStudentIdEqualTo(record.getStudentId());
				int counts = studentSelectSubjectService.countByExample(studentSelectSubjectExample);
				if (null != list && list.size() > 0){
					return jsonUtil.asJson(false, "此项目你已经选课成功");
				}else if(counts == 1){
					return jsonUtil.asJson(false, "此时间段你只能选择一门课程");
					
				}else {
					record.setId(Utils.uuid());
					studentSelectSubjectService.save(record);
					return jsonUtil.asJson(true, "选课成功");
					
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.asJson(false, "选课失败");
	}
	
	@ResponseBody
	@RequestMapping("/deleteStudentSelectSubject.do")
	public Object deleteStudentSelectSubject(StudentSelectSubject record){
		if (StringUtils.isNotBlank(record.getSelectSubjectId()) && 
				StringUtils.isNotBlank(record.getStudentId())){
			boolean b = selectSubjectService.findById(record.getSelectSubjectId()).getStatus();
			if (!b){
				return jsonUtil.asJson(false, "此时间段，该功能暂未开放...");
			}
			studentSelectSubjectService.delete(record);
			return jsonUtil.asJson(true, "退选成功");
		}
		return jsonUtil.asJson(false, "退选失败");
	}
	
	
	
	
	
	
	
	
	
}
