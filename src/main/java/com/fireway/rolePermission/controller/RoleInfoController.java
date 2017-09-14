package com.fireway.rolePermission.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.base.BaseController;
import com.fireway.entity.RoleInfo;
import com.fireway.entity.RoleInfoExample;
import com.fireway.rolePermission.service.RoleInfoService;
import com.fireway.utils.DateUtil;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
@RequestMapping("/roleInfo")
public class RoleInfoController implements BaseController<RoleInfo> {

	@Resource
	private RoleInfoService roleInfoService;
	
	@RequestMapping("/roleInfoPage.do")
	public String toPage() {
		
		return "role/roleInfoPage";
	}

	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object save(RoleInfo record) {
		try {
			record.setId(Utils.uuid());
			record.setCreateTime(DateUtil.dateTimeFormat(null, new Date()));
			roleInfoService.save(record);
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
				roleInfoService.deleteById(id);
			}
			return jsonUtil.deleteSuccess(true);
		}
		return jsonUtil.deleteSuccess(false);
	}

	@ResponseBody
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public Object update(RoleInfo record) {
		try {
			if (StringUtils.isNotBlank(record.getId())){
				record.setUpdateTime(DateUtil.dateTimeFormat(null, new Date()));
				roleInfoService.updateSelectById(record);
				return jsonUtil.updateSuccess(true); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.updateSuccess(false); 
	}

	@ResponseBody
	@RequestMapping("/findById.do")
	public Object findById(String id) {
		if (StringUtils.isNotBlank(id)){
			return jsonUtil.loadDataSuccess(true, roleInfoService.findById(id));
		}
		return jsonUtil.loadDataSuccess(false, null);
	}

	
	@ResponseBody
	@RequestMapping("/findByPage.do")
	public Object findByPage(int page,int limit,String keyWord){
		
		RoleInfoExample example = new RoleInfoExample();
		if(StringUtils.isNotBlank(keyWord)){
			for(String key : keyWord.split("[,，]")){
				example.or().andRoleNameLike(StringUtils.addLikeStr(key));
			}
		}
		
		return roleInfoService.findByPage(page, limit, example);
	}
	
	@ResponseBody
	@RequestMapping("/findIdAndName.do")
	public Object findIdAndName(){
		
		
		
		return roleInfoService.findIdAndName();
	}
	
	public Object isRepeat(String key) {
		
		return null;
	}

}
