package com.fireway.rolePermission.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.PermissionInfoMapper;
import com.fireway.entity.PermissionInfo;
import com.fireway.entity.PermissionInfoExample;
import com.fireway.rolePermission.service.PermissionInfoService;
import com.fireway.utils.PageBean;
import com.github.pagehelper.PageHelper;

@Service("permissionInfoService")
public class PermissionInfoServiceImpl implements PermissionInfoService {

	@Resource
	private PermissionInfoMapper permissionInfoMapper;
	
	public void save(PermissionInfo record) {
		permissionInfoMapper.insert(record);
	}

	public void updateById(PermissionInfo record) {
		permissionInfoMapper.updateByPrimaryKeySelective(record);
	}

	public void deleteById(String id) {
		permissionInfoMapper.deleteByPrimaryKey(id);
	}

	public void deleteByExample(PermissionInfoExample example) {
		permissionInfoMapper.deleteByExample(example);
	}

	public List<PermissionInfo> findByExample(PermissionInfoExample example) {

		return permissionInfoMapper.selectByExample(example);
	}

	public PageBean<PermissionInfo> findByPage(Integer page, Integer limit, PermissionInfoExample example) {

		PageHelper.startPage(page, limit);
		
		return new PageBean<PermissionInfo>(findByExample(example));
	}

	public PermissionInfo findById(String id) {
		
		return permissionInfoMapper.selectByPrimaryKey(id);
	}

	public List<Map<String, String>> findIdAndName() {
		
		return permissionInfoMapper.selectIdAndName();
	}

}
