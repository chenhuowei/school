package com.fireway.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.MenuListMapper;
import com.fireway.entity.Menu;
import com.fireway.entity.MenuList;
import com.fireway.entity.MenuListExample;
import com.fireway.sys.service.MenuListService;
import com.fireway.utils.PageBean;
import com.fireway.utils.StringUtils;
import com.github.pagehelper.PageHelper;

@Service("menuListService")
public class MenuListSerivceImpl implements MenuListService {

	@Resource
	private MenuListMapper menuListMapper;
	
	
	public void save(MenuList record) {
		menuListMapper.insert(record);
	}

	public void delete(String id) {
		menuListMapper.deleteByPrimaryKey(id);
	}

	public void updateSelectById(MenuList record) {
		menuListMapper.updateByPrimaryKeySelective(record);
	}

	public void updateById(MenuList record) {
		menuListMapper.updateByPrimaryKey(record);
	}

	public MenuList findById(String id) {

		return menuListMapper.selectByPrimaryKey(id);
	}

	public boolean isRepeat(String key) {

		return false;
	}

	public List<MenuList> findByExample(MenuListExample example) {

		return menuListMapper.selectByExample(example);
	}

	public PageBean<MenuList> findByPage(int page, int limit, MenuListExample example) {
		PageHelper.startPage(page, limit);
		List<MenuList> list = findByExample(example);
		return new PageBean<MenuList>(list);
	}
	
	public List<MenuList> findAll(String type) {
		MenuListExample example = new MenuListExample();
		example.createCriteria().andTypeEqualTo(type);
		List<MenuList> list = menuListMapper.selectByExample(example);
		List<MenuList> result = null;
		if (null != list && list.size()>0){
			result = new ArrayList<MenuList>();
			for (MenuList menu : list){
				if (StringUtils.isNotBlank(menu.getPid())){
					for (MenuList menu2 : list){
						if (menu.getPid().equals(menu2.getId())){
							menu2.getChildren().add(menu);
						}
					}
				}else {
					result.add(menu);
				}
			}
			
		}
		
		return result;
	}
	
	
	
	

}
