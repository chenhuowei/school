package com.fireway.sys.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.entity.Menu;
import com.fireway.entity.MenuList;
import com.fireway.entity.MenuListExample;
import com.fireway.sys.service.MenuListService;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

@Controller
@RequestMapping("/menuList")
public class MenuListController  {

	@Resource
	private MenuListService menuListService;
	
	@RequestMapping("/menuListPage.do")
	public String toPage() {
		
		return "admin/menuListPage";
	}

	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object save(MenuList record) {
		try {
			record.setId(Utils.uuid());
			if (StringUtils.isNotBlank(record.getPid())){
				record.setLeaf(true);
			}else {
				record.setLeaf(false);
			}
			menuListService.save(record);
			return jsonUtil.saveSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.saveSuccess(false);
	}

	@ResponseBody
	@RequestMapping("/delete.do")
	public Object delete(String ids) {
		if (StringUtils.isNotBlank(ids)){
			for(String id : ids.split(",")){
				menuListService.delete(id);
			}
			return jsonUtil.deleteSuccess(true);
		}
		return jsonUtil.deleteSuccess(false);
	}

	@ResponseBody
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public Object update(MenuList record) {
		try {
			if (StringUtils.isNotBlank(record.getPid())){
				record.setLeaf(true);
			}else {
				record.setLeaf(false);
			}
			menuListService.updateSelectById(record);
			return jsonUtil.updateSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.updateSuccess(false);
	}

	@ResponseBody
	@RequestMapping("/findById.do")
	public Object findById(String id) {
		if (StringUtils.isNotBlank(id)){
			return jsonUtil.loadDataSuccess(true, menuListService.findById(id));
		}
		return jsonUtil.loadDataSuccess(false, null);
	}

	@ResponseBody
	@RequestMapping("/findByPage.do")
	public Object findByPage(int page,int limit,String keyWord){
		MenuListExample example = new MenuListExample();
		if (StringUtils.isNotBlank(keyWord)){
			for(String key : keyWord.split("[,，]")){
				String value = StringUtils.addLikeStr(key);
				example.or().andTextLike(value);
				example.or().andUrlLike(value);
			}
		}
		return  menuListService.findByPage(page, limit, example);
	}
	
	@ResponseBody
	@RequestMapping("/findMenu.do")
	public Object findMenu(@RequestParam(value="pid",required=false)String pid){
		MenuListExample example = new MenuListExample();
		if (StringUtils.isNotBlank(pid)){
			example.createCriteria().andPidEqualTo(pid);
			return menuListService.findByExample(example);
		}else {
			example.or().andPidIsNull();
			example.or().andPidEqualTo("");
			return menuListService.findByExample(example);
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/findIdAndText.do")
	public Object findIdAndText(@RequestParam(value="pid",required=false)String pid,
			@RequestParam(required=false)String type){
		MenuListExample example = new MenuListExample();
		if (StringUtils.isNotBlank(pid)){
			example.createCriteria().andPidEqualTo(pid);
			return menuListService.findByExample(example);
		}else {
			example.or().andPidIsNull().andTypeEqualTo(type);
			example.or().andPidEqualTo("").andTypeEqualTo(type);
			return menuListService.findByExample(example);
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/list.do")
	public List<MenuList> getMenuList(String type){
		
		
		
		return menuListService.findAll(type);
	}
	
	
	

}
