package com.fireway.rolePermission.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.RoleInfoMapper;
import com.fireway.dao.UserRoleMapper;
import com.fireway.entity.RoleInfo;
import com.fireway.entity.RoleInfoExample;
import com.fireway.entity.UserRole;
import com.fireway.entity.UserRoleExample;
import com.fireway.rolePermission.service.RoleInfoService;
import com.fireway.rolePermission.service.UserRoleService;
import com.fireway.utils.PageBean;
import com.github.pagehelper.PageHelper;

@Service("roleInfoService")
public class RoleInfoServiceImpl implements RoleInfoService {

	@Resource
	private RoleInfoMapper roleInfoMapper;
	@Resource
	private UserRoleMapper userRoleMapper;
	
	public void save(RoleInfo record) {
		roleInfoMapper.insert(record);
	}

	public void updateSelectById(RoleInfo record) {
		roleInfoMapper.updateByPrimaryKeySelective(record);
	}

	public void deleteById(String id) {
		roleInfoMapper.deleteByPrimaryKey(id);
	}

	public void deleteByExample(RoleInfoExample example) {
		roleInfoMapper.deleteByExample(example);
	}

	public List<RoleInfo> findByExample(RoleInfoExample example) {

		return roleInfoMapper.selectByExample(example);
	}

	public PageBean<RoleInfo> findByPage(int page, Integer limit, RoleInfoExample example) {
		PageHelper.startPage(page, limit);
		List<RoleInfo> list = findByExample(example);
		return new PageBean<RoleInfo>(list);
	}

	public RoleInfo findById(String id) {
		
		return roleInfoMapper.selectByPrimaryKey(id);
	}

	public List<Map<String, String>> findIdAndName() {
		
		return roleInfoMapper.selectIdAndName();
	}
	public Set<String> findRoleNamesByUserId(String userId) {
		Set<String> roleNames = new HashSet<String>();
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andUserIdEqualTo(userId);
		List<UserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);
		if (null != userRoles && userRoles.size() > 0) {
			for(UserRole userRole : userRoles){
				RoleInfo roleInfo = roleInfoMapper.selectByPrimaryKey(userRole.getRoleId());
				roleNames.add(roleInfo.getRoleName());
			}
			return roleNames;
		}
		return null;
	}

}
