package com.fireway.sys.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireway.base.BaseController;
import com.fireway.entity.TestRecord;
import com.fireway.entity.TestRecordExample;
import com.fireway.sys.service.TestRecordService;
import com.fireway.utils.DateUtil;
import com.fireway.utils.StringUtils;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
@RequestMapping("/testRecord")
public class TestRecordController implements BaseController<TestRecord> {

	@Resource
	private TestRecordService testRecordService;
	
	
	@RequestMapping("/testRecordPage.do")
	public String toPage() {
		
		return "admin/testRecordPage";
	}

	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public Object save(TestRecord record) {
		try {
			record.setId(Utils.uuid());
			record.setCreateTime(DateUtil.dateFormat(null, new Date()));
			testRecordService.save(record);
			return jsonUtil.saveSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonUtil.saveSuccess(false);
	}

	@ResponseBody
	@RequestMapping("/delete.do")
	public Object delete(String ids) {
		try {
			if (StringUtils.isNotBlank(ids)){
				String[] idArray = ids.split(",");
				for(String id : idArray){
					testRecordService.delete(id);
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
	public Object update(TestRecord record) {
		try {
			testRecordService.updateSelectById(record);
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
			return jsonUtil.loadDataSuccess(true, testRecordService.findById(id));
		}
		return jsonUtil.loadDataSuccess(false,null);
	}

	@ResponseBody
	@RequestMapping("/isRepeat.do")
	public Object isRepeat(String key) {
		
		if (testRecordService.isRepeat(key)){
			return jsonUtil.newJson("success", false);
		}
		
		return jsonUtil.newJson("success", true);
	}
	
	@ResponseBody
	@RequestMapping("/findByPage.do")
	public Object findByPage(int page,int limit,String keyWord,boolean status){
		TestRecordExample example = new TestRecordExample();
		if (StringUtils.isNotBlank(keyWord)){
			String[] keys = keyWord.split("[,，]");
			for(String key : keys){
				String value = StringUtils.addLikeStr(key);
				example.or().andTestNameLike(value);
				example.or().andTestCodeLike(value);
			}
		}
		if (status){
			example.createCriteria().andStatusEqualTo(true);
		}
		
		return testRecordService.findByPage(page, limit, example);
	}
	

}
