package com.fireway.user.service;

import java.util.List;

import com.fireway.entity.User;
import com.fireway.entity.UserExample;
import com.fireway.request.dto.SearchParam;
import com.fireway.utils.PageBean;

public interface UserService {

	void saveUser(User u);
	
	void deleteyId(String id);
	
	void deleteByExample(UserExample example);
	
	void updateByExample(User u, UserExample example);
	
	List<User> findByExample(UserExample example);
	
	User findById(String id);
	
	PageBean<User> findByPage(int page, int rows,UserExample example);
	PageBean<User> findBySearchParam(int page, int rows,SearchParam searchParam);
	
	boolean isRepeat(String userNum);
	
	User findByNumAndPassword(String userNum, String password);
	User findByUserNum(String userNum);
	
	
}
