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

import com.fireway.entity.RolePermission;
import com.fireway.rolePermission.service.RolePermissionService;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
@RequestMapping("/rolePermission")
public class RolePermissionController {

	@Resource
	private RolePermissionService rolePermissionService;
	
	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object save(String roleId,@RequestParam(required=false)String[] permissionIds){
		try {
			RolePermission record = null;
			
			if (StringUtils.isNotBlank(roleId)){
				rolePermissionService.deleteByRoleId(roleId);
				if (null !=permissionIds && permissionIds.length > 0 ){
					for(String permissionId : permissionIds){
						record = new RolePermission();
						record.setId(Utils.uuid());
						record.setPermissionId(permissionId);
						record.setRoleId(roleId);
						rolePermissionService.save(record);
					}
				}
				return jsonUtil.saveSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.saveSuccess(false);
	}
	
	@ResponseBody
	@RequestMapping(value="/findByRole.do")
	public Object findByRole(String roleId){
		if (StringUtils.isNotBlank(roleId)){
			List<RolePermission> list = rolePermissionService.findByRole(roleId);
			Map<String,String> map = new HashMap<String, String>();
			map.put("roleId", roleId);
			StringBuffer rolePermissionIds = new StringBuffer();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				RolePermission rolePermission = (RolePermission) iterator.next();
				rolePermissionIds.append(rolePermission.getPermissionId()).append(",");
			}
			map.put("permissionIds", rolePermissionIds.toString());
			return jsonUtil.loadDataSuccess(true, map);
		}
		return jsonUtil.loadDataSuccess(false, null);
	}
	
	
}
