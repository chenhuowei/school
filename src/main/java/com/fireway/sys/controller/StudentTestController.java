package com.fireway.sys.controller;

import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.entity.StudentTest;
import com.fireway.entity.StudentTestExample;
import com.fireway.entity.TestRecord;
import com.fireway.sys.service.StudentTestService;
import com.fireway.sys.service.TestRecordService;
import com.fireway.utils.DateUtil;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
@RequestMapping("/studentTest")
public class StudentTestController {

	@Resource
	private StudentTestService studentTestService;
	@Resource
	private TestRecordService testRecordService;
	
	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object save(String testRecordIds,String studentId){
		Random random = new Random();
		try {
			if (StringUtils.isNotBlank(testRecordIds) && StringUtils.isNotBlank(studentId)){
				String[] ids = testRecordIds.split(",");
				for(String testRecordId : ids){
					StudentTest record = new StudentTest();
					record.setId(Utils.uuid());
					record.setTestRecordId(testRecordId);
					record.setStudentId(studentId);
					TestRecord testRecord = testRecordService.findById(testRecordId);
					record.setIsRegisSuccess(true);
					record.setTestCode(testRecord.getTestCode());
					record.setTestName(testRecord.getTestName());
					//int testNum = random.nextInt(99-10+1)+10;
					int testNum2 = random.nextInt(99-10+1)+10;
					record.setTestNum(DateUtil.dateTimeFormat("yyyyHHmmssSSS", new Date())+testNum2);
					studentTestService.save(record);
				}
				return jsonUtil.saveSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.saveSuccess(false);
	}
	
	@ResponseBody
	@RequestMapping("/delete.do")
	public Object delete(StudentTest record){
		
		if (StringUtils.isNotBlank(record.getStudentId()) &&
				StringUtils.isNotBlank(record.getTestRecordId())){
			studentTestService.delete(record.getTestRecordId(), record.getStudentId());
			return jsonUtil.deleteSuccess(true);
		}
		
		return jsonUtil.deleteSuccess(false);
	}
	
	@ResponseBody
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public Object update(StudentTest record){
		
		try {
			if (null != record.getTestScore() && record.getTestScore() >= 60){
				record.setIsPass(true);
			}else {
				record.setIsPass(false);
			}
			studentTestService.updateById(record);
			return jsonUtil.updateSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonUtil.updateSuccess(false);
	}
	
	@ResponseBody
	@RequestMapping("/findByStudentId.do")
	public Object findByStudentId(int page,int limit,String studentId){
		
		StudentTestExample example = new StudentTestExample();
		example.createCriteria().andStudentIdEqualTo(studentId);
		return studentTestService.findByPage(page, limit, example);
	}
	
}
