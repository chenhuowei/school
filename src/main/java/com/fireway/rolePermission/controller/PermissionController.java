package com.fireway.rolePermission.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.base.BaseController;
import com.fireway.entity.PermissionInfo;
import com.fireway.entity.PermissionInfoExample;
import com.fireway.rolePermission.service.PermissionInfoService;
import com.fireway.utils.DateUtil;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
@RequestMapping("/permissionInfo")
public class PermissionController implements BaseController<PermissionInfo> {

	@Resource
	private PermissionInfoService permissionInfoService;
	
	@RequestMapping("/permissionInfoPage.do")
	public String toPage() {
		
		return "role/permissionInfoPage";
	}

	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object save(PermissionInfo record) {
		try {
			record.setId(Utils.uuid());
			record.setCreateTime(DateUtil.dateTimeFormat(null, new Date()));
			permissionInfoService.save(record);
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
			for (String id : ids.split(",")){
				permissionInfoService.deleteById(id);
			}
			return jsonUtil.deleteSuccess(true);
		}
		return jsonUtil.deleteSuccess(false);
	}

	@ResponseBody
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public Object update(PermissionInfo record) {
		try {
			if (StringUtils.isNotBlank(record.getId())){
				record.setUpdateTime(DateUtil.dateTimeFormat(null, new Date()));
				permissionInfoService.updateById(record);
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
			return jsonUtil.loadDataSuccess(true, permissionInfoService.findById(id));
		}
		return jsonUtil.loadDataSuccess(false, null);
	}

	@ResponseBody
	@RequestMapping("/findByPage.do")
	public Object findByPage(int page,int limit,String keyWord) {
		PermissionInfoExample example = null;
		if (StringUtils.isNotBlank(keyWord)){
				example = new PermissionInfoExample();
			for(String key : keyWord.split("[，,]")){
				example.or().andPermissionNameLike(StringUtils.addLikeStr(key));
			}
		}
		return permissionInfoService.findByPage(page, limit, example);
	}
	
	@ResponseBody
	@RequestMapping("/findIdAndName.do")
	public Object findIdAndName() {
		
		return permissionInfoService.findIdAndName();
	}
	
	public Object isRepeat(String key) {
		
		return null;
	}

}
