package com.fireway.sys.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.base.BaseController;
import com.fireway.entity.Location;
import com.fireway.entity.LocationExample;
import com.fireway.sys.service.LocationService;
import com.fireway.utils.DateUtil;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
@RequestMapping("/location")
public class LocationController implements BaseController<Location> {

	@Resource
	private LocationService locationService;
	
	@RequestMapping("/locationPage.do")
	public String toPage() {
		
		return "admin/locationPage";
	}

	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object save(Location record) {
		try {
			record.setId(Utils.uuid());
			record.setCreateTime(DateUtil.dateTimeFormat(null, new Date()));
			locationService.save(record);
			return jsonUtil.saveSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.saveSuccess(false);
	}

	@ResponseBody
	@RequestMapping(value="/delete.do",method=RequestMethod.POST)
	public Object delete(String ids) {
		try {
			if (StringUtils.isNotBlank(ids)){
				String[] values = ids.split(",");
				for (String id : values){
					locationService.delete(id);
				}
				return jsonUtil.deleteSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.deleteSuccess(false);
	}

	@ResponseBody
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public Object update(Location record) {
		try {
			if (null != record){
				record.setUpdateTime(DateUtil.dateTimeFormat(null, new Date()));
				locationService.updateSelectById(record);
				return jsonUtil.updateSuccess(true);
			}
			
		} catch (Exception e) {
		}
		return jsonUtil.updateSuccess(false);
	}

	@ResponseBody
	@RequestMapping("/findById.do")
	public Object findById(String id) {
		if (StringUtils.isNotBlank(id)){
			return jsonUtil.loadDataSuccess(true, locationService.findById(id));
		}
		return jsonUtil.loadDataSuccess(false, null);
	}

	@ResponseBody
	@RequestMapping("/findByPage.do")
	public Object findByPage(int page, int limit, String keyWord){
		LocationExample example = new LocationExample();
		if (StringUtils.isNotBlank(keyWord)){
			String[] values = keyWord.split("[,，]");
			for (String value : values){
				String key = StringUtils.addLikeStr(value);
				
				example.or().andBuildingLike(key);
				example.or().andRoomNumLike(key);
			}
			
		}
		
		return locationService.findyPage(page, limit, example);
	}
	
	
	public Object isRepeat(String key) {
		
		return null;
	}

}
