package com.fireway.sys.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.base.BaseController;
import com.fireway.entity.SchoolMessage;
import com.fireway.entity.SchoolMessageExample;
import com.fireway.sys.service.SchoolMessageService;
import com.fireway.utils.DateUtil;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
@RequestMapping("/schoolMessage")
public class SchoolMessageController implements BaseController<SchoolMessage> {

	@Resource
	private SchoolMessageService schoolMessageService;
	
	@RequestMapping("/schoolMessagePage.do")
	public String toPage() {
		
		return "admin/schoolMessagePage";
	}
	
	@RequestMapping("/findMessage.do")
	public String findMessage(HttpServletRequest request) {
			SchoolMessageExample example = new SchoolMessageExample();
			example.createCriteria().andSendStatusEqualTo(1).andStatusEqualTo(true);
			example.setOrderByClause("SEND_TIME DESC");
		request.setAttribute("schoolMessages",schoolMessageService.findByExample(example) );
		return "admin/findMessage";
	}

	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object save(SchoolMessage record) {
		try {
			record.setId(Utils.uuid());
			record.setCreateTime(DateUtil.dateTimeFormat(null, new Date()));
			schoolMessageService.save(record);
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
			String[] array = ids.split(",");
			for(String id :array){
				schoolMessageService.delete(id);
			}
			return jsonUtil.deleteSuccess(true);
		}
		return jsonUtil.deleteSuccess(false);
	}

	@ResponseBody
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public Object update(SchoolMessage record) {
		try {
			if (null != record.getSendStatus()){
				if (record.getSendStatus() == 1){
					record.setSendTime(DateUtil.dateTimeFormat(null, new Date()));
				}
			}
			record.setUpdateTime(DateUtil.dateTimeFormat(null, new Date()));
			schoolMessageService.updateSelectById(record);
			return jsonUtil.updateSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.updateSuccess(true);
	}

	@ResponseBody
	@RequestMapping("/findById.do")
	public Object findById(String id) {
		if (StringUtils.isNotBlank(id)){
			return jsonUtil.loadDataSuccess(true, schoolMessageService.findById(id));
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/findByPage.do")
	public Object findByPage(int page,int limit,String keyWord,
			@RequestParam(required=false)Integer sendStatus) {
		SchoolMessageExample example = new SchoolMessageExample();
		
		if (null != sendStatus){
			example.createCriteria().andSendStatusEqualTo(sendStatus);
		}
		
		return schoolMessageService.findByPage(page, limit, example);
	}

	
	
	
	public Object isRepeat(String key) {
		
		return null;
	}

}
