package com.fireway.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fireway.entity.Student;
import com.fireway.entity.StudentExample;
import com.fireway.entity.StudentExample.Criteria;
import com.fireway.request.dto.SearchParam;
import com.fireway.user.service.StudentService;
import com.fireway.utils.BeanAndMapUtil;
import com.fireway.utils.ContantsUtil;
import com.fireway.utils.DateUtil;
import com.fireway.utils.Encrypt;
import com.fireway.utils.ExportToExcelUtil;
import com.fireway.utils.ImportFromExcelUtil;
import com.fireway.utils.LogUtil;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Resource
	private StudentService studentService;
	
	@RequestMapping("/studentPage.do")
	public String toPage() {
		
		return "admin/studentPanel";
	}

	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object save(Student record) {
		try {
			record.setId(Utils.uuid());
			record.setCreateTime(DateUtil.dateTimeFormat(null, new Date()));
			record.setAge(Utils.getAge(record.getBirth()));
			record.setPassword(Encrypt.md5Encode(record.getPassword2()));
			studentService.save(record);
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
				String[] arr = ids.split(",");
				for (String id : arr){
					studentService.delete(id);
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
	public Object update(Student record) {
		try {
			record.setUpdateTime(DateUtil.dateTimeFormat(null, new Date()));
			record.setPassword(Encrypt.md5Encode(record.getPassword2()));
			record.setAge(Utils.getAge(record.getBirth()));
			StudentExample example = new StudentExample();
			Criteria criteria = example.createCriteria();
			if (StringUtils.isNotBlank(record.getId())){
				criteria.andIdEqualTo(record.getId());
			}
			if (StringUtils.isNotBlank(record.getStudentNum())){
				criteria.andStudentNumEqualTo(record.getStudentNum());
			}
			studentService.updateSelectByExample(record, example);
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
				return jsonUtil.loadDataSuccess(true, studentService.findById(id));
			}
		} catch (Exception e) {
		}
		return jsonUtil.loadDataSuccess(false, null);
	}
	
	@ResponseBody
	@RequestMapping("/findByPage.do")
	public Object findByPage(int page,int limit,String keyWord,
			SearchParam searchParams) {
		return studentService.findBySearchParam(page, limit, searchParams);
	}
	
	@ResponseBody
	@RequestMapping("/findBySelectSubject.do")
	public Object findBySelectSubject(int page,int limit,String keyWord,String selectSubjectId,
			SearchParam searchParams) {
		return studentService.findBySelectSubject(page, limit, searchParams, selectSubjectId);
	}
	
	@ResponseBody
	@RequestMapping("/isRepeat.do")
	public Object isRepeat(String num){
		if (StringUtils.isNotBlank(num)){
			StudentExample example = new StudentExample();
			example.createCriteria().andStudentNumEqualTo(num);
			List<Student> list = studentService.findByExample(example);
			if (null != list && list.size() <= 0){
				return jsonUtil.newJson("success", true);
			}
		}
		
		return jsonUtil.newJson("success", false);
	}
	
	@RequestMapping("/exportToExcel.do")
	public void exportToExcel(HttpServletResponse response,String ids,String classId) {
		List<Student> users = null;
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(ids)){
			users = new ArrayList<Student>();
			Student user = null;
			String[] strings = ids.split(",");
			for (String id : strings){
				user = studentService.findById(id);
				users.add(user);
			}
		}else {
			if (StringUtils.isNotBlank(classId)){
				criteria.andClassIdEqualTo(classId);
			}
			users = studentService.findByExample(example);
		}
	
	try {
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
		
		BeanAndMapUtil beanAndMapUtil = new BeanAndMapUtil();
		listMap = beanAndMapUtil.listMap(users);
		ExportToExcelUtil.exportView(response, listMap, ContantsUtil.studentColumnNames, ContantsUtil.studentPropertys,"学生信息");
	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	}

	@ResponseBody
	@RequestMapping("/importFromExcel.do")
	public Object importFromExcel(@RequestParam(value = "uploadFile", required = true)MultipartFile file,
			boolean isCreate,String classId) {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			
			List<Map<String, Object>> listMap = ImportFromExcelUtil.exportListFromExcel(file, 0,
					ContantsUtil.studentColumnNames,ContantsUtil.studentPropertys);
			Student user = null;
			for (Map<String, Object> map : listMap){
				user = new Student();
				user = (Student) BeanAndMapUtil.map2Bean(map, user);
				if (StringUtils.isNotBlank(classId)){
					user.setClassId(classId);
				}
				if (isCreate){
					save(user);
				}else {
					update(user);
				}
			}
			json.put("success", true);
			json.put("message", "导入数据成功");
			file = null;
			
			
		} catch (Exception e) {
			
			json.put("success", false);
			json.put("message", "导入数据失败,请重新操作");
			e.printStackTrace();
		}
		file = null;
		
		return json;
	}

}
