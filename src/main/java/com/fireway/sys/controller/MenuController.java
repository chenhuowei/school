package com.fireway.sys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.entity.Menu;
import com.fireway.entity.MenuExample;
import com.fireway.entity.MenuExample.Criteria;
import com.fireway.sys.service.MenuService;
import com.fireway.utils.jsonUtil;

@Controller
public class MenuController {

	private Map<String, Object> json = null;
	
	@Resource
	private MenuService menuService;
	
	@ResponseBody
	@RequestMapping("/menu/list.do")
	public List<Menu> getMenuList(){
		
		
		
		return menuService.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value="/menu/save.do",method=RequestMethod.POST)
	public Object saveMenu(Menu menu){
		
		try {
			if (!menu.getLeaf()){
				menu.setUrl(null);
			}
			if ("".equals(menu.getPid())){
				menu.setPid(null);
			}
			menuService.saveMenu(menu);
			json = jsonUtil.saveSuccess(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			json = jsonUtil.saveSuccess(false);
		}
		
		return json;
	}
	@ResponseBody
	@RequestMapping(value="/menu/delete.do",method=RequestMethod.POST)
	public Object deleteMenu(String id){
		
		try {
			menuService.deleteById(id);
			return jsonUtil.deleteSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			return jsonUtil.deleteSuccess(false);
		}
		
	}
	@ResponseBody
	@RequestMapping(value="/menu/update.do",method=RequestMethod.POST)
	public Object updateMenu(Menu record,String pids){
		
		try {
			
			if (pids != null && !"".equals(pids)){
				if (!"100".equals(pids)){
					record.setPid(pids);
				}
			}
			if (null != record.getLeaf()){
				if ( !record.getLeaf()){
					record.setUrl(null);
				}
			}
			
			MenuExample example = new MenuExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(record.getId());
			menuService.updateMenu(record, example);
			json = jsonUtil.updateSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json = jsonUtil.updateSuccess(false);
		}
		
		return json;
	}
	
	
	
}
