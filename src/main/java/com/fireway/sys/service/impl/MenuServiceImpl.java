package com.fireway.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.MenuMapper;
import com.fireway.entity.Menu;
import com.fireway.entity.MenuExample;
import com.fireway.entity.MenuExample.Criteria;
import com.fireway.sys.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Resource
	private MenuMapper menuMapper;
	
	public void saveMenu(Menu record) {
		menuMapper.insert(record);
	}

	public void deleteById(String id) {
		menuMapper.deleteByPrimaryKey(id);
	}

	public void updateMenu(Menu record,MenuExample example) {
		menuMapper.updateByExampleSelective(record, example);
	}

	public Menu findById(String id) {

		return menuMapper.selectByPrimaryKey(id);
	}

	public List<Menu> findAll() {

		List<Menu> list = menuMapper.selectByExample(null);
		List<Menu> result = null;
		if (null != list && list.size()>0){
			result = new ArrayList<Menu>();
			for (Menu menu : list){
				if (null != menu.getPid() && !"".equals(menu.getPid())){
					for (Menu menu2 : list){
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
