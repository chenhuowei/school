package com.fireway.rolePermission.service;

import java.util.List;

import com.fireway.entity.UserRole;
import com.fireway.entity.UserRoleExample;

public interface UserRoleService {

	void save(UserRole record);
	void deleteByExample(UserRoleExample example);
	void deleteByUserId(String userId);
	List<UserRole> findByUserId(String userId);
}
