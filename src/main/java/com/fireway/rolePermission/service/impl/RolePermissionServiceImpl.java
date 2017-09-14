package com.fireway.rolePermission.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.RolePermissionMapper;
import com.fireway.entity.RolePermission;
import com.fireway.entity.RolePermissionExample;
import com.fireway.rolePermission.service.RolePermissionService;

@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {

	@Resource
	private RolePermissionMapper rolePermissionMapper;
	
	public void save(RolePermission record) {
		rolePermissionMapper.insert(record);
	}

	public void deleteByExample(RolePermissionExample example) {
		rolePermissionMapper.deleteByExample(example);
	}

	public void deleteByRoleId(String roleId) {
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		deleteByExample(example);
	}

	public List<RolePermission> findByRole(String roleId) {
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		return rolePermissionMapper.selectByExample(example);
	}

}
