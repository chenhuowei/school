package com.fireway.rolePermission.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.entity.UserRole;
import com.fireway.rolePermission.service.UserRoleService;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
@RequestMapping("/userRole")
public class UserRoleController {

	@Resource
	private UserRoleService userRoleService;
	
	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object save(String userId,@RequestParam(required=false)String[] roleIds){
		try {
			UserRole record = null;
			if (StringUtils.isNotBlank(userId)){
				userRoleService.deleteByUserId(userId);
				if (null !=roleIds && roleIds.length > 0){
					for(String roleId : roleIds){
						record = new UserRole();
						record.setId(Utils.uuid());
						record.setUserId(userId);
						record.setRoleId(roleId);
						userRoleService.save(record);
					}
					return jsonUtil.saveSuccess(true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.saveSuccess(false);
	}
	
	@ResponseBody
	@RequestMapping(value="/findByUser.do")
	public Object findByUser(String userId){
		if (StringUtils.isNotBlank(userId)){
			List<UserRole> list = userRoleService.findByUserId(userId);
			Map<String,String> map = new HashMap<String, String>();
			map.put("userId", userId);
			StringBuffer roleIds = new StringBuffer();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				UserRole userRole = (UserRole) iterator.next();
				roleIds.append(userRole.getRoleId()).append(",");
			}
			map.put("roleIds", roleIds.toString());
			return jsonUtil.loadDataSuccess(true, map);
		}
		return jsonUtil.loadDataSuccess(false, null);
	}
	
	
}
