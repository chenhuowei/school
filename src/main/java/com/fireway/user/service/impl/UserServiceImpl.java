package com.fireway.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.UserMapper;
import com.fireway.entity.User;
import com.fireway.entity.UserExample;
import com.fireway.entity.UserExample.Criteria;
import com.fireway.request.dto.SearchParam;
import com.fireway.user.service.UserService;
import com.fireway.utils.PageBean;
import com.fireway.utils.StringUtils;
import com.github.pagehelper.PageHelper;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	public void saveUser(User u) {
		userMapper.insert(u);
	}

	public void deleteyId(String id) {
		userMapper.deleteByPrimaryKey(id);
	}

	public void deleteByExample(UserExample example) {
		userMapper.deleteByExample(example);
	}

	public void updateByExample(User u, UserExample example) {
		userMapper.updateByExampleSelective(u, example);
	}

	public List<User> findByExample(UserExample example) {
		
		return userMapper.selectByExample(example);
	}

	public User findById(String id) {
		 
		return userMapper.selectByPrimaryKey(id);
	}

	public PageBean<User> findByPage(int page, int rows,UserExample example) {
		
		PageHelper.startPage(page, rows);
		List<User> list = userMapper.selectByPage(example);
		
		return new PageBean<User>(list);
	}

	public boolean isRepeat(String userNum) {
		
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if (!StringUtils.isBlank(userNum)){
			criteria.andUserNumEqualTo(userNum);
		}
		int count = userMapper.countByExample(example);
		
		if (count <=0){
			
			return false;
		}else{
			return true;
		}
	}

	public User findByNumAndPassword(String userNum,String password) {
		
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if (!StringUtils.isBlank(userNum) && !StringUtils.isBlank(password)){
			criteria.andUserNumEqualTo(userNum);
			criteria.andPasswordEqualTo(password);
			List<User> list = findByExample(example);
			
			if (null != list && list.size() == 1){
				return list.get(0);
			}
		}
		
		
		return null;
	}

	public PageBean<User> findBySearchParam(int page, int rows, SearchParam searchParam) {
		PageHelper.startPage(page, rows);
		List<User> list = userMapper.selectBySearchParam(searchParam);
		
		return new PageBean<User>(list);
	}

	public User findByUserNum(String userNum) {
		UserExample example = new UserExample();
		example.createCriteria().andUserNumEqualTo(userNum);
		List<User> list = findByExample(example);
		if (null !=list && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	
	
}
