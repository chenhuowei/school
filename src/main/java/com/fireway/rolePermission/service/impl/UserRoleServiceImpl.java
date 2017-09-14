package com.fireway.rolePermission.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.UserRoleMapper;
import com.fireway.entity.UserRole;
import com.fireway.entity.UserRoleExample;
import com.fireway.rolePermission.service.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	@Resource
	private UserRoleMapper userRoleMapper;
	
	public void save(UserRole record) {
		userRoleMapper.insert(record);
	}

	public void deleteByExample(UserRoleExample example) {
		userRoleMapper.deleteByExample(example);
	}

	public void deleteByUserId(String userId) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUserIdEqualTo(userId);
		deleteByExample(example);
	}

	public List<UserRole> findByUserId(String userId) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUserIdEqualTo(userId);
		return userRoleMapper.selectByExample(example);
	}

}
