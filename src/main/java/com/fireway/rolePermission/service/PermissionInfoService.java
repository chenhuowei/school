package com.fireway.rolePermission.service;

import java.util.List;
import java.util.Map;

import com.fireway.entity.PermissionInfo;
import com.fireway.entity.PermissionInfoExample;
import com.fireway.utils.PageBean;

public interface PermissionInfoService {

	void save(PermissionInfo record);
	void updateById(PermissionInfo record);
	void deleteById(String id);
	void deleteByExample(PermissionInfoExample example);
	PermissionInfo findById(String id);
	List<PermissionInfo> findByExample(PermissionInfoExample example);
	PageBean<PermissionInfo> findByPage(Integer page,Integer limit,PermissionInfoExample example);
	List<Map<String, String>> findIdAndName();
}
