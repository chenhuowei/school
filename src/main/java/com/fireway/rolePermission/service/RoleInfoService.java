package com.fireway.rolePermission.service;


import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fireway.entity.RoleInfo;
import com.fireway.entity.RoleInfoExample;
import com.fireway.utils.PageBean;

public interface RoleInfoService {

	void save(RoleInfo record);
	void updateSelectById(RoleInfo record);
	void deleteById(String id);
	void deleteByExample(RoleInfoExample example);
	List<RoleInfo> findByExample(RoleInfoExample example);
	RoleInfo findById (String id);
	PageBean<RoleInfo> findByPage(int page ,Integer limit,RoleInfoExample example);
	List<Map<String, String>> findIdAndName();
	
	Set<String> findRoleNamesByUserId(String userId);
	
}
