package com.fireway.sys.service;

import java.util.List;

import com.fireway.base.BaseService;
import com.fireway.entity.MenuList;
import com.fireway.entity.MenuListExample;
import com.fireway.utils.PageBean;

public interface MenuListService extends BaseService<MenuList> {

	List<MenuList> findByExample(MenuListExample example);
	
	PageBean<MenuList> findByPage(int page,int limit,MenuListExample example);
	public List<MenuList> findAll(String type);
}
