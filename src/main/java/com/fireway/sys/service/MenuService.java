package com.fireway.sys.service;

import java.util.List;

import com.fireway.entity.Menu;
import com.fireway.entity.MenuExample;

public interface MenuService {

	void saveMenu(Menu record);
	
	void deleteById(String id);
	
	void updateMenu(Menu record,MenuExample example);
	
	Menu findById(String id);
	
	List<Menu> findAll();
}
