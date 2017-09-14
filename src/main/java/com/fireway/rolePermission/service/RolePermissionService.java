package com.fireway.rolePermission.service;

import java.util.List;

import com.fireway.entity.RolePermission;
import com.fireway.entity.RolePermissionExample;

public interface RolePermissionService {

	void save(RolePermission record);
	List<RolePermission> findByRole (String roleId);
	void deleteByRoleId(String roleId);
	
}
