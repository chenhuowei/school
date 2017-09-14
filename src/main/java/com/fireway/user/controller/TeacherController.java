package com.fireway.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.junit.internal.matchers.ThrowableMessageMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fireway.entity.Teacher;
import com.fireway.entity.TeacherExample;
import com.fireway.entity.User;
import com.fireway.entity.UserExample;
import com.fireway.entity.TeacherExample.Criteria;
import com.fireway.request.dto.SearchParam;
import com.fireway.user.service.TeacherService;
import com.fireway.utils.BeanAndMapUtil;
import com.fireway.utils.ContantsUtil;
import com.fireway.utils.DateUtil;
import com.fireway.utils.Encrypt;
import com.fireway.utils.ExportToExcelUtil;
import com.fireway.utils.ImportFromExcelUtil;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
@RequestMapping("/teacher")
public class TeacherController{

	@Resource
	private TeacherService teacherService;
	
	
	@RequestMapping("/{path}.do")
	public String toMessage(@PathVariable String path){
		
		return "teacher/"+path;
	}
	
	@RequestMapping("/teacherPage.do")
	public String toPage() {
		
		return "admin/teacherPage";
	}

	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object save(Teacher record) {
		try {
			record.setId(Utils.uuid());
			record.setCreateTime(DateUtil.dateTimeFormat(null, new Date()));
			record.setAge(Utils.getAge(record.getBirth()));
			record.setPassword(Encrypt.md5Encode(record.getPassword2()));
			teacherService.save(record);
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
					teacherService.delete(id);
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
	public Object update(Teacher record) {
		try {
			record.setUpdateTime(DateUtil.dateTimeFormat(null, new Date()));
			record.setAge(Utils.getAge(record.getBirth()));
			TeacherExample example = new TeacherExample();
			Criteria criteria = example.createCriteria();
			if (StringUtils.isNotBlank(record.getId())){
				criteria.andIdEqualTo(record.getId());
			}
			if (StringUtils.isNotBlank(record.getTeacherNum())){
				criteria.andTeacherNumEqualTo(record.getTeacherNum());
			}
			teacherService.updateByExample(record, example);
			return jsonUtil.updateSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.updateSuccess(false);
	}

	
	@ResponseBody
	@RequestMapping(value="/updatePassword.do",method=RequestMethod.POST)
	public Object updatePassword(String num, String oldPassword,String newPassword){
		try {
			if (!StringUtils.isBlank(oldPassword) && !StringUtils.isBlank(newPassword)){
				//vaild old password
				Teacher teacher = null;
				TeacherExample example = new TeacherExample();
				example.createCriteria().andTeacherNumEqualTo(num)
					.andPasswordEqualTo(Encrypt.md5Encode(oldPassword));
				List<Teacher> list  = teacherService.findByExample(example);
				if (null != list && list.size() > 0){
					teacher = list.get(0);
				}
				if (null != teacher){
					example.clear();
					teacher.setPassword2(newPassword);
					teacher.setPassword(Encrypt.md5Encode(newPassword));
					teacherService.updateSelectById(teacher);
					return jsonUtil.updateSuccess(true);
				}else{
					return jsonUtil.updateSuccess(false);
				}
			}
			
		} catch (Exception e) {
			return jsonUtil.updateSuccess(false);
		}
		return jsonUtil.updateSuccess(false);
	}
	
	
	@ResponseBody
	@RequestMapping("/findById.do")
	public Object findById(String id) {
		if (StringUtils.isNotBlank(id)){
			return jsonUtil.loadDataSuccess(true, teacherService.findById(id));
		}
		return jsonUtil.loadDataSuccess(false, null);
	}
	
	@ResponseBody
	@RequestMapping("/findByIdAndNum.do")
	public Object findByIdAndNum(String id,String num) {
		if (StringUtils.isNotBlank(num) && StringUtils.isNotBlank(id)){
			TeacherExample example = new TeacherExample();
			example.createCriteria().andTeacherNumEqualTo(num).andIdEqualTo(id);
			List<Teacher> list = teacherService.findByExample(example);
			if (null != list && list.size() > 0){
				return list.get(0);
			}
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/findByPage.do")
	public Object findByPage(int page, int limit,
			SearchParam searchParam) {
		
		
		
		return teacherService.findBySearchParam(page, limit, searchParam);
	}


	@ResponseBody
	@RequestMapping("/isRepeat.do")
	public Object isReat(String num){
		
		boolean b = teacherService.isRepeat(num);
		if (!b){
			return jsonUtil.newJson("success", true);
		}
		
		return jsonUtil.newJson("success", false);
	}
	
	@RequestMapping("/exportToExcel.do")
	public void exportToExcel(HttpServletResponse response,String ids,String academyId) {
		List<Teacher> users = null;
		TeacherExample example = new TeacherExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(ids)){
			users = new ArrayList<Teacher>();
			Teacher user = null;
			String[] strings = ids.split(",");
			for (String id : strings){
				user = teacherService.findById(id);
				users.add(user);
			}
		}else {
			if (StringUtils.isNotBlank(academyId)){
				criteria.andAcademyIdEqualTo(academyId);
			}
			users = teacherService.findByExample(example);
		}
	
	try {
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
		
		BeanAndMapUtil beanAndMapUtil = new BeanAndMapUtil();
		listMap = beanAndMapUtil.listMap(users);
		ExportToExcelUtil.exportView(response, listMap, ContantsUtil.teacherColumnNames, ContantsUtil.teacherPropertys,"教工信息");
	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	}

	@ResponseBody
	@RequestMapping("/importFromExcel.do")
	public Object importFromExcel(@RequestParam(value = "uploadFile", required = true)MultipartFile file,
			boolean isCreate,String academyId) {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			
			List<Map<String, Object>> listMap = ImportFromExcelUtil.exportListFromExcel(file, 0,
					ContantsUtil.teacherColumnNames,ContantsUtil.teacherPropertys);
			Teacher user = null;
			for (Map<String, Object> map : listMap){
				user = new Teacher();
				user = (Teacher) BeanAndMapUtil.map2Bean(map, user);
				if (StringUtils.isNotBlank(academyId)){
					user.setAcademyId(academyId);
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
	
	@ResponseBody
	@RequestMapping("/findIdAndNameByAcademy.do")
	public Object findIdAndNameByAcademy(String academyId){
		
		if (StringUtils.isNotBlank(academyId)){
			return teacherService.findIdAndNameByAcademy(academyId);
		}
		return null;
	}
	
	
	

}
