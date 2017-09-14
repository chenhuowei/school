package com.fireway.user.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;

import com.fireway.utils.BeanAndMapUtil;
import com.fireway.utils.ContantsUtil;
import com.fireway.utils.DateUtil;
import com.fireway.utils.Encrypt;
import com.fireway.utils.ExportToExcelUtil;
import com.fireway.utils.ImportFromExcelUtil;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.fireway.entity.User;
import com.fireway.entity.UserExample;
import com.fireway.entity.UserExample.Criteria;
import com.fireway.request.dto.SearchParam;
import com.fireway.request.dto.SearchParams;
import com.fireway.user.service.UserService;
import com.fireway.utils.jsonUtil;

@Controller
public class UserController {

	@Resource
	private UserService userService;
	
	
	@RequestMapping("/user/adminPage.do")
	public String toAdminPage(){
		
		
		return "admin/adminPage";
	}
	
	@ResponseBody
	@RequestMapping(value="/user/save.do",method=RequestMethod.POST)
	public Object saveUser(User user){
		
		try {
			//计算用户年龄
			user.setAge(Utils.getAge(user.getBirth()));
			user.setId(UUID.randomUUID().toString());
			user.setPassword(Encrypt.md5Encode(user.getPassword2()));
			user.setCreateTime(DateUtil.dateTimeFormat(null, new Date()));
			user.setRegisTime(DateUtil.dateTimeFormat(null, new Date()));
			userService.saveUser(user);
			return jsonUtil.saveSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			return jsonUtil.saveSuccess(false);
			
		}
		
	}
	
	@RequiresRoles("superadmin")
	@ResponseBody
	@RequestMapping(value="/user/delete.do",method=RequestMethod.POST)
	public Object deleteUser(String ids){
		
		try {
			if (!StringUtils.isBlank(ids)){
				
				String[] idArray = ids.split(",");
				for(String id : idArray){
					userService.deleteyId(id);
				}
				
			}
			return jsonUtil.deleteSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			return jsonUtil.deleteSuccess(false);
			
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/user/update.do",method=RequestMethod.POST)
	public Object updateUser(User user,HttpServletRequest request,boolean refresh){
		
		try {
			if (null != user ){
				if (StringUtils.isNotBlank(user.getBirth())){
					
					user.setAge(Utils.getAge(user.getBirth()));
				}
				user.setUpdateTime(DateUtil.dateTimeFormat(null, new Date()));
				
				UserExample example = new UserExample();
				Criteria criteria = example.createCriteria();
				if (StringUtils.isNotBlank(user.getId())){
					criteria.andIdEqualTo(user.getId());
				}
				if (StringUtils.isNotBlank(user.getUserNum())){
					criteria.andUserNumEqualTo(user.getUserNum());
				}
				userService.updateByExample(user, example);
				if (refresh){
					request.getSession().setAttribute(ContantsUtil.USER, userService.findById(user.getId()));
				}
				
			}
			
			return jsonUtil.updateSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			return jsonUtil.updateSuccess(false);
			
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/user/findByIdOrNum.do",method=RequestMethod.GET)
	public Object findById(String id, String num){
		
		User user = null;
		try {
			if (!StringUtils.isBlank(id)){
				 user = userService.findById(id);
			}
			
			if (!StringUtils.isBlank(num) && !StringUtils.isBlank(id)){
				return userService.findById(id);
			}
			return jsonUtil.loadDataSuccess(true, user);
		} catch (Exception e) {
			e.printStackTrace();
			return jsonUtil.loadSuccess(false);
			
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/user/findByPage.do",method=RequestMethod.GET)
	public Object findByPage(int page, int limit, SearchParam searchParam){
		
	
			
			return userService.findBySearchParam(page, limit, searchParam);
		
		
	}
	
	@ResponseBody
	@RequestMapping("/user/isRepeat.do")
	public Object isRepeat(String userNum){
		try {
			
			if (!userService.isRepeat(userNum)){
				return jsonUtil.newJson("success", true);
			}
		} catch (Exception e) {
			return jsonUtil.newJson("success", false);
		}
		return jsonUtil.newJson("success", false);
	}
	
	@ResponseBody
	@RequestMapping(value="/user/updatePassword.do",method=RequestMethod.POST)
	public Object updatePassword(String num, String oldPassword,String newPassword){
		try {
			if (!StringUtils.isBlank(oldPassword) && !StringUtils.isBlank(newPassword)){
				//vaild old password
				UserExample example = new UserExample();
				Criteria criteria = example.createCriteria();
				User user = userService.findByNumAndPassword(num, Encrypt.md5Encode(oldPassword));
				if (null != user){
					user.setPassword2(newPassword);
					user.setPassword(Encrypt.md5Encode(newPassword));
					criteria.andUserNumEqualTo(num);
					userService.updateByExample(user, example);
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
	@RequestMapping(value="/user/exportToExcel.do")
	public void exportToExcel(HttpServletResponse response,String ids){
		
		List<User> users = null;
			if (StringUtils.isNotBlank(ids)){
				users = new ArrayList<User>();
				User user = null;
				String[] strings = ids.split(",");
				for (String id : strings){
					user = userService.findById(id);
					users.add(user);
				}
			}else {
				
				users = userService.findByExample(null);
			}
		
		
		
		
		try {
			List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
			
			BeanAndMapUtil beanAndMapUtil = new BeanAndMapUtil();
			listMap = beanAndMapUtil.listMap(users);
			ExportToExcelUtil.exportView(response, listMap, ContantsUtil.userColumnNames, ContantsUtil.userPropertys,"用户信息");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	@ResponseBody
	@RequestMapping(value="/user/importFromExcel.do")
	public Object importFromExcel(@RequestParam(value = "uploadFile", required = true)MultipartFile file,boolean isCreate){
		  
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			
			List<Map<String, Object>> listMap = ImportFromExcelUtil.exportListFromExcel(file, 0,
					ContantsUtil.userColumnNames,ContantsUtil.userPropertys);
			User user = null;
			for (Map<String, Object> map : listMap){
				user = new User();
				user = (User) BeanAndMapUtil.map2Bean(map, user);
				if (isCreate){
					saveUser(user);
				}else {
					updateUser(user, null, false);
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
